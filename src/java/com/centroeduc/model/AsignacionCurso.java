
package com.centroeduc.model;

public class AsignacionCurso {
    private Integer codigo;
    private String grado;
    private String seccion;
    private String curso;
    private String profesor;

    public AsignacionCurso() {
    }

    public AsignacionCurso(Integer codigo, String grado, String seccion, String curso, String profesor) {
        this.codigo = codigo;
        this.grado = grado;
        this.seccion = seccion;
        this.curso = curso;
        this.profesor = profesor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "AsignacionCurso{" + "codigo=" + codigo + ", grado=" + grado + ", seccion=" + seccion + ", curso=" + curso + ", profesor=" + profesor + '}';
    }
    
    
}
