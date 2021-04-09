package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<Pessoa> buscarPessoaPeloCodigo(Long codigo, Pessoa pessoa) {
		Pessoa pessoaAtualizar = pessoaRepository.findById(codigo).get();

		if (pessoaAtualizar != null) {

			BeanUtils.copyProperties(pessoa, pessoaAtualizar, "codigo");

			pessoaAtualizar = pessoaRepository.save(pessoaAtualizar);

			return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizar);

		}

		throw new EmptyResultDataAccessException(1);
	}

	public void atualizarPropiedadeAtivo(Long codigo, Boolean ativo) {

		Pessoa pessoaAtualizar = pessoaRepository.findById(codigo).get();

		if (pessoaAtualizar != null) {

			pessoaAtualizar.setAtivo(ativo);

			pessoaAtualizar = pessoaRepository.save(pessoaAtualizar);

		}

	}
}
