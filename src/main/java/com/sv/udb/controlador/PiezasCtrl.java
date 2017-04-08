/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Piezas;
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
public class PiezasCtrl {
     //GUARDAR
    public boolean guar(Piezas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into piezas values(NULL,?,?,?)");
            cmd.setString(1, obje.getNombPiez());
            cmd.setString(2, obje.getTipoPiez());
            cmd.setString(3, obje.getMarcPiez());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Piezas: " + ex.getMessage());
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
    
    //MOSTRAR
    public List<Piezas> consTodo()
    {
        List<Piezas> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = cn.prepareStatement("select * from piezas");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Piezas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));               
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
  
      public Piezas cons(int codi)
    {
        //List<Equipos> resp = new ArrayList();
        Piezas resp= null;
        Connection cn = new Conexion().getConn();
        try 
        {
            
            PreparedStatement cmd = cn.prepareStatement("select * from piezas where codi_piez = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Piezas(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4)));               
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
    public boolean modi(Piezas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update piezas set nomb_piez = '"+obje.getNombPiez()+"' , tipo_piez = '"+obje.getTipoPiez()+"' ,marc_piez = '"+obje.getMarcPiez()+"' where codi_piez = "+obje.getCodiPiez()+"");
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
    public boolean elim(Piezas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from piezas where codi_piez = "+obje.getCodiPiez()+"");
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
     public Piezas concmb (int codiPiez)
     {
         Piezas resp = new Piezas();
         Connection cn = new Conexion().getConn();
         try {
              PreparedStatement cmd = cn.prepareStatement("select * from piezas where codi_piez=?");
              cmd.setInt(1, codiPiez);
              ResultSet rs = cmd.executeQuery();
              
              while(rs.next())
              {
                  resp.setCodiPiez(rs.getInt(1));
                  resp.setNombPiez(rs.getString(2));
                  resp.setTipoPiez(rs.getString(3));                  
              }
         } catch (Exception e) {
         }
         return resp;
     }
    
}
