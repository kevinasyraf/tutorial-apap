package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("listRole", roleService.getAllRoleModel());
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}