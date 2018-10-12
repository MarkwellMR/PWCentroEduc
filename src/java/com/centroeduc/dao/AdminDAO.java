package com.centroeduc.dao;

//Heredar conexion
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.centroeduc.model.Administrador;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    ResultSet valores;

    Administrador admin = new Administrador();

    //almacena los datos
    public String registerAdmin(Administrador admin, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        respuesta = null;
        try {
            this.Conectar();
            sql = "insert into administrador values(?,?,?,?,?,?,?,?,?,MD5(?),?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, admin.getCodigo());
            ejecutar.setString(2, admin.getNombre());
            ejecutar.setString(3, admin.getApellido());
            ejecutar.setString(4, admin.getDireccion());
            ejecutar.setString(5, admin.getEmail());
            ejecutar.setInt(6, admin.getTelCasa());
            ejecutar.setInt(7, admin.getTelMovil());
            ejecutar.setString(8, fecha);
            ejecutar.setLong(9, admin.getCui());
            ejecutar.setString(10, admin.getPass());
            ejecutar.setInt(11, 1);

            ejecutar.executeUpdate();
            respuesta = "Registro almacenado con Exito";
        } catch (SQLException e) {
            System.out.println("Error en AdminDAO(Ingresar): " + e);
            respuesta = "No se pudo almacenar el registro";
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    //busca los datos
    public ArrayList<Administrador> listAdmin() {
        ArrayList<Administrador> lista = null;
        ResultSet resultado;
        try {
            this.Conectar();
            sql = "select * from administrador where estado=1";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {

                Administrador admin = new Administrador();
                admin.setCodigo(resultado.getString("cod_admin"));
                admin.setNombre(resultado.getString("nombre"));
                admin.setApellido(resultado.getString("apellido"));
                admin.setDireccion(resultado.getString("direccion"));
                admin.setEmail(resultado.getString("email"));
                admin.setTelCasa(resultado.getInt("tel_casa"));
                admin.setTelMovil(resultado.getInt("tel_movil"));
                admin.setFechanac(resultado.getString("fechanac"));
                admin.setCui(resultado.getLong("cui"));
                admin.setPass(resultado.getString("password"));
                admin.setEstado(resultado.getInt("estado"));
                lista.add(admin);

            }
        } catch (SQLException e) {
            System.out.println("Error en AdminDAO(ListadAdmin): " + e);
        } finally {
            this.cerrarConex();
        }
        return lista;

    }

    public String updateAdmin(Administrador admin, Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(date);
        respuesta = null;
        try {
            this.Conectar();
            sql = "update administrador set nombre=?, apellido=?, direccion=?, email=?, tel_casa=?, tel_movil=?, fechanac=?, cui=?, password=MD5(?), estado=? where cod_admin=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);

            ejecutar.setString(1, admin.getNombre());
            ejecutar.setString(2, admin.getApellido());
            ejecutar.setString(3, admin.getDireccion());
            ejecutar.setString(4, admin.getEmail());
            ejecutar.setInt(5, admin.getTelCasa());
            ejecutar.setInt(6, admin.getTelMovil());
            ejecutar.setString(7, fecha);
            ejecutar.setLong(8, admin.getCui());
            ejecutar.setString(9, admin.getPass());
            ejecutar.setInt(10, admin.getEstado());
            ejecutar.setString(11, admin.getCodigo());

            ejecutar.executeUpdate();
            respuesta = "Datos modificados con exito";
            this.ejecutar.close();

        } catch (SQLException ex) {
            System.out.println("Error en AdminDAO(modificar): " + ex);
            respuesta = "No se pudo modificar el Registro";
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    public Administrador searchId(String codigo) {
        Administrador admin = new Administrador();
        try {
            this.Conectar();
            sql = "Select * from administrador where cod_admin=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, codigo);
            this.valores = this.ejecutar.executeQuery();
            if (this.valores.next()) {
                admin.setCodigo(this.valores.getString("cod_admin"));
                admin.setNombre(this.valores.getString("nombre"));
                admin.setApellido(this.valores.getString("apellido"));
                admin.setDireccion(this.valores.getString("direccion"));
                admin.setEmail(this.valores.getString("email"));
                admin.setTelCasa(this.valores.getInt("tel_casa"));
                admin.setTelMovil(this.valores.getInt("tel_movil"));
                admin.setFechanac(this.valores.getString("fechanac"));
                admin.setCui(this.valores.getLong("cui"));
                admin.setPass(this.valores.getString("password"));
                admin.setEstado(this.valores.getInt("estado"));
            } else {
                System.out.println("No se encontraron registros");
            }
            valores.close();
            this.ejecutar.close();

        } catch (SQLException e) {
            System.out.println("Error en AdminDAO(searchId): " + e);
        } finally {
            this.cerrarConex();
        }
        return admin;
    }

    public Administrador searchName(String datos) {
        Administrador admin = new Administrador();
        try {
            this.Conectar();
            sql = "Select * from administrador where nombre=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, datos);
            this.valores = this.ejecutar.executeQuery();
            if (this.valores.next()) {
                admin.setCodigo(this.valores.getString("cod_admin"));
                admin.setNombre(this.valores.getString("nombre"));
                admin.setApellido(this.valores.getString("apellido"));
                admin.setDireccion(this.valores.getString("direccion"));
                admin.setEmail(this.valores.getString("email"));
                admin.setTelCasa(this.valores.getInt("tel_casa"));
                admin.setTelMovil(this.valores.getInt("tel_movil"));
                admin.setFechanac(this.valores.getString("fechanac"));
                admin.setCui(this.valores.getLong("cui"));
                admin.setPass(this.valores.getString("password"));
                admin.setEstado(this.valores.getInt("estado"));
            } else {
                System.out.println("No se encontraron registros");
            }
            valores.close();
            this.ejecutar.close();

        } catch (SQLException e) {
            System.out.println("Error en AdminDAO(searchName): " + e);
        } finally {
            this.cerrarConex();
        }
        return admin;
    }

    public String changeState(Administrador admin) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "update administrador set estado=? where cod_admin=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);

            ejecutar.setInt(1, 2);
            ejecutar.setString(2, admin.getCodigo());

            ejecutar.executeUpdate();
            respuesta = "Administrador eliminado con Exito";
            ejecutar.close();
        } catch (SQLException ex) {
            System.out.println("Error en AdminDAO(changeState): " + ex);
            respuesta = "No se pudo eliminar";
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    public Administrador iniciarSesion(Administrador datos) {
        Administrador userLocated = new Administrador();
        try {
            this.Conectar();
            sql = "select * from administrador where email=? and password=MD5(?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, datos.getEmail());
            ejecutar.setString(2, datos.getPass());

            valores = ejecutar.executeQuery();

            if (valores.next()) {
                userLocated.setCodigo(this.valores.getString("cod_admin"));
                userLocated.setNombre(this.valores.getString("nombre"));
                userLocated.setApellido(this.valores.getString("apellido"));
                userLocated.setDireccion(this.valores.getString("direccion"));
                userLocated.setEmail(this.valores.getString("email"));
                userLocated.setTelCasa(this.valores.getInt("tel_casa"));
                userLocated.setTelMovil(this.valores.getInt("tel_movil"));
                userLocated.setFechanac(this.valores.getString("fechanac"));
                userLocated.setCui(this.valores.getLong("cui"));
                userLocated.setPass(this.valores.getString("password"));
                userLocated.setEstado(this.valores.getInt("estado"));
            }else{
                System.out.println("No se encontraron registros");
            }

        } catch (SQLException e) {
            System.out.println("Error en iniciarSesion: " + e);
        } finally {
            this.cerrarConex();
        }

        return userLocated;
    }

}
