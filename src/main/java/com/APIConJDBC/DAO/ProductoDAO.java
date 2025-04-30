package com.APIConJDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.APIConJDBC.ModeloDTOs.Producto;
//ESTO TAMBIEN ES UN COMENTARIO DE PRUEBA PARA REPASAR EL FUNCIONAMIENTO DE LAS RAMAS

/*
 * Biografia: 
 * Benito Pablo Juárez García (San Pablo Guelatao, Intendencia de Oaxaca; 21 de marzo de 1806-Ciudad de México, 
 * 18 de julio de 1872), conocido como El Benemérito de las Américas,[1]​ fue un jurista y político mexicano de origen 
 * indígena de la etnia zapoteca que se desempeñó como presidente de México en varias ocasiones, desde el 21 de enero de 1858 hasta el 18 de julio de 1872.[2]​ Es célebre su frase: «Entre los individuos, como entre las naciones, el respeto al derecho ajeno es la paz».[3]​
 */

@Repository
public class ProductoDAO {

    private final JdbcTemplate jdbcTemplate;

    // CONSTRUCTOR
    public ProductoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //METODO PARA DEVOLVER TODOS LOS PRODUCTOS ALMACENADOS EN LA BASE DE DATOS
    public List<Producto> obtenerProductos(){
        String sql = "SELECT * FROM PRODUCTO2";
        
        return jdbcTemplate.query(sql, new RowMapper<Producto>() {  //query devuelve una lista de objetos

            @Override
            public Producto mapRow(ResultSet rs, int rowNum) throws SQLException { 
                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setName(rs.getString("name"));
                producto.setModel(rs.getString("model"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setTotal_en_stock(rs.getInt("total_en_stock"));

                return producto;
            }
        });
    }

    //DEVOLVER TODOS LOS PRECIOS
    public List<Double> devolverTodosLosPrecios(){
        String sql = "SELECT PRECIO FROM PRODUCTO2";

        return jdbcTemplate.query(sql, new RowMapper<Double>(){

            @Override
            @Nullable
            public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
                Double precio = rs.getDouble("precio");
                return precio;
            }
        });
    }


    // SELECCIONAR POR ID 
    public Producto obtenerPorId(Integer id) {
        String sql = "SELECT * FROM PRODUCTO2 WHERE ID = ?";
    
        return jdbcTemplate.queryForObject(sql, new RowMapper<Producto>() { //ROWMAPPER es un metodo dentro de otro metodo (MAPEADOR DE FILAS)
            //METODO DENTRO DE OTRO METODO
            @Override
            public Producto mapRow(ResultSet rs, int rowNum) throws SQLException { //Aqui definimos las filas que tiene la tabla y el orden en el que queremos que lo muestre
                Producto producto = new Producto(); //Instancia del DTO (Tabla) que mostraremos 
                producto.setId(rs.getInt("id"));            //Asignamos el valor obtenido de la consulta, con el resultado del Resulset señalando el nombre de la columna 
                producto.setName(rs.getString("name"));
                producto.setModel(rs.getString("model"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setTotal_en_stock(rs.getInt("total_en_stock"));
                return producto;
            }
        }, id);
    }    

    // INSERTAR NUEVO PRODUCTO
    public void insertarProducto(Producto producto){
        String sql = "INSERT INTO PRODUCTO2 (ID, NAME, MODEL, DESCRIPCION, PRECIO, TOTAL_EN_STOCK) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getId(), producto.getName(), producto.getModel(),
                                                  producto.getDescripcion(), producto.getPrecio(), producto.getTotal_en_stock());
        //return filasAfectadas > 0;
    }


    //ACTUALIZAR PARAMETRO: DESCRIPCION 
    public void actualizarDescripcion(String descripcion, Integer id){
        String sql = "update producto2 set descripcion = ? where id = ?";

        jdbcTemplate.update(sql, descripcion, id);
    }
    

    //METODO PARA ELIMINAR
    public void eliminiarPorId(Integer eliminiar){
        String sql = "DELETE FROM PRODUCTO2 WHERE ID = ?";
        jdbcTemplate.update(sql, eliminiar);
    }

    
    
}
