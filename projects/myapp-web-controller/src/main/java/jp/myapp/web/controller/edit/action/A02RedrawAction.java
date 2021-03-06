package jp.myapp.web.controller.edit.action;

import java.util.Map;

import jp.myapp.web.controller.edit.model.A02RedrawModel;
import jp.myapp.web.controller.edit.model.A02RedrawModelImpl;
import jp.myapp.web.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class A02RedrawAction extends ActionSupport implements ModelDriven<A02RedrawModel>, SessionAware {

    private static final long serialVersionUID = 1L;

    private A02RedrawModel model = new A02RedrawModelImpl();
    private Map<String, Object> session;

    @Override
    public A02RedrawModel getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        (new SessionUtils(this.session)).setForm(this.model.getA02Form());

        return SUCCESS;
    }
}
