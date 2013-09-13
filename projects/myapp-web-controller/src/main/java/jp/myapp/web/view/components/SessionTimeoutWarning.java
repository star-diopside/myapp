package jp.myapp.web.view.components;

import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import jp.myapp.core.exception.SystemException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class SessionTimeoutWarning extends Component {

    /** セッションタイムアウト警告時間(分)のデフォルト値 */
    private static final Integer DEF_TIME = Integer.valueOf(3);

    private HttpSession session;
    private String time;

    public SessionTimeoutWarning(ValueStack stack, HttpSession session) {
        super(stack);
        this.session = session;
    }

    @Override
    public boolean start(Writer writer) {
        boolean result = super.start(writer);

        ResourceBundle message = ResourceBundle.getBundle("MessageResources");
        Integer timeValue;

        if (StringUtils.isEmpty(this.time)) {
            timeValue = DEF_TIME;
        } else {
            timeValue = (Integer) findValue(this.time, Integer.class);
            if (timeValue == null) {
                timeValue = DEF_TIME;
            }
        }

        int sessionTimeout = this.session.getMaxInactiveInterval();
        int warningTime = Math.min(sessionTimeout, timeValue.intValue() * 60);
        int waitTime = (sessionTimeout - warningTime) * 1000;

        try {
            writer.write("<script type=\"text/javascript\">");
            writer.write(SystemUtils.LINE_SEPARATOR);
            writer.write("<!--");
            writer.write(SystemUtils.LINE_SEPARATOR);

            writer.write("$(function(){");

            writer.write("setTimeout(function(){alert(\"");
            writer.write(MessageFormat.format(message.getString("Warning.SessionTimeout"),
                    String.valueOf(warningTime / 60)));
            writer.write("\")},");
            writer.write(String.valueOf(waitTime));
            writer.write(");");

            writer.write("});");

            writer.write(SystemUtils.LINE_SEPARATOR);
            writer.write("// -->");
            writer.write(SystemUtils.LINE_SEPARATOR);
            writer.write("</script>");
            writer.write(SystemUtils.LINE_SEPARATOR);

        } catch (IOException e) {
            throw new SystemException(e);
        }

        return result;
    }

    /**
     * セッションタイムアウト警告時間を設定する。
     * 
     * @param time セッションタイムアウト警告時間(分)
     */
    public void setTime(String time) {
        this.time = time;
    }
}
