package com.centroeduc.model;

public class Notas {
    private Integer codAlumGrado;
    private Integer codUnidad;
    private Integer codNota;
    private Integer nota;
    private Integer cusGradSecProf;
    
    public Notas(){    
    } 
    public Notas(Integer codNota, Integer nota, Integer codAlumGrado, Integer codUnidad,Integer cusGradSecProf){
    this.codNota= codNota;
    this.nota=nota;
    this.codAlumGrado = codAlumGrado;
    this.codUnidad = codUnidad;
    this.cusGradSecProf = cusGradSecProf;
    }

    public Integer getCodAlumGrado() {
        return codAlumGrado;
    }

    public void setCodAlumGrado(Integer codAlumGrado) {
        this.codAlumGrado = codAlumGrado;
    }

    public Integer getCodUnidad() {
        return codUnidad;
    }

    public Integer getCusGradSecProf() {
        return cusGradSecProf;
    }

    public void setCusGradSecProf(Integer cusGradSecProf) {
        this.cusGradSecProf = cusGradSecProf;
    }

    public void setCodUnidad(Integer codUnidad) {
        this.codUnidad = codUnidad;
    }

    public Integer getCodNota() {
        return codNota;
    }

    public void setCodNota(Integer codNota) {
        this.codNota = codNota;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    
}
