package com.centroeduc.model;

public class Maestro extends Persona {

    private String codigoA;
    private Integer estado;

    public Maestro() {
        this.codigoA = null;
        this.estado=null;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
