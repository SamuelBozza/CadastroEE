package com.estacio.CadastroEE.Repository;

import com.estacio.CadastroEE.Models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface LojaRepository extends CrudRepository<Produto, Integer> {
    void deleteById(int idProduto);
    Produto findById(int idProduto);
}
