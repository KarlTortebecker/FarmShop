package org.casjedcem.FarmShop.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
    @GetMapping("/index.html")
    public String home(@RequestParam(required=false, defaultValue="None") String name, ModelMap modelmap) {
        modelmap.put("name", name);
        System.out.print("\n \n "+name);
        return "index";
    }
}
