package it.gestionesegreteria.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.DummyDB;
import it.gestionesegreteria.model.Studente;

//questa classe viene utilizzata per caricare il database all'avvio (in questo caso il database è DummyDB)
@Component
public class DummyDBLoader implements CommandLineRunner {
	
	// indichiamo a spring che serve una dependency injecion
	
	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

	DummyDB dummyDb = ctx.getBean(DummyDB.class);
		valorizzaDb(dummyDb);
	}
	
	public void valorizzaDb(DummyDB db) {
		CorsoLaurea c1 = CorsoLaurea.builder().codice("A1").nome("Geometria").indirizzo("Via Fasulla 123").numeroEsami(10).build(); 
		CorsoLaurea c2 = CorsoLaurea.builder().codice("A2").nome("informatica").indirizzo("Via Leonardo Da Vinci 1").numeroEsami(10).build();
		CorsoLaurea c3 = CorsoLaurea.builder().codice("A3").nome("Arte").indirizzo("Via Farfalla 2").numeroEsami(10).build();
		CorsoLaurea c4 = CorsoLaurea.builder().codice("A4").nome("Fotografia").indirizzo("Via Martina Franca 56").numeroEsami(10).build();
		CorsoLaurea c5 = CorsoLaurea.builder().codice("A5").nome("Ingegneria").indirizzo("Via Roma 10").numeroEsami(10).build();
		
		Studente s1 = Studente.builder().matricola("U1234").nome("Valerio").cognome("Sem").dataNascita(LocalDate.parse("1994-02-25")).email("valsem.gmail.com").citta("Roma").corsoLaurea(c5).build();
		Studente s2 = Studente.builder().matricola("U3434").nome("Bruno").cognome("Serri").dataNascita(LocalDate.parse("1998-07-05")).email("bru.gmail.com").citta("Locorotondo").corsoLaurea(c4).build();
		Studente s3 = Studente.builder().matricola("U2323").nome("Sergio").cognome("Leserri").dataNascita(LocalDate.parse("1999-09-20")).email("leserri.gmail.com").citta("Milano").corsoLaurea(c3).build();
		Studente s4 = Studente.builder().matricola("U5656").nome("Pasquale").cognome("Torcasio").dataNascita(LocalDate.parse("1992-02-01")).email("pasq.gmail.com").citta("Genova").corsoLaurea(c2).build();
		Studente s5 = Studente.builder().matricola("U0909").nome("Catia").cognome("Bianco").dataNascita(LocalDate.parse("1994-10-15")).email("bianco.gmail.com").citta("Sassari").corsoLaurea(c1).build();
		
		
		db.aggiungiStudente(s1);
		db.aggiungiStudente(s2);
		db.aggiungiStudente(s3);
		db.aggiungiStudente(s4);
		db.aggiungiStudente(s5);
		db.aggiungiCorso(c1);
		db.aggiungiCorso(c2);
		db.aggiungiCorso(c3);
		db.aggiungiCorso(c4);
		db.aggiungiCorso(c5);
		
		
	}

}
