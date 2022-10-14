package com.ufcg.psoft.mercadoexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.psoft.mercadoexemplo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
