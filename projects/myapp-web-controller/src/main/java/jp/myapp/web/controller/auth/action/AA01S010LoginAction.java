package jp.myapp.web.controller.auth.action;

import jp.myapp.web.controller.auth.model.AA01S010Model;
import jp.myapp.web.controller.auth.model.AA01S010ModelImpl;
import jp.myapp.web.controller.auth.validation.AA01S010Validation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
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
