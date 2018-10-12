package com.centroeduc.dao;

import com.centroeduc.model.AsignacionCurso;
import com.centroeduc.model.AsignacionGSCP;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsignGSCPDAO extends Conexion {

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet values;

    AsignacionGSCP asign = new AsignacionGSCP();

    public String newAsing(int cdGrado, int cdSeccion, int cdCurso, String cdMeastro) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into cursgradsecprof(cod_grad, cod_sec, cod_curso, cod_prof) values(?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, cdGrado);
            run.setInt(2, cdSeccion);
            run.setInt(3, cdCurso);
            run.setString(4, cdMeastro);
            run.executeUpdate();

            answer = "Asignacion Realizada con Exito";
            this.run.close();

        } catch (SQLException e) {
            System.out.println("Error al asignar: " + e);
            answer = "No se pudo realizar la Asignacion";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public ArrayList<AsignacionGSCP> listAsign() {
        ArrayList<AsignacionGSCP> list = null;
        values = null;
        try {
            this.Conectar();
            sql = "select * from cursgradsecprof";
            run = this.getMiconexion().prepareStatement(sql);
            values = run.executeQuery();
            list = new ArrayList();
            while (values.next()) {
                AsignacionGSCP asigna = new AsignacionGSCP();
                asigna.setCodigo(this.values.getInt(1));
                asigna.setCdGrado(this.values.getInt("cod_grad"));
                asigna.setCdSecc(this.values.getInt("cod_sec"));
                asigna.setCdCurso(this.values.getInt("cod_curso"));
                asigna.setCdMaestro(this.values.getString("cod_prof"));
                list.add(asigna);
            }
            values.close();
            run.close();
        } catch (SQLException e) {
            System.out.println("Error en AsignGSCPDAO(lista): " + e);
        } finally {
            this.cerrarConex();
        }
        return list;
    }
    
    public ArrayList<AsignacionCurso> listaAsignacion(){
        ArrayList<AsignacionCurso> lista = null;
        values = null;
        try {
            this.Conectar();
            sql = "select * from vw_asignacion_curso order by cod_asignacion";
            run = this.getMiconexion().prepareStatement(sql);
            values = this.run.executeQuery();
            lista = new ArrayList();
            while(values.next()){
                AsignacionCurso datos = new AsignacionCurso();
                datos.setCodigo(this.values.getInt("cod_asignacion"));
                datos.setGrado(this.values.getString("grado"));
                datos.setSeccion(this.values.getString("seccion"));
                datos.setCurso(this.values.getString("curso"));
                datos.setProfesor(this.values.getString("profesor"));
                lista.add(datos);
            }
            values.close();
            run.close();
        } catch (SQLException e) {
            System.out.println("Error en Lista Asignacion: " + e);
        }finally{
            this.cerrarConex();
        }
        return lista;
    }

    public String updateAsing(int cdGrado, int cdSeccion, int cdCurso,String cdMeastro, int codasig) {
        answer = null;
        try {
            this.Conectar();
            sql = "update cursgradsecprof set cod_grad, cod_sec=?, cod_curso=?, cod_prof=? where cod_curs_grad_sec_prof=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, cdGrado);
            run.setInt(2, cdSeccion);
            run.setInt(3, cdCurso);
            run.setString(4, cdMeastro);
            run.setInt(5, codasig);
            run.executeUpdate();

            answer = "Asignacion actualizada con Exito";
            this.run.close();

        } catch (SQLException e) {
            System.out.println("Error al Actualizar: " + e);
            answer = "No se pudo actualizar la Asignacion";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }
    
    public AsignacionGSCP seachAsignacion(AsignacionCurso codigo){
        AsignacionGSCP asign = new AsignacionGSCP();
        try {
            this.Conectar();
            sql = "select * from cursgradsecprof where cod_curs_grad_sec_prof=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo.getCodigo());
            values = run.executeQuery();
            if (values.next()) {
                asign.setCodigo(values.getInt("cod_curs_grad_sec_prof"));
                asign.setCdGrado(values.getInt("cod_grad"));
                asign.setCdSecc(values.getInt("cod_sec"));
                asign.setCdCurso(values.getInt("cod_curso"));
                asign.setCdMaestro(values.getString("cod_prof"));
            }
            run.close();
            values.close();
        } catch (SQLException e) {
            System.out.println("Error en searchAsignacion: " + e);
        }finally{
            this.cerrarConex();
        }
        return asign;
    }
}
