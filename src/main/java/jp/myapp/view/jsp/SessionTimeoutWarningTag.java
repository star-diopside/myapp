package jp.myapp.view.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.view.components.SessionTimeoutWarning;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class SessionTimeoutWarningTag extends ComponentTagSupport {

    private static final long serialVersionUID = 270353035162329101L;

    private String time;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new SessionTimeoutWarning(stack, req.getSession());
    }

    @Override
    protected void populateParams() {
        super.populateParams();
        ((SessionTimeoutWarning) this.component).setTime(time);
    }

    /**
     * �Z�b�V�����^�C���A�E�g�x�����Ԃ�ݒ肷��B
     * 
     * @param time �Z�b�V�����^�C���A�E�g�x������(��)
     */
    public void setTime(String time) {
        this.time = time;
    }
}
