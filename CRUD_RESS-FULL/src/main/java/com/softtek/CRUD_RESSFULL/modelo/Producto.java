package com.softtek.CRUD_RESSFULL.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int id_supplier;
    private int id_categoria;
    private String cantidad;
    private double precioUnitario;
    private int unidadesStock;
    private int enPedido;
    private int volverAPedir;
    private int discontinua;
}
