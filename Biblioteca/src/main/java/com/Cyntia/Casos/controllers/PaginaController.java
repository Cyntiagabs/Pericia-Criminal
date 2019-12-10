package com.Cyntia.Casos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaController {
	@RequestMapping("/pagina")
	public String index() {
		return "Caso/Pagina";
		
	}
}
