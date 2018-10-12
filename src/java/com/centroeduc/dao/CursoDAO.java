package com.centroeduc.dao;

import com.centroeduc.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO extends Conexion {

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet values;

    Curso curso = new Curso();

    //almacenar
    public String newCurso(Curso curso) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into curso(nombre, hinicio, hfin, jornada, cupo, estado) values(?,?,?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, curso.getNombre());
            run.setString(2, curso.getHinicio());
            run.setString(3, curso.getHfin());
            run.setString(4, curso.getJornada());
            run.setInt(5, curso.getCupo());
            run.setInt(6, 1);

            run.executeUpdate();

            answer = "Curso Almacenado exitosamente";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error CursoDAO(almacenar): " + e);
            answer = "No se pudo Almacenar el Curso";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    //Buscar
    public ArrayList<Curso> listCourse() {
        ArrayList<Curso> list = null;
        values = null;
        try {
            this.Conectar();
            sql = "select * from curso where estado=1";
            run = this.getMiconexion().prepareStatement(sql);
            values = run.executeQuery();
            list = new ArrayList();

            while (values.next()) {
                Curso course = new Curso();
                course.setCod(this.values.getInt("cod_curso"));
                course.setNombre(this.values.getString("nombre"));
                course.setHinicio(this.values.getString("hinicio"));
                course.setHfin(this.values.getString("hfin"));
                course.setJornada(this.values.getString("jornada"));
                course.setCupo(this.values.getInt("cupo"));
                list.add(course);
            }

            values.close();
            run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(Lista): " + e);
        } finally {
            this.cerrarConex();
        }
        return list;
    }

    public String updateCourse(Curso courso) {
        answer = null;
        try {
            this.Conectar();
            sql = "update curso set nombre=?, hinicio=?, hfin=?, jornada=?, cupo=? where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, courso.getNombre());
            run.setString(2, courso.getHinicio());
            run.setString(3, courso.getHfin());
            run.setString(4, courso.getJornada());
            run.setInt(5, courso.getCupo());
            run.setInt(6, courso.getCod());

            run.executeUpdate();
            answer = "Curso actualizado exitosamente";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(update): " + e);
            answer = "No se pudo actualizar";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    //eliminar
    public String deleteCourse(int codigo) {
        answer = null;
        try {
            this.Conectar();
            sql = "delete from curso where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo);
            run.executeUpdate();
            answer = "Eliminado con Exito";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error CursoDAO(Eliminar): " + e);
            answer = "No se pudo eliminar";
        }
        return answer;
    }
    
    //cambiar estado
    public String changeState(int codigo) {
        answer = null;
        try {
            this.Conectar();
            sql = "update curso set estado=? where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, 2);
            run.setInt(2, codigo);
            run.executeUpdate();
            answer = "Eliminado con Exito";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error CursoDAO(changeState): " + e);
            answer = "No se pudo eliminar";
        }
        return answer;
    }

    public Curso serachId(int codigo) {
        Curso course = new Curso();
        try {
            this.Conectar();
            sql = "select * from curso where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo);
            this.values = this.run.executeQuery();
            if (this.values.next()) {
                course.setCod(this.values.getInt("cod_curso"));
                course.setNombre(this.values.getString("nombre"));
                course.setHinicio(this.values.getString("hinicio"));
                course.setHfin(this.values.getString("hfin"));
                course.setJornada(this.values.getString("jornada"));
                course.setCupo(this.values.getInt("cupo"));
                course.setEstado(this.values.getInt("estado"));
            }else{
                System.out.println("No se encotraron coincidencias");
            }
            this.values.close();
            this.run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(serchId): " + e);
        }finally{
            this.cerrarConex();
        }
        return course;
    }
    
    public ArrayList<Curso> listCurso(String dato) {
        ArrayList<Curso> list = null;
        values = null;
        try {
            this.Conectar();
            sql = "select * from curso where nombre like ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, "%" + dato + "%");
            this.values = this.run.executeQuery();
            list = new ArrayList();

            while (values.next()) {
                Curso course = new Curso();
                course.setCod(this.values.getInt("cod_curso"));
                course.setNombre(this.values.getString("nombre"));
                course.setHinicio(this.values.getString("hinicio"));
                course.setHfin(this.values.getString("hfin"));
                course.setJornada(this.values.getString("jornada"));
                course.setCupo(this.values.getInt("cupo"));
                course.setEstado(this.values.getInt("estado"));
                list.add(course);
            }
            run.close();
            this.values.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(Lista Nombre): " + e);
        } finally {
            this.cerrarConex();
        }
        return list;
    }
}
