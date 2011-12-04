package jp.myapp.controller.edit.action;

import java.util.Map;

import jp.myapp.controller.edit.form.A01Form;
import jp.myapp.controller.edit.model.A01OpenModel;
import jp.myapp.controller.edit.model.A01OpenModelImpl;
import jp.myapp.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A01OpenAction extends ActionSupport implements ModelDriven<A01OpenModel>, SessionAware {

    private static final long serialVersionUID = 1L;

    private A01OpenModel model = new A01OpenModelImpl();
    private Map<String, Object> session;

    @Override
    public A01OpenModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        A01Form outForm = (new SessionUtils(this.session)).getForm(A01Form.class);

        if (outForm != null) {
            this.model.setA01Form(outForm);
        }

        return SUCCESS;
    }
}