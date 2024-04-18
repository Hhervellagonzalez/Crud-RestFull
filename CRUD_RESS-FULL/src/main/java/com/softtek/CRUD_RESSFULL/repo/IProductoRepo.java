package com.softtek.CRUD_RESSFULL.repo;

import com.softtek.CRUD_RESSFULL.modelo.Producto;

import java.util.List;

public interface IProductoRepo {
    List<Producto> obtenerTodos();
    Producto obtenerProducto(int id);
    Producto crearProducto(Producto producto);
    void eliminarProducto(int id);
    Producto actualizarProducto(Producto producto);
}
