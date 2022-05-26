package org.casjedcem.FarmShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagesController {
	
	@GetMapping("/")
	public String home( @RequestParam(required=false, defaultValue="World") String name, ModelMap modelmap) {
		
		modelmap.put("toto", name);
		System.out.println("\n \n \n" + name +"\n \n \n");
		return "index";
	}
	
}
