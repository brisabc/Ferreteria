package com.prueba_tecnica.Ferreteria_industrial.controller;

import com.prueba_tecnica.Ferreteria_industrial.model.Producto;
import com.prueba_tecnica.Ferreteria_industrial.service.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
    private final IProductoService prodServ; //instancia para conectarse a la interfaz

    public ProductoWebController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }

    @GetMapping //trae la lista de productos
    public String traerProductos(Model model){
        model.addAttribute(
                "productos", prodServ.traerProductos()
        );

        return "productos/lista";
    }

    @GetMapping ("/nuevo") //traer formulario
    public String mostrarFormulario(Model model){

        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Registrar producto");

        return "productos/formulario";
    }

    @PostMapping ("/crear") //para guardar los datos del formuulario
    public String crearProducto(@ModelAttribute Producto producto, Model model){

        Producto resultado;
        if (producto.getCodProducto()==null){
            resultado = prodServ.crearProducto(producto);
        }else { //en caso que el producto ya exista...
            resultado = prodServ.editarProducto(producto.getCodProducto(), producto);
        }

        if (resultado == null){
            model.addAttribute("producto", producto);
            model.addAttribute("titulo", producto.getCodProducto() == null
                               ? "Registrar producto" : "Editar producto");
            model.addAttribute("error", "revisa los datos. Nombre, marca y categoria son obligatorios" +
                               "El precio debe ser mayor a cero y el stock no puede ser negativo"
                                 );
            return "productos/formulario";
        }
        return "redirect:/productos";
    }

    //editar
    @GetMapping("/editar/{codProd}")
    public String mostrarFormularioEditar(
            @PathVariable Long codProd,
            Model model){

        Producto producto = prodServ.buscarProducto(codProd);
        //si no encuentra el producto...
        if (producto == null){
            return "redirect:/productos";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar producto");

        return "productos/formulario"; //volvemos a formulario
    }

    @PostMapping("/eliminar/{codProd}")
    public String eliminarProducto(@PathVariable Long codProd){

        prodServ.eliminarProducto(codProd);

        return "redirect:/productos";
    }

}
