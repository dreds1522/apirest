package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value= "/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos") //Método listar todos os produtos
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produto/{id}") //Método listar produto por Id
	public Produto listaProdutoUnico(@PathVariable(value= "id") long id){
		return produtoRepository.findById(id);
	
	}
	
	@PostMapping("/produto") //Método criar produto na tabela (usando JSON)
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping("/produto") //Método Deletar produto na tabela.
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	
    }
	
	@PutMapping("/produto") //Método Atualizar produto na tabela.
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	
	}
}
