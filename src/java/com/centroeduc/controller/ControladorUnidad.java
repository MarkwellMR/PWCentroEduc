package com.centroeduc.controller;

import com.centroeduc.dao.UnidadDAO;
import com.centroeduc.model.Unidad;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ControladorUnidad {

    ArrayList<Unidad> listaUnidad = new ArrayList();
    Unidad Uni = new Unidad();

    public ArrayList<Unidad> getListaUnidad() {
        return listaUnidad;
    }

    public void setListaUnidad(ArrayList<Unidad> listaUnidad) {
        this.listaUnidad = listaUnidad;
    }

    public Unidad getUni() {
        return Uni;
    }

    public void setUni(Unidad Uni) {
        this.Uni = Uni;
    }

    public void mostrarUnidad() {
        UnidadDAO unidao = new UnidadDAO();
        listaUnidad = unidao.mostrarLista();
    }

    public void guardadUnidad() {
        UnidadDAO unid = new UnidadDAO();
        try {
            unid.ingresoUnidad(Uni);
        } catch (Exception e) {
            System.out.println("error en controlador unidad");
        }
    }

    public void cambioEstado() {
        UnidadDAO unid = new UnidadDAO();
        try {
            unid.estadoUnidad(Uni);
        } catch (Exception e) {
            System.out.println("error en el controlador estado" + e);
        }
    }

}
