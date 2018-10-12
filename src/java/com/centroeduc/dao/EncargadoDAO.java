package com.centroeduc.dao;

import com.centroeduc.model.Encargado;
import com.centroeduc.model.Secretaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EncargadoDAO extends Conexion {

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet resultado;
    //agregar un nuevo Administrador 

    Encargado encargado = new Encargado();
    Secretaria secre = new Secretaria();

    public String nuevoEncargado(Encargado encargado, Secretaria secre, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        answer = null;
        try {
            this.Conectar();
            sql = "insert into encargado(nombre,apellido,direccion,email, tel_casa,tel_movil,fechanac,cui,estado,cod_secre) values(?,?,?,?,?,?,?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, encargado.getNombre());
            run.setString(2, encargado.getApellido());
            run.setString(3, encargado.getDireccion());
            run.setString(4, encargado.getEmail());
            run.setInt(5, encargado.getTelCasa());
            run.setInt(6, encargado.getTelMovil());
            run.setString(7, fecha);
            run.setLong(8, encargado.getCui());
            run.setInt(9, 1);
            run.setString(10,secre.getCodigo() );
            
            run.executeUpdate();
            answer = "Registro almacenado";
        } catch (SQLException e) {
            answer = "Error, no se pudo almacenar el Registro";
            System.out.println("Error al guardarEnc: " + e);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public ArrayList<Encargado> MostarEncargado() {
        ArrayList<Encargado> lista = null;
        try {
            this.Conectar();
            sql = "select * from encargado where estado=1";
            run = this.getMiconexion().prepareStatement(sql);
            resultado = run.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Encargado enc = new Encargado();
                enc.setCodEnc(resultado.getInt("cod_enc"));
                enc.setNombre(resultado.getString("nombre"));
                enc.setApellido(resultado.getString("apellido"));
                enc.setDireccion(resultado.getString("direccion"));
                enc.setEmail(resultado.getString("email"));
                enc.setTelCasa(resultado.getInt("tel_casa"));
                enc.setTelMovil(resultado.getInt("tel_movil"));
                enc.setFechanac(resultado.getString("fechanac"));
                enc.setCui(resultado.getLong("cui"));
                enc.setEstado(resultado.getInt("estado"));
                lista.add(enc);

            }
            
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            this.cerrarConex();
        }
        return lista;
    }

    public String delEnc(String codigo) {
        answer = null;
        try {
            this.Conectar();
            sql = "delete from encargado where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codigo);
            run.executeUpdate();
            answer = "registro eliminado";

        } catch (SQLException ex) {
            System.out.println("Error en conexion:" + ex);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public String UpEnc(Encargado encargado, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        try {
            this.Conectar();
            sql = "update encargado set nombre=?, apellido=?, direccion=?, email=?, tel_casa=?, tel_movil=?, fechanac=?, cui=? where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);

            run.setString(1, encargado.getNombre());
            run.setString(2, encargado.getApellido());
            run.setString(3, encargado.getDireccion());
            run.setString(4, encargado.getEmail());
            run.setInt(5, encargado.getTelCasa());
            run.setInt(6, encargado.getTelMovil());
            run.setString(7, fecha);
            run.setLong(8, encargado.getCui());
            run.setInt(9, encargado.getCodEnc());
            run.executeUpdate();
            answer = "Registro Actualizado";

        } catch (SQLException ex) {
            System.out.println("Error al actualizar registro: " + ex);
            answer = "No se pudo actualizar el Registro";
        } finally {
            this.cerrarConex();
        }

        return answer;
    }

    public Encargado searchId(int codigo) {
        Encargado enc = new Encargado();
        try {
            this.Conectar();
            sql = "select * from encargado where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo);
            this.resultado = this.run.executeQuery();
            if (this.resultado.next()) {
                enc.setCodEnc(this.resultado.getInt("cod_enc"));
                enc.setNombre(this.resultado.getString("nombre"));
                enc.setApellido(this.resultado.getString("apellido"));
                enc.setDireccion(this.resultado.getString("direccion"));
                enc.setEmail(this.resultado.getString("email"));
                enc.setTelCasa(this.resultado.getInt("tel_casa"));
                enc.setTelMovil(this.resultado.getInt("tel_movil"));
                enc.setFechanac(this.resultado.getString("fechanac"));
                enc.setCui(this.resultado.getLong("cui"));
                enc.setEstado(this.resultado.getInt("estado"));
            } else {
                System.out.println("Registro no Encontrado");
            }
            resultado.close();
            this.run.close();
        } catch (SQLException e) {
            System.out.println("error en Search " + e);
        } finally {
            this.cerrarConex();
        }
        return enc;
    }
    public String cambioEstado(int codigo){
        try {
            this.Conectar();
            sql = "update encargado set estado=2 where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
             run.setInt(1, codigo);
             run.executeUpdate();
             answer = "Registro eliminado exitosamente";
             
             run.close();    
        } catch (SQLException e) {
            answer = "No se pudo eliminar";
            System.out.println("Error en cambioEstdao: " + e);
        }finally{
            this.cerrarConex();
           
        }
        return answer;
    }
    
    public ArrayList<Encargado> BusquedaXnombre(String Nombre) {
        ArrayList<Encargado> lista = null;
        try {
            this.Conectar();
            sql = "select * from encargado where nombre LIKE ? and estado=1";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, "%"+ Nombre+"%");
            resultado = run.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Encargado enc = new Encargado();
                enc.setCodEnc(resultado.getInt("cod_enc"));
                enc.setNombre(resultado.getString("nombre"));
                enc.setApellido(resultado.getString("apellido"));
                enc.setDireccion(resultado.getString("direccion"));
                enc.setEmail(resultado.getString("email"));
                enc.setTelCasa(resultado.getInt("tel_casa"));
                enc.setTelMovil(resultado.getInt("tel_movil"));
                enc.setFechanac(resultado.getString("fechanac"));
                enc.setCui(resultado.getLong("cui"));
                enc.setEstado(resultado.getInt("estado"));
                lista.add(enc);

            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            this.cerrarConex();
        }
        return lista;
    }


}
