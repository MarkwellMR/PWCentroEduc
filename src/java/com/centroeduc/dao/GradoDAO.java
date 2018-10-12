/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroeduc.dao;

import com.centroeduc.model.Grado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GradoDAO extends Conexion{
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    ResultSet clonarTabla;
    
    Grado grado = new Grado();
    
    public String ingresarGrado(Grado grad){
        respuesta=null;
        try{
            this.Conectar();
            sql= "insert into grado (descripcion, estado) values(?,?)";
            ejecutar =this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, grad.getDescripcion());
            ejecutar.setInt(2, 1);
            ejecutar.executeUpdate();
            respuesta ="Registro almacenado correctamente";
            ejecutar.close();
        } catch(SQLException ex) {
            respuesta = "No se pudo almacenar";
            System.out.println("Error en almacenar los datos: " + ex);
        }finally{
            this.cerrarConex();
         
        }
        return respuesta;
    }
    public String eliminarGrado(Grado estado){
        respuesta = null;
        try{
            this.Conectar();
            sql= "update grado set estado=? where cod_grado=?";
            ejecutar=this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, 2);
            ejecutar.setInt(2, estado.getCod_grado());
            
            ejecutar.executeUpdate();
            respuesta ="Se elimino el Registro con Exito";
            ejecutar.close();
        }catch(SQLException ex){
            System.out.println("Error en EliminarGrado: "+ ex);
            respuesta = "Error, no se puedo Eliminar";
        }finally{
            this.cerrarConex();
        }
        return respuesta;
    }
    public String modificarGrado(Grado dato){
        respuesta = null;
        try{
            this.Conectar();
            sql="update grado set descripcion=? where cod_grado=?";
            ejecutar= this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, dato.getDescripcion());
            ejecutar.setInt(2, dato.getCod_grado());
            
            ejecutar.executeUpdate();
            respuesta ="Datos acualizados correctamente";
            ejecutar.close();
        }catch(SQLException ex){
            System.out.println("Error en actualizar "+ ex);
            respuesta="Error no se pudo Actualizar";
        }finally{
            this.cerrarConex();
        }
        return respuesta;
    }
    public Grado busquedaDatos(Integer cod_grado){
        Grado grados = new Grado();
        try{
            this.Conectar();
            sql="select* from grado where cod_grado=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, cod_grado);
            clonarTabla=ejecutar.executeQuery();
            if (clonarTabla.next()) {
                grados.setCod_grado(clonarTabla.getInt("cod_grado"));
                grados.setDescripcion(clonarTabla.getString("descripcion"));
                
                ejecutar.close();
                clonarTabla.close();
                
            }
        }catch(SQLException ex){
            System.out.println("error en el gradodao buscar datos" + ex);
        }finally{
            this.cerrarConex();
        }
        return grados;
    }
    public ArrayList<Grado> mostrarGrado(){
        ArrayList<Grado> grado = new ArrayList();
        try{
            this.Conectar();
            sql="select* from grado where estado =1";
            ejecutar= this.getMiconexion().prepareStatement(sql);
            clonarTabla=this.ejecutar.executeQuery();
            while(clonarTabla.next()){
                Grado grad = new Grado();
                grad.setCod_grado(clonarTabla.getInt("cod_grado"));
                grad.setDescripcion(clonarTabla.getString("descripcion"));
                grad.setEstado(clonarTabla.getInt("estado"));
                grado.add(grad);
            }
        }catch(SQLException ex){
            System.out.println("error en mostrar grado en dao" + ex);
        }finally{
            this.cerrarConex();
        }
        return grado;
    }
}
