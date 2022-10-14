package com.ufcg.psoft.mercadoexemplo.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufcg.psoft.mercadoexemplo.dto.LoteDTO;
import com.ufcg.psoft.mercadoexemplo.dto.ProdutoDTO;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoAlreadyCreatedException;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;
import com.ufcg.psoft.mercadoexemplo.service.LoteService;
import com.ufcg.psoft.mercadoexemplo.service.ProdutoService;

@Component
public class Facade {
	
	@Autowired
	private ProdutoService produtoService; 
	
	@Autowired
	private LoteService loteService;
	
	public List<ProdutoDTO> listaProdutos() {
		return this.produtoService.listarProdutos();
	}
	
	public List<LoteDTO> listaLotes() {
		return this.loteService.listarLotes();
	}
		
	public Long criaProduto(String data) throws ProdutoAlreadyCreatedException {
		return this.produtoService.criaProduto(data);
	}

	public Long criaLote(String data) throws ProdutoNotFoundException {
		return this.loteService.criaLote(data);
	}
}