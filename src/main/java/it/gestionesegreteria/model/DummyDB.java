package it.gestionesegreteria.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class DummyDB {

	private final List<Studente> studenti = new ArrayList<>();
	private final List<CorsoLaurea> corsi = new ArrayList<>();


	public void aggiungiStudente(Studente s) {
		studenti.add(s);
	}

	public boolean eliminaStudente(String matricola) {
		for (int i = 0; i < studenti.size(); i++) {
			if(studenti.get(i).getMatricola().equals(matricola)) {
				studenti.remove(i);
				return true;
			}
		}
		return false;
	}



	public void aggiungiCorso(CorsoLaurea corso) {
		corsi.add(corso);
	}

	public boolean eliminaCorso(String codice) {
		for (int i = 0; i < corsi.size(); i++) {
			if(corsi.get(i).getCodice().equals(codice)) {
				corsi.remove(i);
				return true;
			}
		}
		return false;
	}

	public Studente getStudenteByMatricola(String matricola) {
		for (Studente studenti : studenti) {
			if(studenti.getMatricola().equals(matricola))
				return studenti;
		}
		return null;
	}

	public CorsoLaurea getCorsoByCodice(String codice) {
		for (CorsoLaurea corsoLaurea : corsi) {
			if(corsoLaurea.getCodice().equals(codice))
				return corsoLaurea;
		}
		return null;

	}
}