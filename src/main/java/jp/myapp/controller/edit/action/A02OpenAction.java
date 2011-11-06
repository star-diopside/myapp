package jp.myapp.controller.edit.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import jp.myapp.controller.edit.form.A02Form;
import jp.myapp.controller.edit.model.A02OpenModel;
import jp.myapp.controller.edit.model.A02OpenModelImpl;
import jp.myapp.controller.util.SessionUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A02OpenAction extends ActionSupport implements ModelDriven<A02OpenModel>, SessionAware {

    private static final long serialVersionUID = 1L;

    private A02OpenModel model = new A02OpenModelImpl();
    private Map<String, Object> session;

    @Override
    public A02OpenModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        A02Form outForm = (new SessionUtils(this.session)).getForm(A02Form.class);

        if (outForm != null) {
            this.model.setA02Form(outForm);
        }

        return SUCCESS;
    }
}
