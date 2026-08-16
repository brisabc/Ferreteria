package com.prueba_tecnica.Ferreteria_industrial.service;

import com.prueba_tecnica.Ferreteria_industrial.model.Producto;

import java.util.List;

public interface IProductoService {

    //métodos crud
    List<Producto> traerProductos();

    Producto buscarProducto(Long codProd);
    Producto crearProducto(Producto prod);
    Producto editarProducto(Long codProd, Producto prod);

    boolean eliminarProducto(Long codProd);
}
