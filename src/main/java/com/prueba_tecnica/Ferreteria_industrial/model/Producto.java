package com.prueba_tecnica.Ferreteria_industrial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProducto;
    private String nombre;
    private String marca;
    private String categoria;
    private int stock;
    private String descripcion;
    private Double precio;
}


