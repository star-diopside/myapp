package jp.myapp.view.components;

import java.io.PrintWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

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

        Integer timeValue = (Integer) findValue(this.time, Integer.class);

        if (timeValue == null) {
            timeValue = DEF_TIME;
        }

        int sessionTimeout = this.session.getMaxInactiveInterval();
        int warningTime = Math.min(sessionTimeout, timeValue * 60);
        int waitTime = (sessionTimeout - warningTime) * 1000;

        PrintWriter out = new PrintWriter(writer);

        out.println("<script type=\"text/javascript\">");
        out.println("<!--");

        out.print("$(function(){");

        out.print("setTimeout(function(){alert(\"");
        out.print(MessageFormat.format(message.getString("Warning.SessionTimeout"), warningTime / 60));
        out.print("\")},");
        out.print(waitTime);
        out.print(");");

        out.print("});");

        out.println();
        out.println("// -->");
        out.println("</script>");

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
