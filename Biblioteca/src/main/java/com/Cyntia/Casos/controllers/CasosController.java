package com.Cyntia.Casos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Cyntia.Casos.models.Caso;
import com.Cyntia.Casos.repository.CasoRepository;



@Controller
public class CasosController {
	
	@Autowired
	private CasoRepository cr;
	
	@RequestMapping(value="/cadastrarCaso", method=RequestMethod.POST)
	public String form(@Valid Caso caso, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarCaso";
		}
		
		cr.save(caso);
		attributes.addFlashAttribute("mensagem", "Caso cadastrado com sucesso!");
		return "redirect:/cadastrarCaso";
	}

	@RequestMapping(value="/cadastrarCaso", method=RequestMethod.GET)
	public String form(){
		
		return "Perito/formCaso";
	}
	
		@GetMapping("/listarcasos")
		public ModelAndView listar() {
			ModelAndView mv = new ModelAndView("Perito/ListarCasos");
			Iterable<Caso> casos = cr.findAll();
			mv.addObject("casos", casos);
			return mv;
		}
		
		
		@RequestMapping("/deletarCaso")
		public String deletarCaso(long codigo){
			Caso caso = cr.findByCodigo(codigo);
			cr.delete(caso);
			return "redirect:/listarcasos" ;
		}
		
		
	}	



