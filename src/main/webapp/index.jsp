<%-- 
    Document   : bodega
    Created on : 04-08-2017, 10:27:17 AM
    Author     : Jose Lira
--%>
<%@page import="com.sv.udb.controlador.BodegaCtrl"%>
<%@page import="com.sv.udb.modelo.Bodega"%>
<%@page import="com.sv.udb.controlador.PiezasCtrl"%>
<%@page import="com.sv.udb.modelo.Piezas"%>
<%@page import="com.sv.udb.controlador.ProveedoresCtrl"%>
<%@page import="com.sv.udb.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
         <form method="POST" action="BodegaServ" name="DEMO" enctype="multipart/form-data">
        <h1>${mensAler}</h1>
        <label>Codigo:</label>
        <input type="text" name="codi" id="codi" value="${codi}" readonly> <br>
        <label>Id Piezas:</label>
        <select id="cmbPiezas" name="cmbPiezas" value="${cmbPiezas}">
            
            <option  disabled selected> Seleccione una Pieza</option>
            <%                
                for(Piezas temp : new PiezasCtrl().consTodo())
                {
            %>
            <option value="<%=temp.getCodiPiez()%>"><%=temp.getNombPiez()%></option>;
            <%
                }
            %>
        </select> <br>
        <label>Id Proveedores</label>
        <select id="cmbProveedores" name="cmbProveedores" value="${cmbProveedores}">
            
            <option  disabled selected> Seleccione un Proveedor</option>
            <%                
                for(Proveedores temp : new ProveedoresCtrl().consTodo())
                {
            %>
            <option value="<%=temp.getCodiProv()%>"><%=temp.getNombProv()%></option>;
            <%
                }
            %>
        </select> <br>
        <label>Cantidad:</label>
        <input type="text" name="cant" id="cant" value="${cant}" required> <br>
        <label>Fecha:</label>
        <input type="text" name="fech" id="fech" value="${fech}" required> <br>
        
          
      
                <button class="btn waves-effect waves-light" type="submit" name="btoBode" value="Guardar">Guardar
                <i class="material-icons right">send</i>
                </button>
               
        <ul>
            <li><a href="piezas.jsp">Piezas</a></li>
            <li><a href="proveedores.jsp">Proveedores</a></li>
        </ul>
        </form>
        
        <h1>La Tabla</h1>
        <form method="POST" action="BodegaServ" name="TABLA">
        <table border="1">
            <thead>
            <tr>
                <th>Cons</th>
                <th>Piezas</th>
                <th>Proveedores</th>
                <th>Cantidad</th>
                <th>Fecha</th>
                
            </tr>
            </thead>
            <tbody>
            <%
            for (Bodega temp : new BodegaCtrl().consTodo())
            {
               
            %>
            <tr>
                <td><p><input type="radio" name="codiBodeRadi" value="<%= temp.getCodiBode()%>" id="<%= temp.getCodiBode() %>"/>
                        <label for="<%=temp.getCodiBode()%>"></label></p></td>
                <td><%= temp.getPiez()%></td>
                <td><%= temp.getProv()%></td>
                <td><%= temp.getCant() %></td>
                <td><%= temp.getFech() %></td>
            </tr>
            <%
            }
            %>
            </tbody>
        </table>
            <button class="btn waves-effect waves-light" type="submit" name="btoBode" value="Consultar">Consultar
            <i class="material-icons right">send</i>
            </button>
        </form>
        </div>
            <script>
        $(document).ready(function() {
            $('select').material_select();
          });
    </script>
    </body>
</html>
