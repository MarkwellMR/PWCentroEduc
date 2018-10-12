package com.centroeduc.controller;

import com.centroeduc.dao.MaestroDAO;
import com.centroeduc.model.Maestro;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ControladorMaestro {

    ArrayList<Maestro> mostrarMaestro = new ArrayList();
    Maestro maes = new Maestro();
    
    private Date date;
    String mensaje = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Maestro getMaes() {
        return maes;
    }

    public void setMaes(Maestro maes) {
        this.maes = maes;
    }

    public ArrayList<Maestro> getMostrarMaestro() {
        return mostrarMaestro;
    }

    public void setMostrarMaestro(ArrayList<Maestro> mostrarMaestro) {
        this.mostrarMaestro = mostrarMaestro;
    }

    public void cargarMaestro() {
        MaestroDAO daou = new MaestroDAO();
        mostrarMaestro = daou.Mostrarprofesor();
    }

    public void guardarMaestro() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        MaestroDAO daou = new MaestroDAO();
        try {
            mensaje = daou.insertarMaestro(maes, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en controlador maestro" + e);
        }
    }

    public void busquedaDatosMaestro(Maestro dato) {
        MaestroDAO daoum = new MaestroDAO();
        try {
            maes = daoum.buscarCodigo(dato.getCodigo());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }

    public void actualizarMaestro() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        MaestroDAO dao = new MaestroDAO();
        try {
            mensaje = dao.editarMaestro(maes, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en el controlador de actualizar Mestro" + e);
        }
    }

    public void busquedaCodigo() {
        MaestroDAO daoum = new MaestroDAO();
        try {
            Maestro ma = new Maestro();
            ma = daoum.buscarCodigo(maes.getCodigo());
            maes = ma;
            System.out.println("Maestro: " + maes.getNombre());
        } catch (Exception ex) {
            System.out.println("Error controlador: " + ex);
        }
    }

    public void elEstado() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        MaestroDAO maest = new MaestroDAO();
        try {
            mensaje = maest.estadoMaestro(maes);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("error en controlador estado" + e);
        }
    }

}
