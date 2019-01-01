package com.abctreinamentos;
// Generated 29/12/2018 10:54:53 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Curso generated by hbm2java
 */
public class Curso implements java.io.Serializable {

	private static final long serialVersionUID = -8769618678972513419L;
	private int cdcurso;
	private String nome;
	private double valor;
	private String url;
	private Set<Pagamento> pagamentos = new HashSet<>();

	public Curso() {
	}

	public Curso(int cdcurso, String nome, double valor, String url) {
		this.cdcurso = cdcurso;
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}

	public Curso(int cdcurso, String nome, double valor, String url, Set<Pagamento> pagamentos) {
		this.cdcurso = cdcurso;
		this.nome = nome;
		this.valor = valor;
		this.url = url;
		this.pagamentos = pagamentos;
	}

	public int getCdcurso() {
		return this.cdcurso;
	}

	public void setCdcurso(int cdcurso) {
		this.cdcurso = cdcurso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	@Override
	public String toString() {
		return "Curso - código: " + cdcurso + ", nome: " + nome + ", valor: " + String.format("%.2f", valor) + ", url: " + url;
	}
}