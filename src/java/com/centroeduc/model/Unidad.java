
package com.centroeduc.model;

public class Unidad {

    private String nombre;
    private String descripcion;
    private String fechaIni;
    private String fechaFin;
    private Integer estado;
    private Integer codigo;
    private Integer cusGradSecProf;

    public Unidad() {
        this.nombre = null;
        this.descripcion = null;
        this.fechaIni = null;
        this.fechaFin = null;
        this.estado = null;
        this.codigo = null;
        this.cusGradSecProf= null;
    }

    public Integer getCusGradSecProf() {
        return cusGradSecProf;
    }

    public void setCusGradSecProf(Integer cusGradSecProf) {
        this.cusGradSecProf = cusGradSecProf;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaUni) {
        this.fechaIni = fechaUni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Unidad{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + '}';
    }

}
