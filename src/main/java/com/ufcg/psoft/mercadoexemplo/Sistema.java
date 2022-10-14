package com.ufcg.psoft.mercadoexemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ufcg.psoft.mercadoexemplo.exception.ProdutoAlreadyCreatedException;
import com.ufcg.psoft.mercadoexemplo.exception.ProdutoNotFoundException;
import com.ufcg.psoft.mercadoexemplo.facade.Facade;

@SpringBootApplication
public class Sistema {
	
	@Autowired
	Facade mercadoFacade;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Sistema.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void exemplo() {
		
		String jsonP1 = "{\"nome\":\"Leite integral\", \"fabricante\":\"Parmalat\", \"preco\":10.5}";
		
		Long produtoId = null;

		try {
			produtoId = mercadoFacade.criaProduto(jsonP1);
		} catch (ProdutoAlreadyCreatedException e) {
			System.err.println(e.getMessage());
		}
			
		String jsonL1 = "{\"idProduto\":\"" + produtoId + "\", \"numeroDeItens\":10}";;
		
		try {
			mercadoFacade.criaLote(jsonL1);
		} catch (ProdutoNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(mercadoFacade.listaProdutos());
		System.out.println(mercadoFacade.listaLotes());
	}

}
