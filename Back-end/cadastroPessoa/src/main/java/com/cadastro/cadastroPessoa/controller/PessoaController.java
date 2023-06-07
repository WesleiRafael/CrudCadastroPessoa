package com.cadastro.cadastroPessoa.controller;
import java.util.List;
import java.util.Optional;

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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.cadastro.cadastroPessoa.model.Pessoa;
import com.cadastro.cadastroPessoa.service.PessoaService;

@RestController
@RequestMapping("/Pessoas")

public class PessoaController {
	@Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> listaPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoa());
    }
    
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Optional<Pessoa>> getByIdPessoa(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getByIdCliente(id));
    }

    @PostMapping("/pessoa/salve")
    public ResponseEntity<Pessoa> salvaPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvaPessoa(pessoa));
    }

    @PutMapping("/pessoa/atualiza")
    public ResponseEntity<Pessoa> atualizaPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizaPessoa(pessoa));
    }
    
    
    @DeleteMapping("pessoa/{id_pessoa}")
    public ResponseEntity<String> deleteByIdPessoa(@PathVariable Integer id){
       pessoaService.deleteByIdPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa removido com sucesso");
    }    
}
