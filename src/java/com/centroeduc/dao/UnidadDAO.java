package com.centroeduc.dao;

import com.centroeduc.model.Unidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnidadDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String unidad;
    ResultSet resultado;

    Unidad uni = new Unidad();

    public String ingresoUnidad(Unidad uni) {
        unidad = null;
        try {
            this.Conectar();
            sql = "insert into unidad(nombre, descripcion, fechainicio, fechafin, estado) values (?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, uni.getNombre());
            ejecutar.setString(2, uni.getDescripcion());
            ejecutar.setString(3, uni.getFechaIni());
            ejecutar.setString(4, uni.getFechaFin());
            ejecutar.setInt(5, 1);

            ejecutar.executeUpdate();
            unidad = "registro guardado";

        } catch (SQLException ex) {
            unidad = "error al almacenar datos" + ex;

        } finally {
            this.cerrarConex();
        }
        return unidad;
    }

    public String estadoUnidad(Unidad uni) {
        unidad = null;
        try {
            this.Conectar();
            sql = "update unidad set estado=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, 2);

            ejecutar.executeUpdate();
            unidad = "se ha actualizado el estado";

        } catch (SQLException ex) {
            System.out.println("error en actualizar" + ex);
            unidad = "error no se puede cambiar el estado";
        }
        return unidad;
    }

    public ArrayList<Unidad> mostrarLista() {
        ArrayList<Unidad> unidad = new ArrayList();

        try {
            this.Conectar();
            sql = "select* from unidad where estado=1 ";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            resultado = this.ejecutar.executeQuery();
            while (resultado.next()) {
                Unidad unid = new Unidad();
                unid.setCodigo(resultado.getInt("cod_unidad"));
                unid.setNombre(resultado.getString("nombre"));
                unid.setDescripcion(resultado.getString("descripcion"));
                unid.setFechaIni(resultado.getString("fechainicio"));
                unid.setFechaFin(resultado.getString("fechafin"));
                unid.setEstado(resultado.getInt("estado"));

                unidad.add(unid);
            }

        } catch (SQLException ex) {
            System.out.println("error en mostrar unidad" + ex);

        } finally {
            this.cerrarConex();
        }
        return unidad;
    }

}
