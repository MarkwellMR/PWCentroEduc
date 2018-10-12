
package com.centroeduc.model;

public class Curso {
    private Integer cod;
    private String nombre;
    private String hinicio;
    private String hfin;
    private String jornada;
    private Integer cupo;
    private Integer estado;

    public Curso() {
        this.cod = null;
        this.nombre = null;
        this.hinicio = null;
        this.hfin = null;
        this.jornada = null;
        this.cupo = null;
        this.estado = null;
    }

    public Curso(Integer cod, String nombre, String hinicio, String hfin, String jornada, Integer cupo, Integer estado) {
        this.cod = cod;
        this.nombre = nombre;
        this.hinicio = hinicio;
        this.hfin = hfin;
        this.jornada = jornada;
        this.cupo = cupo;
        this.estado = estado;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHinicio() {
        return hinicio;
    }

    public void setHinicio(String hinicio) {
        this.hinicio = hinicio;
    }

    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Curso{" + "cod=" + cod + ", nombre=" + nombre + ", hinicio=" + hinicio + ", hfin=" + hfin + ", jornada=" + jornada + ", cupo=" + cupo + ", estado=" + estado + '}';
    }
}
