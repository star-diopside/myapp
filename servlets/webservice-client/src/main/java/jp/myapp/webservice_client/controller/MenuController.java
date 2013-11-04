package jp.myapp.webservice_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "menu";
    }

    @RequestMapping(value = "accessWebApi", method = RequestMethod.GET)
    public String accessWebApi() {
        return "menu";
    }
}
