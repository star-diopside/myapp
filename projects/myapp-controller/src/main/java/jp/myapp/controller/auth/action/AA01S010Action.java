package jp.myapp.controller.auth.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.model.AA01S010Model;
import jp.myapp.controller.auth.model.AA01S010ModelImpl;
import jp.myapp.controller.util.SessionUtils;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class AA01S010Action extends ActionSupport implements ModelDriven<AA01S010Model>, SessionAware {

    private static final long serialVersionUID = 1L;

    private static final Map<String, String> EXCEPTION_MAP;
    private AA01S010Model model = new AA01S010ModelImpl();
    private Map<String, Object> session;

    static {
        HashMap<String, String> map = new HashMap<>();
        map.put(BadCredentialsException.class.getName(), "Error.NotMatchUserIdOrPassword");
        map.put(UsernameNotFoundException.class.getName(), "Error.NotMatchUserIdOrPassword");
        map.put(AccountExpiredException.class.getName(), "Error.UserInvalid");
        EXCEPTION_MAP = Collections.unmodifiableMap(map);
    }

    @Override
    public AA01S010Model getModel() {
        return this.model;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        AA01S010Form outForm = (new SessionUtils(this.session)).getForm(AA01S010Form.class);
        AuthenticationException exception = null;

        if (outForm == null) {
            outForm = this.model.getAA01S010Form();
        } else {
            this.model.setAA01S010Form(outForm);
            exception = outForm.getException();
        }

        if (exception != null) {
            this.addActionError(this.getText(EXCEPTION_MAP.get(exception.getClass().getName())));
        }

        return SUCCESS;
    }
}
