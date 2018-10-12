
package com.centroeduc.model;


public class AsignacionGSCP {
    public Integer codigo;
    public Integer cdGrado;
    public Integer cdSecc;
    public Integer cdCurso;
    public String cdMaestro;

    public AsignacionGSCP() {
        this.codigo = null;
        this.cdGrado = null;
        this.cdSecc = null;
        this.cdCurso = null;
        this.cdMaestro = null;
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Integer getCdGrado() {
        return cdGrado;
    }

    public void setCdGrado(Integer cdGrado) {
        this.cdGrado = cdGrado;
    }

    public Integer getCdSecc() {
        return cdSecc;
    }

    public void setCdSecc(Integer cdSecc) {
        this.cdSecc = cdSecc;
    }

    public Integer getCdCurso() {
        return cdCurso;
    }

    public void setCdCurso(Integer cdCurso) {
        this.cdCurso = cdCurso;
    }

    public String getCdMaestro() {
        return cdMaestro;
    }

    public void setCdMaestro(String cdMaestro) {
        this.cdMaestro = cdMaestro;
    }

    @Override
    public String toString() {
        return "AsignacionGSCP{" + "codigo=" + codigo + ", cdGrado=" + cdGrado + ", cdSecc=" + cdSecc + ", cdCurso=" + cdCurso + ", cdMaestro=" + cdMaestro + '}';
    }
    
}
