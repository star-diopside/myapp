package jp.myapp.web.controller.auth.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.myapp.service.exception.auth.DualLoginException;
import jp.myapp.web.constant.FlashScopeKeys;
import jp.myapp.web.controller.auth.form.AA01S010Form;
import jp.myapp.web.controller.auth.model.AA01S010Model;
import jp.myapp.web.controller.auth.model.AA01S010ModelImpl;
import jp.myapp.web.controller.util.SessionUtils;
import jp.myapp.web.servlet.support.FlashScopeUtils;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class AA01S010Action extends ActionSupport implements ModelDriven<AA01S010Model>, SessionAware,
        ServletRequestAware {

    private static final long serialVersionUID = 1L;

    private static final Map<String, String> EXCEPTION_MAP;
    private AA01S010Model model = new AA01S010ModelImpl();
    private Map<String, Object> session;
    private HttpServletRequest request;

    static {
        HashMap<String, String> map = new HashMap<>();
        map.put(BadCredentialsException.class.getName(), "Error.NotMatchUserIdOrPassword");
        map.put(UsernameNotFoundException.class.getName(), "Error.NotMatchUserIdOrPassword");
        map.put(AccountExpiredException.class.getName(), "Error.UserInvalid");
        map.put(DualLoginException.class.getName(), "Error.DualLogin");
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
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String execute() throws Exception {

        AA01S010Form outForm = (new SessionUtils(this.session)).getForm(AA01S010Form.class);

        if (outForm == null) {
            outForm = this.model.getAA01S010Form();
        } else {
            this.model.setAA01S010Form(outForm);
        }

        // フラッシュスコープを取得する。
        Map<String, Object> inputFlashMap = FlashScopeUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            // フラッシュスコープから例外情報を取得する。
            Exception exception = (Exception) inputFlashMap.get(FlashScopeKeys.LAST_EXCEPTION);

            if (exception != null) {
                String msgKey = EXCEPTION_MAP.get(exception.getClass().getName());
                if (msgKey != null) {
                    this.addActionError(this.getText(msgKey));
                } else {
                    LOG.debug(exception.getMessage(), exception);
                }
            }

            // セッションタイムアウト後の遷移かどうかチェックする。
            if (Boolean.TRUE.equals(inputFlashMap.get(FlashScopeKeys.INVALID_SESSION_FLAG))) {
                this.addActionError(this.getText("Error.InvalidSession"));
            }
        }

        return SUCCESS;
    }
}
