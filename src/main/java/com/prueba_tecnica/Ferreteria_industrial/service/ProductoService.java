package com.prueba_tecnica.Ferreteria_industrial.service;

import com.prueba_tecnica.Ferreteria_industrial.model.Producto;
import com.prueba_tecnica.Ferreteria_industrial.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository prodRepo; //instancia  para que el service se pueda comunicar con repository

    public ProductoService(IProductoRepository prodRepo) { //inyeccion de dependencia p que el service y el repository se puedan comunicar
        this.prodRepo = prodRepo;
    }

    @Override
    public List<Producto> traerProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto buscarProducto(Long codProd) {
        return prodRepo.findById(codProd).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto prod) {
        //validacion para que el producto no sea null
        if (prod == null) {
            return null;
        }
        //falta validar si cada uno de los elementos es null o no en el json
        boolean valido = this.validarDatos(prod);
        if(valido == false){
            return null;
        }
        //id se genera automaticamente en la bd y con esto lo devolvemos junto con el prod
        return prodRepo.save(prod);

    }

    @Override
    public Producto editarProducto(Long codProd, Producto prod) {
        //buscar si existe el prod
        Producto prodExistente = buscarProducto(codProd);

        //SI N0 EXISTE
        if (prodExistente == null) {
            return null;
        }

        boolean valido = this.validarDatos(prod);
        if(valido == false){
            return null;
        }
        //si existe...
        prodExistente.setCategoria(prod.getCategoria());
        prodExistente.setDescripcion(prod.getDescripcion());
        prodExistente.setMarca(prod.getMarca());
        prodExistente.setStock(prod.getStock());
        prodExistente.setPrecio(prod.getPrecio());
        prodExistente.setNombre(prod.getNombre());

        return prodRepo.save(prodExistente);
    }

    @Override
    public boolean eliminarProducto(Long codProd) {
        Producto prodExistente = buscarProducto(codProd);

        if (prodExistente == null) {
            return false;
        }

        prodRepo.delete(prodExistente);
        return true;
    }

    public boolean validarDatos(Producto prod) {

        if (prod.getNombre() == null || prod.getNombre().isBlank()) {
            return false; //si algun valor está vacio, retorna false
        }

        if (prod.getMarca() == null || prod.getMarca().isBlank()) {
            return false; //si algun valor está vacio, retorna false
        }

        if (prod.getCategoria() == null || prod.getCategoria().isBlank()) {
            return false; //si algun valor está vacio, retorna false
        }

        if (prod.getPrecio() == null || prod.getPrecio() <= 0) {
            return false; //si algun valor está vacio, retorna false
        }

        if (prod.getStock() <= 0) {
            return false; //si algun valor está vacio, retorna false
        }

        return true;
    }
}
