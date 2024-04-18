package com.softtek.CRUD_RESSFULL.repo;

import com.softtek.CRUD_RESSFULL.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepo implements IProductoRepo {
    @Autowired
    private Conexion conexion;

    @Override
    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        try {
            conexion.abrirConexion();
            PreparedStatement ps = conexion.getMiConexion().prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("supplier_id"),
                        rs.getInt("category_id"),
                        rs.getString("quantity_per_unit"),
                        rs.getDouble("unit_price"),
                        rs.getInt("units_in_stock"),
                        rs.getInt("units_on_order"),
                        rs.getInt("reorder_level"),
                        rs.getInt("discontinued")
                ));
            }
            conexion.cerrarConexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto obtenerProducto(int id) {
        try {
            conexion.abrirConexion();
            PreparedStatement ps = conexion.getMiConexion().prepareStatement("SELECT * FROM products WHERE product_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("supplier_id"),
                        rs.getInt("category_id"),
                        rs.getString("quantity_per_unit"),
                        rs.getDouble("unit_price"),
                        rs.getInt("units_in_stock"),
                        rs.getInt("units_on_order"),
                        rs.getInt("reorder_level"),
                        rs.getInt("discontinued")
                );
            }
            conexion.cerrarConexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        try {
            conexion.abrirConexion();
            PreparedStatement ps = conexion.getMiConexion().prepareStatement("INSERT INTO products (product_id ,product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, reorder_level, discontinued) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1,producto.getIdProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setInt(3, producto.getId_supplier());
            ps.setInt(4, producto.getId_categoria());
            ps.setString(5, producto.getCantidad());
            ps.setDouble(6, producto.getPrecioUnitario());
            ps.setInt(7, producto.getUnidadesStock());
            ps.setInt(8, producto.getVolverAPedir());
            ps.setInt(9, producto.getDiscontinua());
            ps.executeUpdate();
            conexion.cerrarConexion();
            return producto;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminarProducto(int id) {
        try {
            conexion.abrirConexion();
            PreparedStatement ps = conexion.getMiConexion().prepareStatement("DELETE FROM products WHERE product_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            conexion.cerrarConexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        try {
            conexion.abrirConexion();
            PreparedStatement ps = conexion.getMiConexion().prepareStatement("UPDATE products SET product_name = ?, supplier_id = ?, category_id = ?, quantity_per_unit = ?, unit_price = ?, units_in_stock = ?, reorder_level = ?, discontinued = ? WHERE product_id = ?");
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getId_supplier());
            ps.setInt(3, producto.getId_categoria());
            ps.setString(4, producto.getCantidad());
            ps.setDouble(5, producto.getPrecioUnitario());
            ps.setInt(6, producto.getUnidadesStock());
            ps.setInt(7, producto.getVolverAPedir());
            ps.setInt(8, producto.getDiscontinua());
            ps.setInt(9, producto.getIdProducto());
            ps.executeUpdate();
            conexion.cerrarConexion();
            return producto;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

