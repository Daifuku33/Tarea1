package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendedor;
	
	@ManyToOne
	@JoinColumn(name = "id_supervisor", nullable = false, foreignKey = @ForeignKey(name = "FK_IdSupervisor_vendedor"))
	private Supervisor idSupervisor; 

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombreVendedor;
	
	@Column(name = "telefono", length = 9, nullable = true)
	private String telVendedor;

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Supervisor getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Supervisor idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getTelVendedor() {
		return telVendedor;
	}

	public void setTelVendedor(String telVendedor) {
		this.telVendedor = telVendedor;
	}
	
	
}
