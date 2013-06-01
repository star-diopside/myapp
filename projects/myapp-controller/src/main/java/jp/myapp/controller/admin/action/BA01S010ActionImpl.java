package jp.myapp.controller.admin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class BA01S010ActionImpl extends ActionSupport implements BA01S010Action {

    private static final long serialVersionUID = 1L;

}
