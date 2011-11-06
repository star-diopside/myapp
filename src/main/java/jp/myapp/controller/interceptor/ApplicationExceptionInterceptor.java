package jp.myapp.controller.interceptor;

import java.util.Arrays;

import jp.myapp.exception.ApplicationException;

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

        } catch (ApplicationException e) {
            Object action = invocation.getAction();

            if (!(action instanceof ValidationAware)) {
                // Action �� ValidationAware �C���^�t�F�[�X���������Ă��Ȃ��ꍇ�A��O���ăX���[����
                throw e;
            }

            ValidationAware validationAwareAction = (ValidationAware) action;

            if (e.isResource()) {
                if (!(action instanceof TextProvider)) {
                    // Action �� TextProvider �C���^�t�F�[�X���������Ă��Ȃ��ꍇ�A��O���ăX���[����
                    throw e;
                }

                // TextProvider ����擾�������b�Z�[�W�� ActionError �ɒǉ�����
                TextProvider textProviderAction = (TextProvider) action;
                validationAwareAction.addActionError(textProviderAction.getText(
                        e.getMessage(), Arrays.asList(e.getArguments())));

            } else {
                // ��O���b�Z�[�W�� ActionError �ɒǉ�����
                validationAwareAction.addActionError(e.getMessage());
            }

            result = this.inputResultName;
        }

        return result;
    }
}
