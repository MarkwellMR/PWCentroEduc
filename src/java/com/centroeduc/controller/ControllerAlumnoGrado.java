/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroeduc.controller;

import com.centroeduc.dao.AlumnoDAO;
import com.centroeduc.dao.AlumnoGradoDAO;
import com.centroeduc.dao.AsignGSCPDAO;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.AsignacionGSCP;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

/**
 *
 * @author Usuario
 */
public class ControllerAlumnoGrado {

    AlumnoGradoDAO graddao = new AlumnoGradoDAO();
    AlumnoDAO alum = new AlumnoDAO();
    AsignGSCPDAO dao = new AsignGSCPDAO();

    Alumno alumno = new Alumno();
    AsignacionGSCP asing = new AsignacionGSCP();
    AlumnoGrado datos = new AlumnoGrado();

    ArrayList<Alumno> ListaAlumno = new ArrayList();
    ArrayList<AlumnoGrado> ListaAlumnoGrado = new ArrayList();
    ArrayList<AsignacionGSCP> ListaAsignacion = new ArrayList();
    

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public AsignacionGSCP getAsing() {
        return asing;
    }

    public void setAsing(AsignacionGSCP asing) {
        this.asing = asing;
    }

    public AlumnoGrado getDatos() {
        return datos;
    }

    public void setDatos(AlumnoGrado datos) {
        this.datos = datos;
    }

    public ArrayList<Alumno> getListaAlumno() {
        return ListaAlumno;
    }

    public void setListaAlumno(ArrayList<Alumno> ListaAlumno) {
        this.ListaAlumno = ListaAlumno;
    }

    public ArrayList<AlumnoGrado> getListaAlumnoGrado() {
        return ListaAlumnoGrado;
    }

    public void setListaAlumnoGrado(ArrayList<AlumnoGrado> ListaAlumnoGrado) {
        this.ListaAlumnoGrado = ListaAlumnoGrado;
    }

    public ArrayList<AsignacionGSCP> getListaAsignacion() {
        return ListaAsignacion;
    }

    public void setListaAsignacion(ArrayList<AsignacionGSCP> ListaAsignacion) {
        this.ListaAsignacion = ListaAsignacion;
    }

    

    public void cargarListasAlumnosGrado() {
        try {
            
            ListaAlumnoGrado = graddao.MostrarDatosAlumnosGrado();
            ListaAsignacion = dao.listAsign();
            ListaAlumno = alum.mostrarAlumno();
            
        } catch (Exception e) {
            System.out.println("No se puede cargar : " + e);
        }

    }

    public void guardarAlumnoGrado() {
        System.out.println("Codigo Alumno: " + this.alumno.getCodAlumno());
        System.out.println("C Asignacion: " + this.asing.getCodigo());
        System.out.println("Ciclo: " + this.datos.getYear());
        try {
            graddao.asignarAG(this.alumno.getCodAlumno(), this.asing.getCodigo(), this.datos.getYear());
        } catch (Exception e) {
            System.out.println("Error en el controlador AlumnoGrado(Guardar): " + e);
        }
    }

    public void busquedaDatosAlumnoGrado(AlumnoGrado dato) {
        AlumnoGradoDAO daoum = new AlumnoGradoDAO();
        try {
            datos = daoum.busquedaCodigo(dato.getCodAlumnoGrado());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }

    public void busquedaCodigoAlumnoGrado() {
        AlumnoGradoDAO daoum = new AlumnoGradoDAO();
        try {
            AlumnoGrado ma = new AlumnoGrado();
            ma = daoum.busquedaCodigo(datos.getCodAlumnoGrado());
            datos = ma;

        } catch (Exception ex) {
            System.out.println("Error controlador de busqueda codigo alumno: " + ex);
        }
    }

}
