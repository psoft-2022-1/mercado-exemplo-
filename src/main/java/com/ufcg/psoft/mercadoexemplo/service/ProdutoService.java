package com.ufcg.psoft.mercadoexemplo.service;

import java.util.List;

import com.ufcg.psoft.mercadoexemplo.dto.ProdutoDTO;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoAlreadyCreatedException;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;
import com.ufcg.psoft.mercadoexemplo.model.Produto;

public interface ProdutoService {

	public ProdutoDTO getProdutoById(Long id) throws ProdutoNotFoundException;
	
	public List<ProdutoDTO> listarProdutos();
	
	public Long criaProduto(String produtoJson) throws ProdutoAlreadyCreatedException;
	
	public Produto getProduto(Long id) throws ProdutoNotFoundException;
	
	public void removerProdutoCadastrado(Long id) throws ProdutoNotFoundException;
}
