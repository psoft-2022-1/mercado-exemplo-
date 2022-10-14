package com.ufcg.psoft.mercadoexemplo.dto;

public class LoteDTO {
	
	private Long idProduto;
	
	private int numeroDeItens; 
	
	public LoteDTO() {}
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long id) {
		this.idProduto = id;
	}
	
	public int getNumeroDeItens() {
		return numeroDeItens;
	}
	
	public void setNumeroDeItens(int numeroDeItens) {
		this.numeroDeItens = numeroDeItens;
	}
	
	public String toString() {
		return this.idProduto + " " + this.numeroDeItens;
	}
}
