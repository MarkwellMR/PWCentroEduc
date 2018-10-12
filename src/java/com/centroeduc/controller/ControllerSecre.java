package com.centroeduc.controller;

import com.centroeduc.dao.AdminDAO;
import com.centroeduc.dao.SecreDao;
import com.centroeduc.model.Administrador;
import com.centroeduc.model.Secretaria;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ControllerSecre {

    ArrayList<Secretaria> listaSecre = new ArrayList();

    Secretaria secre = new Secretaria();
    SecreDao secretariaDao = new SecreDao();

    AdminDAO adminDao = new AdminDAO();
    private Date date;
    String mensaje = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Secretaria> getListaSecre() {
        return listaSecre;
    }

    public AdminDAO getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public void setListaSecre(ArrayList<Secretaria> listaSecre) {
        this.listaSecre = listaSecre;
    }

    public void cargarSecre() {

        listaSecre = secretariaDao.MostrarSecretaria();

    }

    public Secretaria getSecre() {
        return secre;
    }

    public void setSecretaria(Secretaria secre) {
        this.secre = secre;
    }

    /*INGRESO CLIENTE*/
    public void guardarSecre() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        SecreDao secretariaDao = new SecreDao();
        Administrador admin = new Administrador();
        admin.setCodigo("A0001");
        try {
            mensaje = secretariaDao.nuevaSecretaria(secre, admin, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error EN CONTROLADORSECRE:" + e);
        }
    }

    public void buscarSecre(Secretaria secre) {

        try {
            this.secre = secretariaDao.buscarCodigo(secre.getCodigo());
        } catch (Exception e) {
            System.out.println("Error en Busqueda, ControllerSecre" + e);
        }
    }

    public void editarSecre() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = secretariaDao.editarSecretaria(secre, date);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en Actualizar, ControladoCliente" + e);
        }
    }

    public void estado() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = secretariaDao.estado(secre);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Errr en Cambio de Estado,Controlador Estado");
        }

    }
}
