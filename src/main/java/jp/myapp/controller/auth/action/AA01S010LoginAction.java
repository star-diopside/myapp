package jp.myapp.controller.auth.action;

import jp.myapp.controller.auth.model.AA01S010Model;
import jp.myapp.controller.auth.model.AA01S010ModelImpl;
import jp.myapp.controller.auth.validation.AA01S010Validation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AA01S010LoginAction extends ActionSupport implements ModelDriven<AA01S010Model>, AA01S010Validation {

    private static final long serialVersionUID = 1L;

    private AA01S010Model model = new AA01S010ModelImpl();

    @Override
    public AA01S010Model getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
