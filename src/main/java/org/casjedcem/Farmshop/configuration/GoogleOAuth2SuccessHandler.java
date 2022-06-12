package org.casjedcem.Farmshop.configuration;

import org.casjedcem.Farmshop.model.Enduser;
import org.casjedcem.Farmshop.model.Role;
import org.casjedcem.Farmshop.repository.EnduserRepository;
import org.casjedcem.Farmshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EnduserRepository enduserRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(enduserRepository.findEnduserByEmail(email).isPresent()){

        }else {
            Enduser enduser = new Enduser();
            enduser.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            enduser.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            enduser.setEmail(email);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findById(2).get());
            enduser.setRoles(roles);
            enduserRepository.save(enduser);
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
    }
}
