package com.centroeduc.controller;

import com.centroeduc.dao.SeccionDAO;
import com.centroeduc.model.Seccion;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ControladorSeccion {

    ArrayList<Seccion> mostrarSeccion = new ArrayList();
    Seccion sec = new Seccion();
    
    String mensaje = null;

    public Seccion getSec() {
        return sec;
    }

    public void setSec(Seccion sec) {
        this.sec = sec;
    }

    public ArrayList<Seccion> getMostrarSeccion() {
        return mostrarSeccion;
    }

    public void setMostrarSeccion(ArrayList<Seccion> mostrarSeccion) {
        this.mostrarSeccion = mostrarSeccion;
    }

    public void cargarSeccion() {
        SeccionDAO secda = new SeccionDAO();
        mostrarSeccion = secda.MostrarSeccion();
    }

    public void guardarSeccion() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        SeccionDAO secd = new SeccionDAO();
        try {
            mensaje = secd.insertarSeccion(sec);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en controlador maestro" + e);
        }
    }

    public void busquedaSeccion(Seccion secci) {
        SeccionDAO sed = new SeccionDAO();
        try {
            sec = sed.buscarCodigo(secci.getCodigo());
        } catch (Exception e) {
            System.out.println("error en el controlador de busqueda de datos" + e);
        }
    }

    public void actualizarSeccion() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        SeccionDAO daos = new SeccionDAO();
        try {
            mensaje = daos.editarSeccion(sec);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en controlador actualizar seccion" + e);
        }
    }

    public void busquedaCodigo() {
        SeccionDAO daose = new SeccionDAO();
        try {
            Seccion secci = new Seccion();
            secci = daose.buscarCodigo(sec.getCodigo());
            sec = secci;
            System.out.println("Seccion: " + sec.getDescripcion());
        } catch (Exception ex) {
            System.out.println("error en controlador busqueda" + ex);
        }
    }

    public void eliminarSeccion() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        SeccionDAO secd = new SeccionDAO();
        try {
            mensaje = secd.eliminarSeccion(sec.getCodigo());
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en controlador eliminar" + e);
        }
    }

}
