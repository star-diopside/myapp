package jp.myapp.web.controller.edit.action;

import java.util.Map;

import jp.myapp.data.mapper.management.UsersMapper;
import jp.myapp.service.logic.LoginService;
import jp.myapp.web.controller.edit.form.A01Form;
import jp.myapp.web.controller.edit.form.A02Form;
import jp.myapp.web.controller.edit.model.A01LoginModel;
import jp.myapp.web.controller.edit.model.A01LoginModelImpl;
import jp.myapp.web.controller.edit.validation.A01Validation;
import jp.myapp.web.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class A01LoginAction extends ActionSupport implements ModelDriven<A01LoginModel>, A01Validation, SessionAware {

    private static final long serialVersionUID = 1L;

    private A01LoginModel model = new A01LoginModelImpl();
    private Map<String, Object> session;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public A01LoginModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        A01Form inForm = this.model.getA01Form();

        // ログインチェック
        this.loginService.loginUser(inForm.getUserId(), inForm.getPassword());

        // 出力情報の設定
        A02Form outForm = this.model.getA02Form();

        outForm.setUserId(inForm.getUserId());
        outForm.setUserInfoList(this.usersMapper.selectAll());
        (new SessionUtils(this.session)).setForm(outForm);

        return SUCCESS;
    }
}
