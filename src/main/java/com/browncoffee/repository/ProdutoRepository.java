package com.browncoffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.browncoffee.entitie.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
