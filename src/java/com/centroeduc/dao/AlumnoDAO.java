/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroeduc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.AsignacionGSCP;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Seccion;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class AlumnoDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    ResultSet clonarTabla;

    Alumno alum = new Alumno();

    public String ingresarAlum(Alumno alum, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        respuesta = null;
        try {
            this.Conectar();
            sql = "insert into alumno(nombre, apellido, direccion, email, tel_emergencia, cod_enc, cod_secre, fechanac, padecimiento, estado) values(?,?,?,?,?,?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, alum.getNombre());
            ejecutar.setString(2, alum.getApellido());
            ejecutar.setString(3, alum.getDireccion());
            ejecutar.setString(4, alum.getEmail());
            ejecutar.setInt(5, alum.getTelEmergencia());
            ejecutar.setInt(6, alum.getCodEncargado());
            ejecutar.setString(7, alum.getCodSecretaria());
            ejecutar.setString(8, fecha);
            ejecutar.setString(9, alum.getPadecimiento());
            ejecutar.setInt(10, 1);

            ejecutar.executeUpdate();
            respuesta = "Registro almacenado con Exito";

        } catch (SQLException ex) {
            respuesta = "Error al almacenar los datos";
            System.out.println("Error ingresarAlum: " + ex);

        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    public String estadoAlumno(Alumno estado) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "update alumno set estado=? where cod_alumno=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, 2);
            ejecutar.setInt(2, estado.getCodAlumno());

            ejecutar.executeUpdate();
            respuesta = "Se ha eliminado exitosamente";

        } catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Conexion: " + ex);
            respuesta = "Error, no se pudo eliminar el registro";
        }
        return respuesta;
    }

    public String modificarAlumno(Alumno dato, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        respuesta = null;
        try {
            this.Conectar();
            sql = "update alumno set nombre=?, apellido=?, email=?, direccion=?, tel_emergencia=?, fechanac=?, padecimiento=?, estado=? where cod_alumno=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, dato.getNombre());
            ejecutar.setString(2, dato.getApellido());
            ejecutar.setString(3, dato.getEmail());
            ejecutar.setString(4, dato.getDireccion());
            ejecutar.setInt(5, dato.getTelEmergencia());
            ejecutar.setString(6, fecha);
            ejecutar.setString(7, dato.getPadecimiento());
            ejecutar.setInt(8, dato.getEstado());
            ejecutar.setInt(9, dato.getCodAlumno());

            ejecutar.executeUpdate();
            respuesta = "Datos actualizados correctamente";
        } catch (SQLException ex) {
            System.out.println("error en conexion" + ex);
            respuesta = "No se pudo actualizar";
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    public Alumno busquedaDatos(int codigo) {
        // busqueda por codigo, devuelve 1 o ninguno
        Alumno alum = new Alumno();
        try {
            this.Conectar();
            sql = "select * from alumno where cod_alumno=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, codigo);
            clonarTabla = ejecutar.executeQuery();
            if (clonarTabla.next()) {
                alum.setCodAlumno(clonarTabla.getInt("cod_alumno"));
                alum.setNombre(clonarTabla.getString("nombre"));
                alum.setApellido(clonarTabla.getString("apellido"));
                alum.setEmail(clonarTabla.getString("email"));
                alum.setTelEmergencia(clonarTabla.getInt("tel_emergencia"));
                alum.setCodEncargado(clonarTabla.getInt("cod_enc"));
                alum.setCodSecretaria(clonarTabla.getString("cod_secre"));
                alum.setDireccion(clonarTabla.getString("direccion"));
                alum.setFechanac(clonarTabla.getString("fechanac"));
                alum.setPadecimiento(clonarTabla.getString("padecimiento"));
                alum.setEstado(clonarTabla.getInt("estado"));

            }
            // cerrar el preparedStatement
            //cerrar el Resultset
            ejecutar.close();
            clonarTabla.close();

        } catch (SQLException e) {
            System.out.println("error en el alumnodao buscar datos" + e);
        } finally {
            this.cerrarConex();
        }
        return alum;
    }

    public ArrayList<Alumno> mostrarAlumno() {
        ArrayList<Alumno> alumno = new ArrayList();

        try {
            this.Conectar();
            sql = "select* from alumno where estado=1";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            clonarTabla = this.ejecutar.executeQuery();
            while (clonarTabla.next()) {// se posiciona en el primero
                Alumno alum = new Alumno();
                alum.setCodAlumno(clonarTabla.getInt("cod_alumno"));
                alum.setNombre(clonarTabla.getString("nombre"));
                alum.setApellido(clonarTabla.getString("apellido"));
                alum.setEmail(clonarTabla.getString("email"));
                alum.setTelEmergencia(clonarTabla.getInt("tel_emergencia"));
                alum.setCodEncargado(clonarTabla.getInt("cod_enc"));
                alum.setCodSecretaria(clonarTabla.getString("cod_secre"));
                alum.setDireccion(clonarTabla.getString("direccion"));
                alum.setFechanac(clonarTabla.getString("fechanac"));
                alum.setPadecimiento(clonarTabla.getString("padecimiento"));
                alum.setEstado(clonarTabla.getInt("estado"));
                alumno.add(alum);

            }

        } catch (SQLException ex) {
            System.out.println("error en MostrarAlumno en dao: " + ex);
        } finally {
            this.cerrarConex();
        }
        return alumno;
    }

    public Alumno searchAlumno(Alumno dato) {
        Alumno alumno = new Alumno();
        try {
            this.Conectar();
            sql = "select * from alumno where nombre=? and apellido=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, dato.getNombre());
            ejecutar.setString(2, dato.getApellido());
            System.out.println("Nombre: " + dato.getNombre() + "," + "Apellido: " + dato.getApellido());
            clonarTabla = ejecutar.executeQuery();
            if (clonarTabla.next()) {
                alum.setCodAlumno(clonarTabla.getInt("cod_alumno"));
                alum.setNombre(clonarTabla.getString("nombre"));
                alum.setApellido(clonarTabla.getString("apellido"));
                alum.setDireccion(clonarTabla.getString("direccion"));
                alum.setEmail(clonarTabla.getString("email"));
                alum.setTelEmergencia(clonarTabla.getInt("tel_emergencia"));
                alum.setCodEncargado(clonarTabla.getInt("cod_enc"));
                alum.setCodSecretaria(clonarTabla.getString("cod_secre"));
                alum.setFechanac(clonarTabla.getString("fechanac"));
                alum.setPadecimiento(clonarTabla.getString("padecimiento"));
                alum.setEstado(clonarTabla.getInt("estado"));
                System.out.println("Codigo: " + alum.getCodAlumno() + ", " + "Nombre: " + alum.getApellido());
            }
            ejecutar.close();
            clonarTabla.close();
        } catch (SQLException e) {
            System.out.println("Error busqueda: " + e);
        } finally {
            this.cerrarConex();
        }
        return alum;
    }

    public AsignacionGSCP searchAsignacion(Grado grado , Seccion sec) {
        AsignacionGSCP asign = new AsignacionGSCP();
        try {
            this.Conectar();
            sql = "select * from Cursgradsecprof where cod_grad=? and cod_sec=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, grado.getCod_grado());
            ejecutar.setInt(2, sec.getCodigo());
            System.out.println("Grado: " + grado.getCod_grado() + "," + "Sección: " + sec.getCodigo());
            clonarTabla = ejecutar.executeQuery();
            if (clonarTabla.next()) {
                asign.setCodigo(clonarTabla.getInt("cod_curs_grad_sec_prof"));
                asign.setCdGrado(clonarTabla.getInt("cod_grad"));
                asign.setCdSecc(clonarTabla.getInt("cod_sec"));
                asign.setCdCurso(clonarTabla.getInt("cod_curso"));
                asign.setCdMaestro(clonarTabla.getString("cod_prof"));
                System.out.println("Codigo: " + asign.getCodigo() + ", " + "Grado: " + asign.getCdGrado()+ "," + "Sección: " + asign.getCdSecc());
                
                //System.out.println("Codigo: " + asign.getCodigo() + ", " + "Grado: " + dato.getCdGrado() + "," + "Sección: " + dato.getCdSecc());
            }
            ejecutar.close();
            clonarTabla.close();
        } catch (SQLException e) {
            System.out.println("Error busqueda: " + e);
        } finally {
            this.cerrarConex();
        }
        return asign;
    }
    
    public String nuevaAsign(Alumno dato, AsignacionGSCP asign){
        respuesta = null;
        try {
            this.Conectar();
            sql = "insert into alumnogrado(cod_alumn, cod_curs_grad_sec_prof, ciclo) values(?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, dato.getCodAlumno());
            ejecutar.setInt(2, asign.getCodigo());
            ejecutar.setString(3, "2018");
            ejecutar.executeUpdate();
            respuesta = "Asignacion Realizada";
            System.out.println("Codigo alumno: " + dato.getCodAlumno() + "," + "Codigo Asignacion: " + asign.getCodigo());
            this.ejecutar.close();
        } catch (SQLException e) {
            respuesta = "No se pudo asignar";
            System.out.println("Error al Asignar(nuevaAsign): " + e);
        }finally{
            this.cerrarConex();
        }
        return respuesta;
    }
    
}
