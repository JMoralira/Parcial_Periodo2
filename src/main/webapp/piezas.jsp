<%-- 
    Document   : piezas
    Created on : 04-08-2017, 10:27:36 AM
    Author     : Jose Lira
--%>
<%@page import="com.sv.udb.controlador.PiezasCtrl"%>
<%@page import="com.sv.udb.modelo.Piezas"%>
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
        <h1>${mensAler}</h1>
        <form method="POST" action="PiezasServ" name="DEMO" enctype="multipart/form-data">
                    <label for="codi">Codigo:</label>
                    <input type="text" name="codi" id="codi" value="${codi}" readonly> <br>
                    <label for="nomb">Nombre:</label>
                    <input type="text" name="nomb" id="nomb" value="${nomb}" required> <br>
                    <label for="tipo">Tipo</label>
                    <input type="text" name="tipo" id="tipo" value="${tipo}" required> <br>
                    <label for="marc">Marca</label>
                    <input type="text" name="marc" id="marc" value="${marc}" required> <br>
        
                <button class="btn waves-effect waves-light" type="submit" name="btonPiez" value="Guardar"> Guardar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPiez" value="Modificar">Modificar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPiez" value="Eliminar">Eliminar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPiez" value="Nuevo">Nuevo
                <i class="material-icons right">send</i>
                </button>
        <ul>
            <li><a href="index.jsp">Bodegas</a></li>
            <li><a href="proveedores.jsp">Proveedores</a></li>
            
        </ul>            
        </form>
        
        <h1>La Tabla</h1>
        <form method="POST" action="PiezasServ" name="TABLA">
        <table>
            <thead>
            <tr>
                <th>Cons</th>
                <th>Nombre</th>
                <th>Tipo</th>      
                <th>Marca</th>
            </tr>
            </thead>
            <tbody>
                
            <%
            for (Piezas temp : new PiezasCtrl().consTodo())
            {
                
            %>
            <tr>
                <td><p><input name="codiPiezRadi" type="radio" id="<%=temp.getCodiPiez()%>" value="<%=temp.getCodiPiez()%>" />
                        <label for="<%=temp.getCodiPiez()%>"></label></p></td>
                <td><%= temp.getNombPiez()%></td>
                <td><%= temp.getTipoPiez()%></td>                
                <td><%= temp.getMarcPiez()%></td>                
            </tr>
            <%
            }
            %>
            </tbody>
        </table>
            <button class="btn waves-effect waves-light" type="submit" name="btonPiez" value="Consultar">Consultar
            <i class="material-icons right">send</i>
            </button>
        </form>
    </div>
    </body>
</html>
