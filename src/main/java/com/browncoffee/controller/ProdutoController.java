package com.browncoffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.browncoffee.entitie.Produto;
import com.browncoffee.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id) {
		Produto Produto = produtoService.buscaProdutoId(id);
		if (Produto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodosProdutoControl() {
		List<Produto> Produto = produtoService.buscaTodosProdutos();
		return ResponseEntity.ok(Produto);
	}

	@PostMapping
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody Produto produto) {
		Produto salvaProduto = produtoService.salvaProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto produto) {
		Produto alterarProduto = produtoService.alterarProduto(id, produto);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarProdutoControl(@PathVariable Long id) {
		boolean apagar = produtoService.apagarProduto(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Produto foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
