package com.centroeduc.model;

public class Seccion {

    private Integer codigo;
    private String descripcion;

    public Seccion() {
        this.codigo = null;
        this.descripcion = null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

}
