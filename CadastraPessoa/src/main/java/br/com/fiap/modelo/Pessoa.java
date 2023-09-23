package br.com.fiap.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	
	private long id;
	
	private String nome;
	
	private String genero;
	
	private LocalDate nascimento;
	
	private List<String> skills;
	
	private List<String> idiomas;

	public Pessoa() {
		this.skills = new ArrayList<>();
		this.idiomas = new ArrayList<>();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}

	
}
