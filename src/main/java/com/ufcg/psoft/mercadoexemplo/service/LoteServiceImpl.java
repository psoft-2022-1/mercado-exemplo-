package com.ufcg.psoft.mercadoexemplo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ufcg.psoft.mercadoexemplo.dto.LoteDTO;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;
import com.ufcg.psoft.mercadoexemplo.model.Lote;
import com.ufcg.psoft.mercadoexemplo.model.Produto;
import com.ufcg.psoft.mercadoexemplo.repository.LoteRepository;

@Service
public class LoteServiceImpl implements LoteService {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private LoteRepository loteRepository;
	
	public ModelMapper modelMapper = new ModelMapper();
	
	private Gson gson = new Gson();
	
	public List<LoteDTO> listarLotes() {
		
		List<LoteDTO> lotes = loteRepository.findAll()
				.stream()
				.map(lote -> modelMapper.map(lote, LoteDTO.class))
				.collect(Collectors.toList());

		return lotes;
	}

	private void salvarLote(Lote lote) {
		loteRepository.save(lote);		
	}

	public Long criaLote(String loteJson) throws ProdutoNotFoundException {
		
		LoteDTO loteDTO = gson.fromJson(loteJson, LoteDTO.class);

		Produto produto = produtoService.getProduto(loteDTO.getIdProduto());
		Lote lote = new Lote(produto, loteDTO.getNumeroDeItens());
		salvarLote(lote);
	
		return lote.getId();
	}

}
