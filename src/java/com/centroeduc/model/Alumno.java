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
public class Alumno extends Persona {

    private Integer codAlumno;
    private Integer telEmergencia;
    private String padecimiento;
    private Integer codEncargado;
    private String codSecretaria;
    private String ciclo;

    public Alumno() {
        this.codAlumno = null;
        this.telEmergencia = null;
        this.padecimiento = null;
        this.codEncargado = null;
        this.codSecretaria = null;
        this.ciclo = null;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(Integer codAlumno) {
        this.codAlumno = codAlumno;
    }

    public Integer getCodEncargado() {
        return codEncargado;
    }

    public void setCodEncargado(Integer codEncargado) {
        this.codEncargado = codEncargado;
    }
    
    public String getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(String codSecretaria) {
        this.codSecretaria = codSecretaria;
    }

    public Integer getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(Integer telEmergencia) {
        this.telEmergencia = telEmergencia;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" + "codAlumno=" + codAlumno + ", telEmergencia=" + telEmergencia + ", padecimiento=" + padecimiento + ", codEncargado=" + codEncargado + ", codSecretaria=" + codSecretaria + '}';
    }

    
    
}

