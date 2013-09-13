package jp.myapp.web.controller.auth.action;

import java.util.Map;

import jp.myapp.service.logic.LoginService;
import jp.myapp.web.controller.auth.form.AA01S010Form;
import jp.myapp.web.controller.auth.form.AA02S010Form;
import jp.myapp.web.controller.auth.model.AA02S010RegisterModel;
import jp.myapp.web.controller.auth.model.AA02S010RegisterModelImpl;
import jp.myapp.web.controller.auth.validation.AA02S010Validation;
import jp.myapp.web.controller.util.SessionUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class AA02S010RegisterAction extends ActionSupport implements ModelDriven<AA02S010RegisterModel>, SessionAware,
        AA02S010Validation {

    private static final long serialVersionUID = 1L;

    private AA02S010RegisterModel model = new AA02S010RegisterModelImpl();

    private Map<String, Object> session;

    @Autowired
    private LoginService loginService;

    @Override
    public AA02S010RegisterModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void validate() {

        AA02S010Form inForm = this.model.getAA02S010Form();

        // Captchaの一致チェックを行う。
        if (!StringUtils.equals((String) this.session.get(Constants.KAPTCHA_SESSION_KEY), inForm.getCaptcha())) {
            this.addActionError(this.getText("Error.NotMatchCaptcha"));
            inForm.setCaptcha(StringUtils.EMPTY);
        }
    }

    @Override
    public String execute() throws Exception {

        AA02S010Form inForm = this.model.getAA02S010Form();

        // ユーザを登録する。
        this.loginService.registerUser(inForm.getUserId(), inForm.getUserName(), inForm.getPassword());

        // 次画面の編集を行う。
        AA01S010Form outForm = this.model.getAA01S010Form();
        outForm.setUserId(inForm.getUserId());
        (new SessionUtils(this.session)).setForm(outForm);

        return SUCCESS;
    }
}
