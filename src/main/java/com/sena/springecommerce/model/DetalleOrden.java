package com.sena.springecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles")
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // anotacion JPA
	private Integer id;
	private String nombre;
	private Double cantidas;
	private Double precio;
	private Double total;

	@ManyToOne
	private Orden orden;

	@ManyToOne
	private Producto producto;

	public DetalleOrden() {
	}

	public DetalleOrden(Integer id, String nombre, Double cantidas, Double precio, Double total) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidas = cantidas;
		this.precio = precio;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCantidas() {
		return cantidas;
	}

	public void setCantidas(Double cantidas) {
		this.cantidas = cantidas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", nombre=" + nombre + ", cantidas=" + cantidas + ", precio=" + precio + ", total="
				+ total + "]";
	}

}
