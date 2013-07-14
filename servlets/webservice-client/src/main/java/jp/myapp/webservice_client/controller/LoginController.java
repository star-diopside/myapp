package jp.myapp.webservice_client.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.myapp.webservice_client.controller.form.LoginForm;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String show(LoginForm form, Errors errors, HttpSession session) {

        // 認証エラーの場合
        if (form.isError()) {

            // 認証エラー例外を取得する。
            Object exception = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

            if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
                errors.reject("Error.BadCredential");
            } else if (exception != null) {
                errors.reject("Error.Authentication");
            }
        }

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@Valid LoginForm form, Errors errors) {

        if (errors.hasErrors()) {
            return "login";
        } else {
            return "forward:/j_spring_security_check";
        }
    }
}
