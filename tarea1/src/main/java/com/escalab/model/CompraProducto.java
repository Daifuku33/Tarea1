package com.escalab.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "compra_producto")
public class CompraProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_detalle"))
	private Venta idVenta;

	public int getId_producto() {
		return idProducto;
	}

	public void setId_producto(int id_producto) {
		this.idProducto = id_producto;
	}

	public Venta getVenta() {
		return idVenta;
	}

	public void setVenta(Venta venta) {
		this.idVenta = venta;
	} 
	
	
	

}
