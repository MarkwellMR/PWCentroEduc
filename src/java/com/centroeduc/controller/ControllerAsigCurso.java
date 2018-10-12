package com.centroeduc.controller;

import com.centroeduc.dao.AsignGSCPDAO;
import com.centroeduc.dao.CursoDAO;
import com.centroeduc.dao.GradoDAO;
import com.centroeduc.dao.MaestroDAO;
import com.centroeduc.dao.SeccionDAO;
import com.centroeduc.model.AsignacionCurso;
import com.centroeduc.model.AsignacionGSCP;
import com.centroeduc.model.Curso;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Maestro;
import com.centroeduc.model.Seccion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class ControllerAsigCurso {

    // Instancia DAOs
    CursoDAO cursodao = new CursoDAO();
    GradoDAO gradodao = new GradoDAO();
    SeccionDAO secdao = new SeccionDAO();
    MaestroDAO maesdao = new MaestroDAO();
    AsignGSCPDAO dao = new AsignGSCPDAO();
    //Instancia Clases 
    Curso curso = new Curso();
    Grado grado = new Grado();
    Seccion seccion = new Seccion();
    Maestro maestro = new Maestro();
    AsignacionGSCP asign = new AsignacionGSCP();
    //Array List the objetos
    ArrayList<Grado> ListaGrado = new ArrayList();
    ArrayList<Curso> ListaCurso = new ArrayList();
    ArrayList<Seccion> ListaSeccion = new ArrayList();
    ArrayList<Maestro> ListaMaestros = new ArrayList();
    ArrayList<AsignacionGSCP> ListaAsignacion = new ArrayList();
    ArrayList<AsignacionCurso> listaAsignacionCurso = new ArrayList();
    private ArrayList<AsignacionCurso> filtro;

    String mensaje = null;

    public ArrayList<AsignacionCurso> getFiltro() {
        return filtro;
    }

    public void setFiltro(ArrayList<AsignacionCurso> filtro) {
        this.filtro = filtro;
    }

    public ArrayList<AsignacionCurso> getListaAsignacionCurso() {
        return listaAsignacionCurso;
    }

    public void setListaAsignacionCurso(ArrayList<AsignacionCurso> listaAsignacionCurso) {
        this.listaAsignacionCurso = listaAsignacionCurso;
    }

    public ArrayList<AsignacionGSCP> getListaAsignacion() {
        return ListaAsignacion;
    }

    public void setListaAsignacion(ArrayList<AsignacionGSCP> ListaAsignacion) {
        this.ListaAsignacion = ListaAsignacion;
    }

    List<String> nombreCurso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public ArrayList<Grado> getListaGrado() {
        return ListaGrado;
    }

    public void setListaGrado(ArrayList<Grado> ListaGrado) {
        this.ListaGrado = ListaGrado;
    }

    public ArrayList<Curso> getListaCurso() {
        return ListaCurso;
    }

    public void setListaCurso(ArrayList<Curso> ListaCurso) {
        this.ListaCurso = ListaCurso;
    }

    public ArrayList<Seccion> getListaSeccion() {
        return ListaSeccion;
    }

    public void setListaSeccion(ArrayList<Seccion> ListaSeccion) {
        this.ListaSeccion = ListaSeccion;
    }

    public ArrayList<Maestro> getListaMaestros() {
        return ListaMaestros;
    }

    public void setListaMaestros(ArrayList<Maestro> ListaMaestros) {
        this.ListaMaestros = ListaMaestros;
    }

    public AsignacionGSCP getAsign() {
        return asign;
    }

    public void setAsign(AsignacionGSCP asign) {
        this.asign = asign;
    }
    

    public void cargarListas() {
        this.ListaMaestros = this.maesdao.Mostrarprofesor();
        this.ListaCurso = this.cursodao.listCourse();
        this.ListaGrado = this.gradodao.mostrarGrado();
        this.ListaSeccion = this.secdao.MostrarSeccion();
        this.ListaAsignacion = this.dao.listAsign();
        this.listaAsignacionCurso = this.dao.listaAsignacion();

    }

    public void asignarCurso() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.newAsing(this.grado.getCod_grado(), this.seccion.getCodigo(), this.curso.getCod(), this.maestro.getCodigo());
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error en ControllerAsignCurso: " + e);
        }
    }

    public void updateAsignacion() {
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.updateAsing(this.grado.getCod_grado(), this.seccion.getCodigo(), this.curso.getCod(), this.maestro.getCodigo(), this.asign.getCodigo());
            context.addMessage(null, new FacesMessage(mensaje));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje));
            System.out.println("Error en ControllerAsigCurso: " + e);
        }
    }

    public void searchAsignacion(AsignacionCurso dato) {
        try {
            dao.seachAsignacion(dato);
        } catch (Exception e) {
            System.out.println("Error en ControllerAsignCurso: " + e);
        }
    }

}
