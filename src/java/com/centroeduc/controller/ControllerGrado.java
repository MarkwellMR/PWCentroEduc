package com.centroeduc.controller;

import com.centroeduc.dao.GradoDAO;
import com.centroeduc.model.Grado;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ControllerGrado {

    ArrayList<Grado> listaGrado = new ArrayList();
    Grado grado = new Grado();

    String mensaje = null;

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public ArrayList<Grado> getListaGrado() {
        return listaGrado;
    }

    public void setListaGrado(ArrayList<Grado> listaGrado) {
        this.listaGrado = listaGrado;
    }

    public void cargarGrado() {
        GradoDAO graddao = new GradoDAO();
        listaGrado = graddao.mostrarGrado();
    }

    public void guardarGrado() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        GradoDAO graddao = new GradoDAO();
        try {
            mensaje = graddao.ingresarGrado(grado);
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error en el controlador de guardar grado" + e);
        }
    }

    public void busquedaDatosGrado(Grado dato) {
        GradoDAO graddao = new GradoDAO();
        try {
            grado = graddao.busquedaDatos(dato.getCod_grado());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }

    public void busquedaCodigo() {
        GradoDAO grad1 = new GradoDAO();
        try {
            Grado provisional = new Grado();
            provisional = grad1.busquedaDatos(grado.getCod_grado());
            grado = provisional;
            System.out.println("alumno: " + grado.getDescripcion());
        } catch (Exception ex) {
            System.out.println("Error controlador busqueda Codigo: " + ex);
        }
    }

    public void actualizarDatosGrado() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        GradoDAO gradodao = new GradoDAO();
        try {
            mensaje = gradodao.modificarGrado(grado);
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error controlador actualizar Grado" + e);
        }
    }

    public void elimGrado() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        GradoDAO grados = new GradoDAO();
        try {
            mensaje = grados.eliminarGrado(grado);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en el controlador de cambio de estado" + e);
        }
    }
}
