/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;
import com.sv.udb.modelo.Proveedores;
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
public class ProveedoresCtrl {
     //GUARDAR
    public boolean guar(Proveedores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into proveedores values(NULL,?,?,?)");
            cmd.setString(1, obje.getNombProv());
            cmd.setString(2, obje.getDireProv());
            cmd.setString(3, obje.getTeleProv());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Proveedores: " + ex.getMessage());
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
    public List<Proveedores> consTodo()
    {
        List<Proveedores> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Proveedores(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));               
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
  
      public Proveedores cons(int codi)
    {
        //List<Equipos> resp = new ArrayList();
        Proveedores resp= null;
        Connection cn = new Conexion().getConn();
        try 
        {
            
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores where codi_prov = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Proveedores(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4)));               
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
    public boolean modi(Proveedores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update proveedores set nomb_prov = '"+obje.getNombProv()+"' , dire_prov = '"+obje.getDireProv()+"' ,tele_prov = '"+obje.getTeleProv()+"' where codi_prov = "+obje.getCodiProv()+"");
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
    public boolean elim(Proveedores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from proveedores where codi_prov = "+obje.getCodiProv()+"");
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
     public Proveedores concmb (int codiPiez)
     {
         Proveedores resp = new Proveedores();
         Connection cn = new Conexion().getConn();
         try {
              PreparedStatement cmd = cn.prepareStatement("select * from proveedores where codi_prov=?");
              cmd.setInt(1, codiPiez);
              ResultSet rs = cmd.executeQuery();
              
              while(rs.next())
              {
                  resp.setCodiProv(rs.getInt(1));
                  resp.setNombProv(rs.getString(2));
                  resp.setDireProv(rs.getString(3));                  
              }
         } catch (Exception e) {
         }
         return resp;
     }
    
}
