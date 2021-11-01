package com.ribastore.estoque.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.ribastore.estoque.enumerate.PedidoStatus;

import lombok.Data;

@Entity
@Data
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PedidoStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoId")
	private List<PedidoItem> itens;
	
	public Pedido(List<PedidoItem> itens) {
		this.itens = itens;
		this.status = PedidoStatus.RECEBIDO;
	}
	
	public Pedido() {
	}
}
