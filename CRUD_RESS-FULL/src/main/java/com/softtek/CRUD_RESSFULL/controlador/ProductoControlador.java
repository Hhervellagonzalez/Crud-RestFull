package com.softtek.CRUD_RESSFULL.controlador;

import com.softtek.CRUD_RESSFULL.modelo.Producto;
import com.softtek.CRUD_RESSFULL.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable int id) {
        return productoServicio.obtenerProducto(id);
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        System.out.println(producto);
        return productoServicio.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void borrarProducto(@PathVariable int id) {
        productoServicio.eliminarProducto(id);
    }

    @PutMapping
    public Producto modificarProducto(@RequestBody Producto producto) {
        return productoServicio.actualizarProducto(producto);
    }
}
