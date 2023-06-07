package com.cadastro.cadastroPessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastroPessoa.model.Pessoa;
import com.cadastro.cadastroPessoa.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

    
    private PessoaRepository pessoaRepository;    
    // Restante do código    h
    
    public Pessoa salvaPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
  
    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }
    
    public Optional<Pessoa> getById(Long id) {
        return pessoaRepository.findById(id);
    }
   
    public Pessoa atualizaPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
   
    public void deleteByIdPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

	@Override
	public Optional<Pessoa> getByIdCliente(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteByIdPessoa(Integer id) {
		// TODO Auto-generated method stub
		
	}



}
