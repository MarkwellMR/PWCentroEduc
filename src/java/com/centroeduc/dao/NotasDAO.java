package com.centroeduc.dao;

import com.centroeduc.model.Alumno;
import com.centroeduc.model.Curso;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Notas;
import com.centroeduc.model.Seccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotasDAO extends Conexion {

    Notas notas = new Notas();
    ArrayList<Notas> listaNotas = null;

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet resultado;

    public String agregarNotas(int codAlumGrado, int nota, int codUn) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into nota(cod_alumn_grad,nota,cod_unidad, cod_curs_grad_sec_prof) values(?,?,?,1)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codAlumGrado);
            run.setInt(2, nota);
            run.setInt(3, codUn);

            run.executeUpdate();
            System.out.println("Dato Almacenado");
            answer = "Dato Almacenado Correctamente";
            run.close();
        } catch (SQLException e) {
            answer = "Error en el DAO: " + e;
            System.out.println("Error " + e);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public String modificar(Notas nota) {
        answer = null;
        try {
            this.Conectar();
            sql = "update nota set nota=? where cod_nota= ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, nota.getNota());
            run.setInt(2, nota.getCodNota());

            run.executeUpdate();
            System.out.println("Nota Actualizada Correctamente ");
            answer = "Nota Actualizada Correctamente ";
            run.close();
        } catch (SQLException e) {
            answer = "Error en Actualizar notas " + e;
            System.out.println("Error en Actualizar notas " + e);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public ArrayList<Notas> MostrarNotas() {
        try {
            this.Conectar();
            sql = "select * from nota";
            run = this.getMiconexion().prepareStatement(sql);
            resultado = run.executeQuery();
            listaNotas = new ArrayList();
            while (resultado.next()) {
                Notas nota = new Notas();
                nota.setCodNota(resultado.getInt("cod_curs_grad_sec_prof"));
                nota.setNota(resultado.getInt("nota"));
                nota.setCodUnidad(resultado.getInt("cod_unidad"));
                nota.setCodAlumGrado(resultado.getInt("cod_alumn_grad"));
                listaNotas.add(nota);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        } finally {
            this.cerrarConex();
        }

        return listaNotas;
    }

    // Creando los dropdown menu para notas 
    public ArrayList<Grado> MostrarGrado(String maestro) {
        ArrayList<Grado> Mnotas = null;
        try {
            this.Conectar();
            sql = "select DISTINCT grado, cod_grado from notas_listas where cod_prof = ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, maestro);
            this.resultado = this.run.executeQuery();

            Mnotas = new ArrayList();
            while (resultado.next()) {
                Grado grado = new Grado();
                grado.setDescripcion(resultado.getString("grado"));
                grado.setCod_grado(resultado.getInt("cod_grado"));
                Mnotas.add(grado);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error en DAOnotas MostrarGrado: " + e);
        } finally {
            this.cerrarConex();
        }
        return Mnotas;
    }
    //Dropdow para secciones 
    ArrayList<Seccion> secciones = null;

    public ArrayList<Seccion> MostrarSec(String codMae, int codGrad) {
        try {
            this.Conectar();
            sql = "select DISTINCT cod_sec ,seccion from notas_listas where cod_prof = ? and cod_grado = ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codMae);
            run.setInt(2, codGrad);
            this.resultado = this.run.executeQuery();

            secciones = new ArrayList();
            while (resultado.next()) {
                Seccion sec = new Seccion();
                sec.setCodigo(resultado.getInt("cod_sec"));
                sec.setDescripcion(resultado.getString("seccion"));
                secciones.add(sec);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error en DAO MostrarSec: " + e);
        } finally {
            this.cerrarConex();
        }

        return secciones;
    }

    ArrayList<Curso> listaCurso = null;

    public ArrayList<Curso> MostrarCurso(String codMae, int codGrad, int codSec) {
        try {
            this.Conectar();
            sql = "select DISTINCT cod_curso ,nombre_curso from notas_listas where cod_prof =? and cod_grado = ? and cod_sec = ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codMae);
            run.setInt(2, codGrad);
            run.setInt(3, codSec);
            this.resultado = this.run.executeQuery();

            listaCurso = new ArrayList();
            while (resultado.next()) {
                Curso curso = new Curso();
                curso.setCod(resultado.getInt("cod_curso"));
                curso.setNombre(resultado.getString("nombre_curso"));
                listaCurso.add(curso);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error en DAO MostrarCurso: " + e);
        } finally {
            this.cerrarConex();
        }

        return listaCurso;
    }
  ArrayList<Alumno> listaAlumno = null;

    public ArrayList<Alumno> MostrarAlumno(String codMae, int codGrad, int codSec,int codCurs) {
        try {
            this.Conectar();
            sql = "select DISTINCT cod_alumno ,alumno from notas_listas where cod_prof =? and cod_grado = ? and cod_sec = ? and cod_curso = ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codMae);
            run.setInt(2, codGrad);
            run.setInt(3, codSec);
            run.setInt(4, codCurs);
            this.resultado = this.run.executeQuery();

            listaAlumno = new ArrayList();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setCodAlumno(resultado.getInt("cod_alumno"));
                alumno.setNombre(resultado.getString("alumno"));
                listaAlumno.add(alumno);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error en DAO MostarAlumno: " + e);
        } finally {
            this.cerrarConex();
        }

        return listaAlumno;
    }
    
    public int AgregarNotas(String codMae, int codGrad, int codSec,int codCurs,int codAlum){
            int rst=0;
        try {
            this.Conectar();
            sql = "select cod_alumn_grad from notas_listas where cod_prof=? and cod_grado=? and cod_sec=? and cod_curso=? and cod_alumno=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codMae);
            run.setInt(2, codGrad);
            run.setInt(3, codSec);
            run.setInt(4, codCurs);
            run.setInt(5, codAlum);
            
            this.resultado = this.run.executeQuery();
            this.resultado.next();
            rst = this.resultado.getInt("cod_alumn_grad");
            
            resultado.close();
         }catch(SQLException e){
             System.out.println("Error en DAO AgregarNotas " + e);   
         }finally{
            this.cerrarConex();
        }
         return rst;
    }
    
   
}
