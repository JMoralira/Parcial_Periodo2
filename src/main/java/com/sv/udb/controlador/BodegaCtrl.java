/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;
import com.sv.udb.modelo.Bodega;
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
public class BodegaCtrl {
     //GUARDAR
    public boolean guar(Bodega obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into bodega values(NULL,?,?,?,?)");
            cmd.setInt(1, obje.getCodiPiez());
            cmd.setInt(2, obje.getCodiProv());
            cmd.setInt(3, obje.getCant());
            cmd.setString(4, obje.getFech());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Bodega: " + ex.getMessage());
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
    public List<Bodega> consTodo()
    {
        List<Bodega> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = cn.prepareStatement("select bodega.codi_bode, bodega.codi_piez, bodega.codi_prov, bodega.cant, bodega.fech, proveedores.nomb_prov, piezas.nomb_piez from piezas,bodega, proveedores where bodega.codi_piez = piezas.codi_piez and bodega.codi_prov = proveedores.codi_prov;");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {                
                resp.add(new Bodega (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));               
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
  
      public Bodega cons(int codi)
    {
        //List<Equipos> resp = new ArrayList();
        Bodega resp= null;
        Connection cn = new Conexion().getConn();
        try 
        {
            
            PreparedStatement cmd = cn.prepareStatement("select bodega.codi_bode, bodega.codi_piez, bodega.codi_prov, bodega.cant, bodega.fech, proveedores.nomb_prov, piezas.nomb_piez from piezas,bodega, proveedores where bodega.codi_piez = piezas.codi_piez and bodega.codi_prov = proveedores.codi_prov and codi_bode = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {                
                 resp = (new Bodega(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
  
    
}
