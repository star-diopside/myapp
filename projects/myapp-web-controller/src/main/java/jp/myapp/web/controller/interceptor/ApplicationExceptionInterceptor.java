package jp.myapp.web.controller.interceptor;

import java.util.Arrays;

import jp.myapp.core.exception.IBusinessException;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

@Controller
public class ApplicationExceptionInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    private String inputResultName = Action.INPUT;

    public void setInputResultName(String inputResultName) {
        this.inputResultName = inputResultName;
    }

    @Override
    public void init() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        String result;

        try {
            result = invocation.invoke();

        } catch (Exception e) {
            // 業務例外以外の場合、例外を再スローする
            if (!(e instanceof IBusinessException)) {
                throw e;
            }

            IBusinessException be = (IBusinessException) e;
            Object action = invocation.getAction();

            if (!(action instanceof ValidationAware)) {
                // Action が ValidationAware インタフェースを実装していない場合、例外を再スローする
                throw e;
            }

            ValidationAware validationAwareAction = (ValidationAware) action;

            if (be.isResource()) {
                if (!(action instanceof TextProvider)) {
                    // Action が TextProvider インタフェースを実装していない場合、例外を再スローする
                    throw e;
                }

                // TextProvider から取得したメッセージを ActionError に追加する
                TextProvider textProviderAction = (TextProvider) action;
                validationAwareAction.addActionError(textProviderAction.getText(
                        be.getMessage(), Arrays.asList(be.getArguments())));

            } else {
                // 例外メッセージを ActionError に追加する
                validationAwareAction.addActionError(be.getMessage());
            }

            result = this.inputResultName;
        }

        return result;
    }
}
