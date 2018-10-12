package com.centroeduc.controller;

import com.centroeduc.dao.AdminDAO;
import com.centroeduc.model.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
@SessionScoped
public class ControllerAdmin {

    ArrayList<Administrador> listAdmin = new ArrayList();
    AdminDAO dao = new AdminDAO();
    Administrador admin = new Administrador();

    private Date date;
    String mensaje = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Administrador> getListAdmin() {
        return listAdmin;
    }

    public void setListAdmin(ArrayList<Administrador> listAdmin) {
        this.listAdmin = listAdmin;
    }

    public void loadAdmin() {
        listAdmin = dao.listAdmin();
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public void saveAdmin() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.registerAdmin(admin, date);
            context.addMessage(null, new FacesMessage(mensaje));
            clearFields();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error ControllerAdmin(save): " + e);
        }
    }

    public void searchAdmin(Administrador datos) {
        try {
            admin = dao.searchId(datos.getCodigo());
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(search): " + e);
        }
    }

    public void updateAdmin() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.updateAdmin(admin, date);
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error ControllerAdmin(update): " + e);
        }
    }

    public void changeState() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.changeState(admin);
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error ControllerAdmin(change): " + e);
        }
    }

    public void autenticar() {
        try {
            admin = dao.iniciarSesion(admin);
            if (admin != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", admin.getEmail());
                FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador/pAdminCRUD.xhtml");
            }
        } catch (IOException e) {
            System.out.println("Error en Controller(Auntenticar): " + e);
        }
    }
    
    public void clearFields(){
        this.admin = null;
    }

}
