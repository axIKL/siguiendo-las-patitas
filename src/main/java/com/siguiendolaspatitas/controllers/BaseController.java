package com.siguiendolaspatitas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siguiendolaspatitas.models.Pet;
import com.siguiendolaspatitas.models.User;
import com.siguiendolaspatitas.repositories.PetRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class BaseController {
    @Autowired
    private PetRepository pR;

    @GetMapping("/main")
    public String main(HttpSession session,Model model) {
        /* === REVISAMOS SESION === */
		User UserTemp = (User) session.getAttribute("UserInSession"); //Obj User o null
		if(UserTemp == null) {
			return "redirect:/";
		}
		/* === REVISAMOS SESION === */

        List<Pet> pets = pR.findAll(); // Listar todos los pets
        model.addAttribute("pets", pets); // Agregar la lista de pets al modelo

        return "main.jsp";
}


}