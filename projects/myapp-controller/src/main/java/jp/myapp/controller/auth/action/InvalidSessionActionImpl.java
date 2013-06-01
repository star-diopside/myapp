package jp.myapp.controller.auth.action;

import javax.servlet.http.HttpServletRequest;

import jp.myapp.constant.FlashScopeKeys;
import jp.myapp.servlet.support.FlashScopeUtils;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.FlashMap;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class InvalidSessionActionImpl extends ActionSupport implements InvalidSessionAction, ServletRequestAware {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String execute() throws Exception {

        // フラッシュスコープにセッションタイムアウトが発生したことを示す値を設定する。
        FlashMap flashMap = FlashScopeUtils.getOutputFlashMap(request);
        flashMap.put(FlashScopeKeys.INVALID_SESSION_FLAG, Boolean.TRUE);

        return SUCCESS;
    }
}
