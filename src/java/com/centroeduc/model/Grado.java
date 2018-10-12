/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroeduc.model;

/**
 *
 * @author Usuario
 */
public class Grado {
    private Integer cod_grado;
    private String descripcion;
    private Integer estado;

    public Grado() {
        this.cod_grado =null;
        this.descripcion =null;
        this.estado = null;
        
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getCod_grado() {
        return cod_grado;
    }

    public void setCod_grado(Integer cod_grado) {
        this.cod_grado = cod_grado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Grado{" + "cod_grado=" + cod_grado + ", descripcion=" + descripcion + '}';
    }
    
    

}
