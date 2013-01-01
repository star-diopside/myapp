package jp.myapp.controller.edit.action;

import jp.myapp.controller.edit.form.A04Form;
import jp.myapp.controller.edit.form.A04FormImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class A04OpenAction extends ActionSupport implements ModelDriven<A04Form> {

    private static final long serialVersionUID = 1L;

    private A04Form model = new A04FormImpl();

    @Override
    public A04Form getModel() {
        return this.model;
    }
}
