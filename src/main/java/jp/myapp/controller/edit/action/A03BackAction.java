package jp.myapp.controller.edit.action;

import jp.myapp.controller.edit.model.A03BackModel;
import jp.myapp.controller.edit.model.A03BackModelImpl;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class A03BackAction extends ActionSupport implements ModelDriven<A03BackModel> {

    private static final long serialVersionUID = 1L;

    private A03BackModel model = new A03BackModelImpl();

    @Override
    public A03BackModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
