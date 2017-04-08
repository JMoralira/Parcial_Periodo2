/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Jugadores;
import com.sv.udb.recursos.Conexion;
import java.awt.Image;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jose Lira
 */
public class JugadoresCtrl {
        //GUARDAR
    public boolean guar(Jugadores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("insert into jugadores values(NULL,?,?,?,?,?,?)");
            cmd.setInt(1, obje.getCodiEqui());
            cmd.setString(2, obje.getNombJuga());
            cmd.setInt(3, obje.getEdadJuga());
            cmd.setDouble(4, obje.getAltuJuga());
            cmd.setDouble(5, obje.getPesoJuga());
            cmd.setBytes(6, obje.getImag());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) {
            System.err.println("Error al guardadr Jugadores" + ex.getMessage());
        }
        finally
        {
            try {
                 if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    
    //MOSTRAR
    public List<Jugadores> constTodo()
    {
        List<Jugadores> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from jugadores");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Jugadores(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getBytes(7)));               
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
     public Jugadores cons(int codi)
    {
        //List<Jugadores> resp = new ArrayList();
        Jugadores resp = null;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from jugadores where codi_juga = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Jugadores(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getBytes(7)));               
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
      //MODIFICAR
    public boolean modi(Jugadores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update jugadores set codi_equi = "+obje.getCodiEqui()+" , nomb_juga = '"+obje.getNombJuga()+"' , edad_juga = "+obje.getEdadJuga()+" , altu_juga = "+obje.getAltuJuga()+" , peso_juga = "+obje.getPesoJuga()+" , imagen = '"+obje.getImag()+"' where codi_juga = "+obje.getCodiJuga()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    //ELIMINAR
    public boolean elim(Jugadores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from jugadores where codi_juga = "+obje.getCodiJuga()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }

}
