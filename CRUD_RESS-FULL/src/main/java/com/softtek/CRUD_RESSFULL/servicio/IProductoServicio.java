package com.softtek.CRUD_RESSFULL.servicio;

import com.softtek.CRUD_RESSFULL.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerTodos();
    Producto obtenerProducto(int id);
    Producto crearProducto(Producto producto);
    void eliminarProducto(int id);
    Producto actualizarProducto(Producto producto);
}
