package com.ribastore.loja.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ribastore.loja.enumerate.CompraState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long pedidoId;
	
	private LocalDate dataParaEntrega;
	
	private String nomeDoPersonagem;
	
	private String mundoPersonagem;
	
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraState state;
}
