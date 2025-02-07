package com.jardinfloral.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
//No hay que traer todo el paque Persistance, hay cosas que no se usan de ese paquete, solo traer las
//dependencias necesarias
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productosID", unique = true, nullable = false)
    private Long id;
    @Column(name = "nombreproducto", nullable = false, length = 45)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;
    @Column(name = "temporada", nullable = false, length = 45)
    private String temporada;    
    @Column(name = "imagen", nullable = false, length = 150)
    private String imagen;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "categorias_has_productos", joinColumns =
	{ @JoinColumn(referencedColumnName = "productosID")}
    , inverseJoinColumns = {@JoinColumn(referencedColumnName = "categoriasID")})
    private Set<Categoria> categorias;
    
    public Producto() {}//Constructor vacio
    
    public Producto(String nombre, Double precio, String color, Integer stock, String descripcion, String temporada, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
        this.stock = stock;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.imagen = imagen;
    }//constructor

   //Getters y Setters
    public Long getId() {
        return id;
    }

    //Se elimino el setId por que se decidio usar un valor autogenerado por facilidad

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }//get sett
    
    
    public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	//Metodo toString
	@Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                ", temporada='" + temporada + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }//toString
}//classProducto
