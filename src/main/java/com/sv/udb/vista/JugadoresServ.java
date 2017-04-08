/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.JugadoresCtrl;
import com.sv.udb.modelo.Jugadores;
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
@WebServlet(name = "JugadoresServ", urlPatterns = {"/JugadoresServ"})
public class JugadoresServ extends HttpServlet {

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
           response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
       else
       {
           String CRUD = request.getParameter("btoJuga");
           if(CRUD.equals("Guardar"))
           {
               Jugadores obje = new Jugadores();
               obje.setCodiEqui(Integer.parseInt(request.getParameter("cmbEquipo")));
               obje.setNombJuga(request.getParameter("nomb"));
               obje.setEdadJuga (Integer.parseInt(request.getParameter("edad")));
               obje.setAltuJuga (Double.parseDouble(request.getParameter("altu")));
               obje.setPesoJuga(Double.parseDouble(request.getParameter("peso")));               
               Part filePart = request.getPart("ima");
            int fotoSize = (int)filePart.getSize();
            byte[] foto = null;
            foto = new byte[fotoSize];
            try(DataInputStream dataImg = new DataInputStream(filePart.getInputStream()))
            {
                dataImg.readFully(foto);
            }
            obje.setImag(foto);
          
           if(new JugadoresCtrl().guar(obje))
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
                   int codi = Integer.parseInt(request.getParameter("codiJugaRadi").isEmpty() ? "-1" : request.getParameter("codiJugaRadi"));
                   Jugadores obje = new JugadoresCtrl().cons(codi);
                   if(obje != null)
                   {
                       request.setAttribute("codi", obje.getCodiJuga());
                       request.setAttribute("cmbEquipo", obje.getCodiEqui());
                       request.setAttribute("nomb", obje.getNombJuga());
                       request.setAttribute("edad", obje.getEdadJuga());
                       request.setAttribute("altu", obje.getAltuJuga());
                       request.setAttribute("peso", obje.getPesoJuga());
                       request.setAttribute("ima", obje.getImag());
                       mens="Información consultada";                       
                   }
                   else 
                   {
                       mens ="Error al consultar";
                   }
               }
       else if (CRUD.equals("Eliminar"))
       {
           Jugadores obje = new Jugadores();
           obje.setCodiJuga(Integer.parseInt(request.getParameter("codi")));
           if(new JugadoresCtrl().elim(obje))
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
           Jugadores obje = new Jugadores();
           obje.setCodiJuga(Integer.parseInt(request.getParameter("codi")));
           obje.setCodiEqui(Integer.parseInt(request.getParameter("cmbEquipo")));
           obje.setNombJuga(request.getParameter("nomb"));
           obje.setEdadJuga(Integer.parseInt(request.getParameter("edad")));
           obje.setAltuJuga(Double.parseDouble(request.getParameter("altu")));
           obje.setPesoJuga(Double.parseDouble(request.getParameter("peso")));
           Part filePart = request.getPart("ima");
                int fotoSize = (int)filePart.getSize();
            byte[] foto = null;
            foto = new byte[fotoSize];
            try(DataInputStream dataImg = new DataInputStream(filePart.getInputStream()))
            {
                dataImg.readFully(foto);
            }
            obje.setImag(foto);
           if(new JugadoresCtrl().modi(obje))
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
                       request.setAttribute("edad", "");
                       request.setAttribute("altu", "");
                       request.setAttribute("peso", "");                               
                   }
           request.setAttribute("mensAler", mens);
           request.getRequestDispatcher("/index.jsp").forward(request, response);
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
