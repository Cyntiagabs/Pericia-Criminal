package com.Cyntia.Casos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/area")
	public String index() {
		return "Perito/area";
		
	}
}
