package it.gestionesegreteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.DummyDB;

@Controller
public class CorsoLaureaController {

	


	@Autowired
	ApplicationContext ctx;

	public DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}

	@GetMapping("/corsi")	
	public ModelAndView visualizzaCorsi() {
		getDummyDb();
		List<CorsoLaurea> corsi = getDummyDb().getCorsi();
		return new ModelAndView("visualizzaCorsi", "corsi", corsi);	

	}

	@GetMapping("/mostraformcorso")
	public ModelAndView mostraFormCorso() {
		List<CorsoLaurea> corsi = getDummyDb().getCorsi();
		ModelAndView mav = new ModelAndView("aggiungiCorso", "corso", new CorsoLaurea());
		mav.addObject("corsi", corsi);
		return mav;

	}

	@PostMapping("/aggiungicorso")
	public ModelAndView aggiungiCorso(CorsoLaurea corso, BindingResult result, Model model) {
		getDummyDb().aggiungiCorso(corso);
		return visualizzaCorsi();
	}

	@GetMapping("/formaggiornacorso/{codice}")
	public ModelAndView mostraFormAggiornaCorso(@PathVariable String codice, Model model) {
		List<CorsoLaurea> corsi = getDummyDb().getCorsi();
		CorsoLaurea c = getDummyDb().getCorsoByCodice(codice);
		ModelAndView mav = new ModelAndView("aggiornaCorso", "corso", new CorsoLaurea());
		mav.addObject("corso", c);
		mav.addObject("corsi", corsi);
		return mav;
	}

	@PostMapping("/aggiornacorso/{codice}")
	public ModelAndView aggiornaCorso(@Valid @ModelAttribute ("corso") CorsoLaurea corso, @PathVariable String codice, BindingResult result, Model model) {
		corso.setCodice(codice);
		getDummyDb().eliminaCorso(corso.getCodice());
		getDummyDb().aggiungiCorso(corso);
		return visualizzaCorsi();
	}

	@GetMapping("/eliminacorso/{codice}")
	public ModelAndView eliminaCorso(@PathVariable ("codice") String codice, Model model) {
		getDummyDb().eliminaCorso(codice);
		return visualizzaCorsi();
	}

}