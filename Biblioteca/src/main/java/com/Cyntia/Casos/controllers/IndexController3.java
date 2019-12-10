package com.Cyntia.Casos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController3 {
	@RequestMapping("/visitante")
	public String index() {
		return "Visitante/Visitante";	
	}

}
