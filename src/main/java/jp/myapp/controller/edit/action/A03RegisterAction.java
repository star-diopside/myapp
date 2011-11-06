package jp.myapp.controller.edit.action;

import java.util.Map;

import jp.myapp.controller.edit.form.A03Form;
import jp.myapp.controller.edit.model.A03RegisterModel;
import jp.myapp.controller.edit.model.A03RegisterModelImpl;
import jp.myapp.controller.edit.validation.A03Validation;
import jp.myapp.service.LoginService;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A03RegisterAction extends ActionSupport implements ModelDriven<A03RegisterModel>, SessionAware,
        A03Validation {

    private static final long serialVersionUID = 1L;

    private A03RegisterModel model = new A03RegisterModelImpl();

    private Map<String, Object> session;

    @Autowired
    private LoginService loginService;

    @Override
    public A03RegisterModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        A03Form inForm = this.model.getA03Form();

        if (!StringUtils.equals((String) this.session.get(Constants.KAPTCHA_SESSION_KEY), inForm.getCaptcha())) {
            this.addActionError(this.getText("Error.NotMatchCaptcha"));
            inForm.setCaptcha(StringUtils.EMPTY);
            return INPUT;
        }

        this.loginService.registerUser(inForm.getUserId(), inForm.getUserName(), inForm.getPassword());

        return SUCCESS;
    }
}
