package jp.myapp.controller.auth.action;

import java.util.Map;

import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.model.AA01S010Model;
import jp.myapp.controller.auth.model.AA01S010ModelImpl;
import jp.myapp.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AA01S010Action extends ActionSupport implements ModelDriven<AA01S010Model>, SessionAware {

    private static final long serialVersionUID = 1L;

    private AA01S010Model model = new AA01S010ModelImpl();
    private Map<String, Object> session;

    @Override
    public AA01S010Model getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        AA01S010Form outForm = (new SessionUtils(this.session)).getForm(AA01S010Form.class);

        if (outForm == null) {
            outForm = this.model.getAA01S010Form();
        } else {
            this.model.setAA01S010Form(outForm);
        }

        if (Boolean.TRUE.equals(this.model.getLoginError())) {
            this.addActionError(this.getText("Error.NotMatchUserIdOrPassword"));
        }

        return SUCCESS;
    }
}
