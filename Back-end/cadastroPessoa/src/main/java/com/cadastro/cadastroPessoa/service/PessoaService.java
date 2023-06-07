package com.cadastro.cadastroPessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cadastro.cadastroPessoa.model.Pessoa;

public interface PessoaService {
	
	public Pessoa salvaPessoa(Pessoa pessoa);
    
    public List<Pessoa> listarPessoa();
        
    public Optional<Pessoa> getByIdCliente(Integer id);
    
    public Pessoa atualizaPessoa(Pessoa pessoa);
    
    public void deleteByIdPessoa(Integer id);

}
