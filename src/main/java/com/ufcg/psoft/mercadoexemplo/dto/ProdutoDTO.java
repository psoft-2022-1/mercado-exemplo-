package com.ufcg.psoft.mercadoexemplo.dto;

public class ProdutoDTO {
	
	private Long id;

	private String nome; 
	
	private double preco;

	private String fabricante;

	public ProdutoDTO() {}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString() {
		return this.id + " " + this.nome;
	}
}