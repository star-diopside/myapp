package jp.myapp.webservice_client.controller.auth;

import java.util.Arrays;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.myapp.webservice_client.form.auth.LoginForm;
import jp.myapp.webservice_client.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    @Qualifier("messages")
    private MessageSourceAccessor messages;

    @RequestMapping(method = RequestMethod.GET)
    public String show(LoginForm form, Errors errors, HttpSession session) {

        // 認証エラーの場合
        if (form.isError()) {

            // 認証エラー例外を取得する。
            Exception exception = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

            if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
                errors.reject("Error.BadCredential");
            } else if (exception != null) {
                LOGGER.error(exception.getMessage(), exception);
                errors.reject("Error.Authentication");
            }
        }

        return "auth/login";
    }

    @RequestMapping(method = RequestMethod.POST, params = "login")
    public String login(@Valid LoginForm form, Errors errors) {

        if (errors.hasErrors()) {
            return "auth/login";
        } else {
            return "forward:/j_spring_security_check";
        }
    }

    @RequestMapping(method = RequestMethod.POST, params = "register")
    public String register(LoginForm form) {

        String username = "user";
        String password = "password";

        loginService.registerUser(username, password);

        String message = messages.getMessage("Info.RegisterTestUser", new Object[] { username, password });
        form.setMessages(Arrays.asList(message));

        return "auth/login";
    }
}
