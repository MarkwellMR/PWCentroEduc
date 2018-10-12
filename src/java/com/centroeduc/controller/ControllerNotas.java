package com.centroeduc.controller;

import com.centroeduc.dao.MaestroDAO;
import com.centroeduc.dao.NotasDAO;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.Curso;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Maestro;
import com.centroeduc.model.Notas;
import com.centroeduc.model.Seccion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerNotas implements Serializable{
    Notas nota = new Notas();
    Grado grado = new Grado();
    ArrayList<Notas> listaNotas = new ArrayList();
    ArrayList<Grado> listaGrado = new ArrayList();
    ArrayList<Maestro> ListaMaestros = new ArrayList();
    ArrayList<Seccion> lstSec = new ArrayList();
    ArrayList<Curso> lstCurso = new ArrayList();
    ArrayList<Alumno> lstAl = new ArrayList();
    
    private String codMae;
    private int codSec;
    private int codGrad;
    private int codCurso;
    private int codAlum;
    private Integer codUnidad;
    
    
    MaestroDAO maesdao = new MaestroDAO();
    
        // Getter y Setters

    public Integer getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Integer codUnidad) {
        this.codUnidad = codUnidad;
    }
    
    

    public int getCodAlum() {
        return codAlum;
    }

    public void setCodAlum(int codAlum) {
        this.codAlum = codAlum;
    }
    
    
    public ArrayList<Alumno> getLstAl() {
        return lstAl;
    }

    public void setLstAl(ArrayList<Alumno> lstAl) {
        this.lstAl = lstAl;
    }
    
    
    public int getCodCurso() {
        return codCurso;
    }
    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public ArrayList<Seccion> getLstSec() {
        return lstSec;
    }

    public void setLstSec(ArrayList<Seccion> lstSec) {
        this.lstSec = lstSec;
    }
    
    
    
    public String getCodMae() {    
        return codMae;
    }
    
    public int getCodSec() {
        return codSec;
    }

    public void setCodSec(int codSec) {
        this.codSec = codSec;
    }

    public int getCodGrad() {
        return codGrad;
    }


    public void setCodGrad(int codGrad) {    
        this.codGrad = codGrad;
    }

    public void setCodMae(String codMae) {
        this.codMae = codMae;
    }

    public ArrayList<Maestro> getListaMaestros() {
        return ListaMaestros;
    }

    public void setListaMaestros(ArrayList<Maestro> ListaMaestros) {
        this.ListaMaestros = ListaMaestros;
    }

    public ArrayList<Notas> getListaNotas() {
        return listaNotas;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public void setListaNotas(ArrayList<Notas> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public ArrayList<Grado> getListaGrado() {
        return listaGrado;
    }

    NotasDAO notasdao = new NotasDAO();
    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }

    public ArrayList<Curso> getLstCurso() {
        return lstCurso;
    }

    public void setLstCurso(ArrayList<Curso> lstCurso) {
        this.lstCurso = lstCurso;
    }
    
    
    
    //Metodos 
        public void cargarMaestro(){
        ListaMaestros = maesdao.Mostrarprofesor();
        
    }
    
    public void mostrarNotas(){
        try {
            listaNotas = notasdao.MostrarNotas();
        } catch (Exception e) {
            System.out.println("Erro en Metodo Mostrar Notas " + e);
        }
    }
    
    public ArrayList<Grado> ListasGrado(){
        try {
            listaGrado = notasdao.MostrarGrado(this.codMae);
            System.out.println("codigo de Maestro " + this.codMae);
        } catch (Exception e) {
            System.out.println("Error en ListasGrado: " + e);
        }
        return listaGrado;
    }

    public ArrayList<Seccion>cargarSeccion(){
        try {
            this.lstSec = notasdao.MostrarSec(this.codMae, this.codGrad);          
        } catch (Exception e) {
            System.out.println("Error en cargarSeccion " + e);
        }
       return lstSec;
    }
    public void cargarCurso(){
        try {
            this.lstCurso = notasdao.MostrarCurso(codMae, codGrad, codSec);
        } catch (Exception e) {
            System.out.println("Erroer en CargarCurso " + e);
        }
    }
    
    public void cargarAlumno(){
        try {
            this.lstAl = notasdao.MostrarAlumno(codMae, codGrad, codSec, codCurso);
            
        } catch (Exception e) {
            System.out.println("Error en cargarAlumno" + e);
        }
    }
    
    public void mostrarCodAlum(int cda, int nta, int und){
        int rs = notasdao.AgregarNotas(codMae, codGrad, codSec, codCurso, cda);
        String ResultadoNotas;
        try {
            
            System.out.println("rs " + rs);
            ResultadoNotas = notasdao.agregarNotas(rs,nta, und);
            
        } catch (Exception e) {
            System.out.println("error xD");
        }
        
        
    }
    
    
}
