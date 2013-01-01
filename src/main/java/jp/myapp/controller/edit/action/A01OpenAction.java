package jp.myapp.controller.edit.action;

import java.util.Map;

import jp.myapp.controller.edit.form.A01Form;
import jp.myapp.controller.edit.model.A01OpenModel;
import jp.myapp.controller.edit.model.A01OpenModelImpl;
import jp.myapp.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
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
