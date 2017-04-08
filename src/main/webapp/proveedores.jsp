<%-- 
    Document   : proveedores
    Created on : 04-08-2017, 10:27:52 AM
    Author     : Jose Lira
--%>
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
        <h1>${mensAler}</h1>
        <form method="POST" action="ProveedoresServ" name="DEMO" enctype="multipart/form-data">
                    <label for="codi">Codigo:</label>
                    <input type="text" name="codi" id="codi" value="${codi}" readonly> <br>
                    <label for="nomb">Nombre:</label>
                    <input type="text" name="nomb" id="nomb" value="${nomb}" required> <br>
                    <label for="dire">Direccion</label>
                    <input type="text" name="dire" id="dire" value="${dire}" required> <br>
                    <label for="tele">Telefono</label>
                    <input type="text" name="tele" id="tele" value="${tele}" required> <br>
        
                <button class="btn waves-effect waves-light" type="submit" name="btonProv" value="Guardar"> Guardar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonProv" value="Modificar">Modificar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonProv" value="Eliminar">Eliminar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonProv" value="Nuevo">Nuevo
                <i class="material-icons right">send</i>
                </button>
        <ul>
            <li><a href="bodega.jsp">Bodegas</a></li>
            <li><a href="piezas.jsp">Piezas</a></li>
            
        </ul>            
        </form>
        
        <h1>La Tabla</h1>
        <form method="POST" action="ProveedoresServ" name="TABLA">
        <table>
            <thead>
            <tr>
                <th>Cons</th>
                <th>Nombre</th>
                <th>Direccion</th>      
                <th>Telefono</th>
            </tr>
            </thead>
            <tbody>
                
            <%
            for (Proveedores temp : new ProveedoresCtrl().consTodo())
            {
                
            %>
            <tr>
                <td><p><input name="codiProvRadi" type="radio" id="<%=temp.getCodiProv()%>" value="<%=temp.getCodiProv()%>" />
                        <label for="<%=temp.getCodiProv()%>"></label></p></td>
                <td><%= temp.getNombProv()%></td>
                <td><%= temp.getDireProv()%></td>                
                <td><%= temp.getTeleProv()%></td>                
            </tr>
            <%
            }
            %>
            </tbody>
        </table>
            <button class="btn waves-effect waves-light" type="submit" name="btonProv" value="Consultar">Consultar
            <i class="material-icons right">send</i>
            </button>
        </form>
    </div>
    </body>
</html>
