package com.sharedtractor.models;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Usuario {
	private String nome;
	
	private Integer idade;
	
	private DadosLogin dadosLogin;
	
	private String telefone;
	
	private Integer perfil;
	
	private Date dataDeNascimento;
	
	private Localizacao localizacao ;

	public String getNome() {
		return nome;
	}
	
	
	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Localizacao getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public DadosLogin getDadosLogin() {
		return dadosLogin;
	}

	public void setDadosLogin(DadosLogin dadosLogin) {
		this.dadosLogin = dadosLogin;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
