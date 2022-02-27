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
import it.gestionesegreteria.model.Studente;

@Controller
public class StudenteController {

	

	@Autowired
	ApplicationContext ctx;

	public DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}

	@GetMapping("/studenti")	
	public ModelAndView visualizzaStudenti() {
		return new ModelAndView("visualizzaStudenti", "dummydb", getDummyDb());	

	}

	@GetMapping("/mostraform")
	public ModelAndView mostraForm() {
		List<CorsoLaurea> corsi = getDummyDb().getCorsi();
		ModelAndView mav = new ModelAndView("aggiungiStudente", "studente", new Studente());
		mav.addObject("corsi", corsi);
		return mav;

	}

	@PostMapping("/aggiungistudente")
	public ModelAndView aggiungiStudente(Studente studente, BindingResult result, Model model) {
		getDummyDb().aggiungiStudente(studente);
		return visualizzaStudenti();
	}

	@GetMapping("/formaggiorna/{matricola}")
	public ModelAndView mostraFormAggiornaStudente(@PathVariable String matricola, Model model) {
		List<CorsoLaurea> corsi = getDummyDb().getCorsi();
		Studente s = getDummyDb().getStudenteByMatricola(matricola);
		ModelAndView mav = new ModelAndView("aggiornaStudente", "studente", new Studente());
		mav.addObject("corsi", corsi);
		mav.addObject("studente", s);
		return mav;
	}

	@PostMapping("/aggiornastudente/{matricola}")
	public ModelAndView aggiornaStudente(@Valid @ModelAttribute ("studente") Studente studente, @PathVariable String matricola, BindingResult result, Model model) {
		studente.setMatricola(matricola);
		getDummyDb().eliminaStudente(studente.getMatricola());
		getDummyDb().aggiungiStudente(studente);
		return visualizzaStudenti();
	}

	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable ("matricola") String matricola, Model model) {
		getDummyDb().eliminaStudente(matricola);
		return visualizzaStudenti();
	}

}