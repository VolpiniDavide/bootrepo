package it.onyx.bootapp.dao;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="cliente")
public class UserDao {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name="ID_Cliente",unique=true, nullable = false)
	private String id_cliente;
	@Column(name="Nome")
	private String nome;
	@Column(name="Cognome")
	private String cognome;
	@Column(name="Num_Telefono")
	private String num_telefono;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	public UserDao () {
		
	}
	
	
	public UserDao ( String nome, String cognome, String num_telefono, String email, String password, String id  ) {
		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.num_telefono = num_telefono;
		this.id_cliente = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNum_telefono() {
		return num_telefono;
	}
	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
