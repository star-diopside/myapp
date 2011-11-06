package jp.myapp.controller.edit.action;

import jp.myapp.controller.edit.model.A02RedrawModel;
import jp.myapp.controller.edit.model.A02RedrawModelImpl;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A02RedrawAction extends ActionSupport implements ModelDriven<A02RedrawModel> {

    private static final long serialVersionUID = 1L;

    private A02RedrawModel model = new A02RedrawModelImpl();

    @Override
    public A02RedrawModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
