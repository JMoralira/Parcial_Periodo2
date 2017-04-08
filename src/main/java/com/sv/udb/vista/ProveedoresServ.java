/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.ProveedoresCtrl;
import com.sv.udb.modelo.Proveedores;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jose Lira
 */
@MultipartConfig
@WebServlet(name = "ProveedoresServ", urlPatterns = {"/ProveedoresServ"})
public class ProveedoresServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         boolean esValido = request.getMethod().equals("POST");
       String mens = "";
       if(!esValido)
       {
           response.sendRedirect(request.getContextPath()+"/proveedores.jsp");
       }
       else
       {
           String CRUD = request.getParameter("btonProv");
           if(CRUD.equals("Guardar"))
           {
               Proveedores obje = new Proveedores();               
               obje.setNombProv(request.getParameter("nomb"));
               obje.setDireProv(request.getParameter("dire"));
               obje.setTeleProv(request.getParameter("tele"));
               
           if(new ProveedoresCtrl().guar(obje))
           {
               mens= "Datos Guardados";
           }
           else
           {
               mens = "Error al Guardar";
           }
           }
       else if(CRUD.equals("Consultar"))
               {
                   int codi = Integer.parseInt(request.getParameter("codiProvRadi").isEmpty() ? "-1" : request.getParameter("codiProvRadi"));
                   Proveedores obje = new ProveedoresCtrl().cons(codi);
                   if(obje != null)
                   {
                       request.setAttribute("codi", obje.getCodiProv());                       
                       request.setAttribute("nomb", obje.getNombProv());
                       request.setAttribute("dire", obje.getDireProv());
                       request.setAttribute("tele", obje.getTeleProv());
                       mens="Información consultada";                       
                   }
                   else 
                   {
                       mens ="Error al consultar";
                   }
               }
       else if (CRUD.equals("Eliminar"))
       {
           Proveedores obje = new Proveedores();
           obje.setCodiProv(Integer.parseInt(request.getParameter("codi")));
           if(new ProveedoresCtrl().elim(obje))
           {
               mens = "Datos Eliminado";
           }
           else
           {
               mens = "Error al Eliminar";
           }
       }
       else if (CRUD.equals("Modificar"))
       {
           Proveedores obje = new Proveedores();
           obje.setCodiProv(Integer.parseInt(request.getParameter("codi")));           
           obje.setNombProv(request.getParameter("nomb"));
           obje.setDireProv(request.getParameter("dire"));
           obje.setTeleProv(request.getParameter("tele"));
           if(new ProveedoresCtrl().modi(obje))
           {
               mens = "Datos Modificados";               
           }
           else
           {
               mens = "Error al Modificar";
           }           
       }
           else if(CRUD.equals("Nuevo"))
                   {
                       request.setAttribute("codi","");
                       request.setAttribute("nomb", "");
                       request.setAttribute("dire", "");
                       request.setAttribute("tele", "");                                                   
                   }
           request.setAttribute("mensAler", mens);
           request.getRequestDispatcher("/proveedores.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
