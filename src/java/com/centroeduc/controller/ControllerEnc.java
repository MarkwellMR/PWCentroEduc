package com.centroeduc.controller;

import com.centroeduc.dao.EncargadoDAO;
import com.centroeduc.model.Encargado;
import com.centroeduc.model.Secretaria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ControllerEnc implements Serializable {

    private ArrayList<Encargado> filtro;
    Encargado enc = new Encargado();
    Secretaria sec = new Secretaria();
    EncargadoDAO encdao = new EncargadoDAO();
    ArrayList<Encargado> listaEnc = new ArrayList();
    ArrayList<Encargado> listaBusEnc = new ArrayList();

    private Date date;
    String mensaje = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Encargado> getFiltro() {
        return filtro;
    }

    public void setFiltro(ArrayList<Encargado> filtro) {
        this.filtro = filtro;
    }

    public ArrayList<Encargado> getListaBusEnc() {
        return listaBusEnc;
    }

    public void setListaBusEnc(ArrayList<Encargado> listaBusEnc) {
        this.listaBusEnc = listaBusEnc;
    }

    public ArrayList<Encargado> getListaEnc() {
        return listaEnc;
    }

    public void setListaEnc(ArrayList<Encargado> listaEnc) {
        this.listaEnc = listaEnc;
    }

    public void cargarDatos() {
        listaEnc = encdao.MostarEncargado();

    }

    public void loadDatos() {
        listaBusEnc = encdao.BusquedaXnombre(enc.getNombre());
    }

    public void buscarPorNombre() {
        listaBusEnc = encdao.BusquedaXnombre(enc.getNombre());
        System.out.println("CONTROLADOR ENCARGADO");
        for (Encargado encargado : listaEnc) {
            System.out.println("nombre: " + encargado.getNombre());
        }
    }

    public Encargado getEnc() {
        return enc;
    }

    public void setEnc(Encargado enc) {
        this.enc = enc;
    }

    public Secretaria getSec() {
        return sec;
    }

    public void setSec(Secretaria sec) {
        this.sec = sec;
    }

    public void guardarEnc() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = encdao.nuevoEncargado(enc, sec, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en Guardar " + e);
        }
    }

    public void searchEnc(Encargado datos) {
        try {
            Encargado provicional = new Encargado();
            provicional = encdao.searchId(datos.getCodEnc());
            this.enc = provicional;
        } catch (Exception e) {
            System.out.println("error en el metdo SearcEnc " + e);
        }
    }

    public void updEnc() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = encdao.UpEnc(enc, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en Actualizar " + e);
        }
    }

    public void deleteEnc() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = encdao.cambioEstado(enc.getCodEnc());
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Erroe en DeleteEnc: " + e);
        }
    }
}
