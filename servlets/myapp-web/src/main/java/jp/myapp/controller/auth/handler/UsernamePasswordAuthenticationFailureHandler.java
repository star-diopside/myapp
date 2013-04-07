package jp.myapp.controller.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.form.AA01S010FormImpl;
import jp.myapp.controller.util.SessionUtils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UsernamePasswordAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private String usernameParameter = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

    public void setUsernameParameter(String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        AA01S010Form form = new AA01S010FormImpl();
        form.setUserId(request.getParameter(this.usernameParameter));
        form.setLoginError(Boolean.TRUE);
        (new SessionUtils(request)).setForm(form);

        super.onAuthenticationFailure(request, response, exception);
    }
}
