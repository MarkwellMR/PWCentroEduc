package com.centroeduc.dao;

import com.centroeduc.model.Seccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeccionDAO extends Conexion {

    private String sql;
    PreparedStatement ejecutar;
    private String ingreso;
    ResultSet resultado;

    Seccion sec = new Seccion();

    public String insertarSeccion(Seccion sec) {

        ingreso = null;
        try {
            this.Conectar();
            sql = "insert into seccion(descripcion) values(?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, sec.getDescripcion());

            ejecutar.executeUpdate();
            ingreso = "Datos almacenados exitosamente";
            ejecutar.close();

        } catch (SQLException ex) {
            ingreso = "Error al almacenar el registro";
            System.out.println("Error al guardarSeccion: " + ex);

        } finally {
            this.cerrarConex();

        }
        return ingreso;

    }

    public ArrayList<Seccion> MostrarSeccion() {
        ArrayList<Seccion> clase = null;
        ResultSet resultado;
        try {
            this.Conectar();
            sql = "select * from seccion";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            clase = new ArrayList();
            while (resultado.next()) {
                Seccion sec = new Seccion();
                sec.setCodigo(resultado.getInt("cod_sec"));
                sec.setDescripcion(resultado.getString("descripcion"));

                clase.add(sec);

            }

        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            this.cerrarConex();
        }
        return clase;
    }

    public String editarSeccion(Seccion sec) {
        ingreso = null;
        try {
            this.Conectar();
            sql = "Update seccion set descripcion=? where cod_sec=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, sec.getDescripcion());
            ejecutar.setInt(2, sec.getCodigo());

            ejecutar.executeUpdate();
            ingreso = "Dato actualizados exitosamente";
            ejecutar.close();

        } catch (SQLException ex) {
            System.out.println("error en editarSecion: " + ex);
            ingreso = "No se pudo actualizar";

        } finally {
            this.cerrarConex();
        }
        return ingreso;
    }

    public Seccion buscarCodigo(int Codigo) {
        Seccion sec = new Seccion();
        try {
            this.Conectar();
            sql = "select * from seccion where cod_sec=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, Codigo);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                sec.setCodigo(resultado.getInt("cod_sec"));
                sec.setDescripcion(resultado.getString("descripcion"));
            }

            ejecutar.close();
            resultado.close();

        } catch (SQLException ex) {
            System.out.println("error en seccion DAO" + ex);

        } finally {
        }
        this.cerrarConex();
        return sec;
    }

    public String eliminarSeccion(int Codigo) {
        ingreso = null;
        try {
            this.Conectar();;
            sql = "delete from seccion where cod_sec=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, Codigo);
            ejecutar.executeUpdate();
            ingreso = "Registro eliminado exitosamente";

        } catch (SQLException ex) {
            System.out.println("error en eliminarSecion: " + ex);
            ingreso = "Error, No se puedo eliminar el registro";
        }
        return ingreso;
    }

}
