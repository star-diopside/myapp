package jp.myapp.view.tag;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SessionTimeoutWarningTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    /** セッションタイムアウト警告時間(分) */
    private Integer time = 3;

    @Override
    public int doStartTag() throws JspException {

        ResourceBundle message = ResourceBundle.getBundle("MessageResources");

        int sessionTimeout = this.pageContext.getSession().getMaxInactiveInterval();
        int warningTime = Math.min(sessionTimeout, this.time * 60);
        int waitTime = (sessionTimeout - warningTime) * 1000;

        JspWriter out = this.pageContext.getOut();

        try {
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

        } catch (IOException e) {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
