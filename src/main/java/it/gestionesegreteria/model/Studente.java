package it.gestionesegreteria.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Studente {

	@NotNull
	private String matricola;
	@NotNull
	private String nome;
	@NotNull
	private String cognome;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	@NotNull
	private String email;
	@NotNull
	private String indirizzo;
	@NotNull
	private String citta;

	private CorsoLaurea corsoLaurea;


	@Override
	public String toString() {
		return "Matricola: " + matricola + "Nome: " + nome + "Cognome: " + cognome + "Data di nascita: "
				+ dataNascita + "Email: " + email + "Indirizzo: " + indirizzo + "città: " + citta + "Corso di laurea: "
				+ corsoLaurea;

	}






}