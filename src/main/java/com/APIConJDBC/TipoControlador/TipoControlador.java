package com.APIConJDBC.TipoControlador;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.APIConJDBC.ConfiguracioBeans.AppConfig;
import com.APIConJDBC.DAO.ProductoDAO;
import com.APIConJDBC.ModeloDTOs.Producto;

public class TipoControlador {
    
    //Estamos agregando algunos comentarios en la rama agregar comentarios
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

     private ProductoDAO productoDAO = new ProductoDAO(context.getBean(JdbcTemplate.class));

    public void imprimirProductos(){

        List<Producto> productos = productoDAO.obtenerProductos();
         
        productos.forEach(producto -> System.out.println(
            "Id: " + producto.getId() + ", Nombre: " + producto.getName() + " Modelo: " + producto.getModel() + ", Descripcion: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Descripcion: " + producto.getDescripcion()
            ));  
    }
    

    public void mostrarPorId(Integer id){
        Producto producto = productoDAO.obtenerPorId(id); //MAndamos a llamar al DAO y lo guardamos dentro de una variable

        System.out.println( "Id: " + producto.getId() + ", Nombre: " + producto.getName() + ", Modelo: " + producto.getModel() + ", Descripcion: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Tota en Stock: " + producto.getTotal_en_stock());
    }


    public void devolverPrecios(){
        List<Double> precios = productoDAO.devolverTodosLosPrecios();

        precios.forEach(precio -> System.out.println("Precio: " + precio) );
    }


    public String insertarProducto(Integer id, String nombre, String modelo, String descripcion, Double precio, Integer totalEnStock){

        Producto producto = new Producto(id, nombre, modelo, descripcion, precio, totalEnStock);

        try {
            productoDAO.insertarProducto(producto);
            return "Producto guardado con exito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se guardó el producto ";
        }
    }

    //Actualizar Descripcion:
    public void actualizarDescripcion(String descripcion, Integer id){
        try {
            productoDAO.actualizarDescripcion(descripcion, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void eliminadPorId(Integer id){
        try {
            productoDAO.eliminiarPorId(id);
            System.out.println("Procuto eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }



    //PRUEBAS
    public static void main(String[] args) {
        TipoControlador controlador = new TipoControlador();
        //controlador.imprimirProductos();
        //controlador.insertarProducto(11, "Shampoo para animal", "pantene", "200 ml de shampoo", 40.2, 10);
        //controlador.mostrarPorId(4);
        //controlador.eliminadPorId(10);
        //controlador.actualizarDescripcion("Esta es la descripcion actualizada", 4);
        controlador.devolverPrecios();
    }
}
