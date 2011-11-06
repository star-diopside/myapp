package jp.myapp.controller.edit.action;

import jp.myapp.controller.edit.model.A01OpenModel;
import jp.myapp.controller.edit.model.A01OpenModelImpl;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A01OpenAction extends ActionSupport implements ModelDriven<A01OpenModel> {

    private static final long serialVersionUID = 1L;

    private A01OpenModel model = new A01OpenModelImpl();

    @Override
    public A01OpenModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
