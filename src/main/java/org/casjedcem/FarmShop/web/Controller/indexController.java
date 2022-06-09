package org.casjedcem.FarmShop.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
    @GetMapping("/")
    public String home(@RequestParam(required=false, defaultValue="Not identified") String name, ModelMap modelmap, Model model) {
        model.addAttribute("username", name);
        modelmap.put("name", name);
        System.out.print("\n \n "+name);
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "registration/register";
    }
}
