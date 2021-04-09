package com.example.algamoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "lancamento")
public class Lancamento {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EqualsAndHashCode.Include
	 private Long codigo;
	 
	 @NotNull
	 private String descricao;
	 
	 @NotNull
	 private LocalDate dataVencimento;
	 
	 @NotNull
	 private BigDecimal valor;
	 
	 private String observacao;
	 
	 @NotNull
	 @Enumerated(EnumType.STRING)
	 private TipoLancamento tipo;
	 
	 @NotNull
	 @ManyToOne
	 @JoinColumn(name = "codigo_categoria")
	 private Categoria categoria;
	 
	 @NotNull
	 @ManyToOne
	 @JoinColumn(name = "codigo_pessoa")
	 private Pessoa pessoa;
}
