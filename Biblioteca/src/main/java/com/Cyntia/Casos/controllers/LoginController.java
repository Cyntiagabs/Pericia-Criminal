package com.Cyntia.Casos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Cyntia.Casos.models.Login;
import com.Cyntia.Casos.repository.LoginRepository;

@Controller
public class LoginController {
		
		@Autowired
		private LoginRepository lr;
		
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String form(@Valid Login login, BindingResult result, RedirectAttributes attributes){
			if(result.hasErrors()){
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/login";
			}
			
			lr.save(login);
			attributes.addFlashAttribute("mensagem", "cadastrado com sucesso!");
			return "redirect:/login";
		}

		@RequestMapping(value="/login", method=RequestMethod.GET)
		public String form(){
			
			return "Caso/login";
		}

}
