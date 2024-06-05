package com.remidi.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    
    private String senha;
    
    private String confirmSenha;

    private String primeiroNome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String sobrenome;

    private String freqRemidi;
    
    public User() {
    	
    }

	public User(String email, String senha, String confirmSenha, String primeiroNome, LocalDate dataNascimento,
			String sobrenome, String freqRemidi) {
		super();
		this.email = email;
		this.senha = senha;
		this.confirmSenha = confirmSenha;
		this.primeiroNome = primeiroNome;
		this.dataNascimento = dataNascimento;
		this.sobrenome = sobrenome;
		this.freqRemidi = freqRemidi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmSenha() {
		return confirmSenha;
	}

	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getFreqRemidi() {
		return freqRemidi;
	}

	public void setFreqRemidi(String freqRemidi) {
		this.freqRemidi = freqRemidi;
	}

	public Long getId() {
		return id;
	}

 
}
