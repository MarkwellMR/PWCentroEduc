package com.centroeduc.model;

public class AlumnoGrado  {
    
    public Integer CodAlumnoGrado;
    public Integer Ccursgradsecprof;
    public Integer year;
    public Integer CodAlumnos;

    public AlumnoGrado() {
       
        this.Ccursgradsecprof = null;
        this.year = null;
        this.CodAlumnoGrado = null;
        this.CodAlumnos = null;
    }
    public Integer getCodAlumnoGrado() {
        return CodAlumnoGrado;
    }

    public void setCodAlumnoGrado(Integer CodAlumnoGrado) {
        this.CodAlumnoGrado = CodAlumnoGrado;
    }
    
    public Integer getCcursgradsecprof() {
        return Ccursgradsecprof;
    }

    public void setCcursgradsecprof(Integer Ccursgradsecprof) {
        this.Ccursgradsecprof = Ccursgradsecprof;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    
    public Integer getCodAlumnos() {
        return CodAlumnos;
    }

    public void setCodAlumnos(Integer CodAlumnos) {
        this.CodAlumnos = CodAlumnos;
    }

    @Override
    public String toString() {
        return "AlumnoGrado{" + "CodAlumnoGrado=" + CodAlumnoGrado + ", CodAlumnos=" + CodAlumnos + ", Ccursgradsecprof=" + Ccursgradsecprof + ", year=" + year + '}';
    }
}