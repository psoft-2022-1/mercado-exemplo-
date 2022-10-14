package com.ufcg.psoft.mercadoexemplo.service;

import java.util.List;

import com.ufcg.psoft.mercadoexemplo.dto.LoteDTO;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;

public interface LoteService {
	
	public List<LoteDTO> listarLotes();

	public Long criaLote(String loteJson) throws ProdutoNotFoundException;
	
}
