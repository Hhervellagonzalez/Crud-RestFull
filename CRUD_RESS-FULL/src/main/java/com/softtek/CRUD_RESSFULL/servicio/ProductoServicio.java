package com.softtek.CRUD_RESSFULL.servicio;

import com.softtek.CRUD_RESSFULL.modelo.Producto;
import com.softtek.CRUD_RESSFULL.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {
    @Autowired
    private IProductoRepo productoRepo;

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepo.obtenerTodos();
    }

    @Override
    public Producto obtenerProducto(int id) {
        return productoRepo.obtenerProducto(id);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepo.crearProducto(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        productoRepo.eliminarProducto(id);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepo.actualizarProducto(producto);
    }
}
