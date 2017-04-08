/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.PiezasCtrl;
import com.sv.udb.modelo.Piezas;
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
@WebServlet(name = "PiezasServ", urlPatterns = {"/PiezasServ"})
public class PiezasServ extends HttpServlet {

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
           response.sendRedirect(request.getContextPath()+"/piezas.jsp");
       }
       else
       {
           String CRUD = request.getParameter("btonPiez");
           if(CRUD.equals("Guardar"))
           {
               Piezas obje = new Piezas();               
               obje.setNombPiez(request.getParameter("nomb"));
               obje.setTipoPiez(request.getParameter("tipo"));
               obje.setMarcPiez(request.getParameter("marc"));
               
           if(new PiezasCtrl().guar(obje))
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
                   int codi = Integer.parseInt(request.getParameter("codiPiezRadi").isEmpty() ? "-1" : request.getParameter("codiPiezRadi"));
                   Piezas obje = new PiezasCtrl().cons(codi);
                   if(obje != null)
                   {
                       request.setAttribute("codi", obje.getCodiPiez());                       
                       request.setAttribute("nomb", obje.getNombPiez());
                       request.setAttribute("tipo", obje.getTipoPiez());
                       request.setAttribute("marc", obje.getMarcPiez());
                       mens="Información consultada";                       
                   }
                   else 
                   {
                       mens ="Error al consultar";
                   }
               }
       else if (CRUD.equals("Eliminar"))
       {
           Piezas obje = new Piezas();
           obje.setCodiPiez(Integer.parseInt(request.getParameter("codi")));
           if(new PiezasCtrl().elim(obje))
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
           Piezas obje = new Piezas();
           obje.setCodiPiez(Integer.parseInt(request.getParameter("codi")));           
           obje.setNombPiez(request.getParameter("nomb"));
           obje.setTipoPiez(request.getParameter("tipo"));
           obje.setMarcPiez(request.getParameter("marc"));
           if(new PiezasCtrl().modi(obje))
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
                       request.setAttribute("tipo", "");
                       request.setAttribute("marc", "");                       
                   }
           request.setAttribute("mensAler", mens);
           request.getRequestDispatcher("/piezas.jsp").forward(request, response);
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
