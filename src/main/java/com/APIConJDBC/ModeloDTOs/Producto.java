package com.APIConJDBC.ModeloDTOs;

public class Producto {
    // id, name, model, descripcion, precio, total_en_stock
    private Integer id;
    private String name;
    private String model;
    private String descripcion;
    private Double precio;
    private Integer total_en_stock;

    public Producto() {
    }

    public Producto(Integer id, String name, String model, String descripcion, Double precio, Integer total_en_stock) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.descripcion = descripcion;
        this.precio = precio;
        this.total_en_stock = total_en_stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getTotal_en_stock() {
        return total_en_stock;
    }

    public void setTotal_en_stock(Integer total_en_stock) {
        this.total_en_stock = total_en_stock;
    }
    
    
    
}
