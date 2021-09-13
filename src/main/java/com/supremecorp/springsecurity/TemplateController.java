package com.supremecorp.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by suprememajor on the 9/13/21
 */
@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }
}
