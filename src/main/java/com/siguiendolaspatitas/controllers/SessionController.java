package com.siguiendolaspatitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siguiendolaspatitas.models.User;
import com.siguiendolaspatitas.services.SessionService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SessionController {
    
    @Autowired
    private SessionService serv;
    
    @GetMapping("/")
    public String index(@ModelAttribute("NewUser") User NewUser) {
        return "LoginRegister.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("NewUser") User NewUser, BindingResult result,HttpSession session, Model model) {
        serv.register(NewUser, result);

        if (result.hasErrors()) {
            return "LoginRegister.jsp";
        } else {
            session.setAttribute("UserInSession", NewUser);
            return "redirect:/main";
        }
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpSession session) {
        
        User userTryingLogin = serv.login(email, password);
        
        if (userTryingLogin == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password.");
            return "LoginRegister.jsp";
        } else {
            session.setAttribute("UserInSession", userTryingLogin);
            return "redirect:/main";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
}