package jp.myapp.controller.edit.action;

import jp.myapp.controller.edit.model.A01RegisterModel;
import jp.myapp.controller.edit.model.A01RegisterModelImpl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class A01RegisterAction extends ActionSupport implements ModelDriven<A01RegisterModel> {

    private static final long serialVersionUID = 1L;

    private A01RegisterModel model = new A01RegisterModelImpl();

    @Override
    public A01RegisterModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
