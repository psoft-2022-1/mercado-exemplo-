package com.ufcg.psoft.mercadoexemplo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ufcg.psoft.mercadoexemplo.dto.ProdutoDTO;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoAlreadyCreatedException;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;
import com.ufcg.psoft.mercadoexemplo.model.Produto;
import com.ufcg.psoft.mercadoexemplo.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ModelMapper modelMapper = new ModelMapper();
	
	private Gson gson = new Gson();
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) { 
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoDTO getProdutoById(Long id) throws ProdutoNotFoundException {
		Produto produto = getProduto(id);
		return modelMapper.map(produto, ProdutoDTO.class);
	}
	
	public Produto getProduto(Long id) throws ProdutoNotFoundException {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException());
		return produto;
	}
	
	public void removerProdutoCadastrado(Long id) throws ProdutoNotFoundException {
		Produto produto = getProduto(id);
		produtoRepository.delete(produto);
	}

	private void salvarProdutoCadastrado(Produto produto) {
		produtoRepository.save(produto);		
	}

	public List<ProdutoDTO> listarProdutos() {
		List<ProdutoDTO> produtos = produtoRepository.findAll()
				.stream()
				.map(produto -> modelMapper.map(produto, ProdutoDTO.class))
				.collect(Collectors.toList());

		return produtos;
	}

	public Long criaProduto(String jsonData) throws ProdutoAlreadyCreatedException {
		
		ProdutoDTO produtoDTO = gson.fromJson(jsonData, ProdutoDTO.class);

		Produto produto = new Produto(produtoDTO.getNome(), produtoDTO.getFabricante(), produtoDTO.getPreco());
		salvarProdutoCadastrado(produto);

		return produto.getId();
	}
}