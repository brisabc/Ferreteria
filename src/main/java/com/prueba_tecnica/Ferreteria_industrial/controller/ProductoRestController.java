package com.prueba_tecnica.Ferreteria_industrial.controller;

import com.prueba_tecnica.Ferreteria_industrial.model.Producto;
import com.prueba_tecnica.Ferreteria_industrial.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final IProductoService prodServ; //instancia para conectarse a la interfaz

    public ProductoRestController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }

    @GetMapping
    public List<Producto> traerProductos(){
        return prodServ.traerProductos(); }

    //read de producto especifico
    @GetMapping("/{codProd}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long codProd) {
        Producto prod = prodServ.buscarProducto(codProd);
        if (prod == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("los datos del producto no se encuentran con ese codigo :/");
        }

        return ResponseEntity.ok(prod);
    }
    //create
    @PostMapping
    public ResponseEntity<?> crearProducto (@RequestBody Producto prod){

        Producto productoCreado = prodServ.crearProducto(prod);

        if (productoCreado == null){
            return ResponseEntity.badRequest().body("los datos del producto no son validos :/");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("el producto ha sido creado");
    }

    //update
    @PutMapping("/{codProd}")
    public ResponseEntity<?> editarProducto (@PathVariable Long codProd,
                                             @RequestBody Producto prodAModificar){
        Producto prodEditado = prodServ.editarProducto(codProd, prodAModificar);

        if (prodEditado == null) {
            return ResponseEntity.badRequest().body("no fue posible editar el producto :/");
        }

        return ResponseEntity.ok(prodEditado);
    }
    //delete
    @DeleteMapping("/{codProd}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long codProd) {

        boolean eliminado = prodServ.eliminarProducto(codProd);

        if (eliminado == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontró el producto con la id :/" + codProd);


        }
        return ResponseEntity.ok("producto eliminado correctamente >:)");
    }
}
