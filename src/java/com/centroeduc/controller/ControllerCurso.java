
package com.centroeduc.controller;

import com.centroeduc.dao.CursoDAO;
import com.centroeduc.model.Curso;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ControllerCurso {
    ArrayList<Curso> listCurso = new ArrayList();
    CursoDAO dao = new CursoDAO();
    Curso course = new Curso();
    
    String mensaje = null;

    public ArrayList<Curso> getListCurso() {
        return listCurso;
    }

    public void setListCurso(ArrayList<Curso> listCurso) {
        this.listCurso = listCurso;
    }
    
    public void loadCurso(){
        listCurso = dao.listCurso(course.getNombre());
    }
    public void cargarLista(){
        listCurso = dao.listCourse();
    }

    public Curso getCourse() {
        return course;
    }

    public void setCourse(Curso course) {
        this.course = course;
    }
    
    public void saveCurso(){
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.newCurso(course);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en ControllerCurso(save): " + e);
        }
    }
    
    public void updateCurso(){
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.updateCourse(course);
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en ControllerCurso(update): " + e);
        }
    }
    
    public void deleteCurso(){
        FacesContext context = FacesContext.getCurrentInstance();
        mensaje = null;
        try {
            mensaje = dao.changeState(course.getCod());
            context.addMessage(null, new FacesMessage(mensaje) );
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(mensaje) );
            System.out.println("Error en ControllerCurso(delete): " + e);
        }
    }
    
    public void searchCurso(Curso curso){
        try {
            course = dao.serachId(curso.getCod());
        } catch (Exception e) {
            System.out.println("Error en ControllerCurso(search): " + e);
        }
    }
    
    public void searchName(){
        try {
            listCurso = dao.listCurso(course.getNombre());
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
}
