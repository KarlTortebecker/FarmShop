package org.casjedcem.Farmshop.controller;

import org.casjedcem.Farmshop.global.GlobalData;
import org.casjedcem.Farmshop.model.Enduser;
import org.casjedcem.Farmshop.model.Role;
import org.casjedcem.Farmshop.repository.EnduserRepository;
import org.casjedcem.Farmshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    EnduserRepository enduserRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){

        GlobalData.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("enduser")Enduser enduser, HttpServletRequest request) throws ServletException{
        String password = enduser.getPassword();
        enduser.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        enduser.setRoles(roles);
        enduserRepository.save(enduser);
        request.login(enduser.getEmail(), password);

        return "redirect:/";
    }
}
