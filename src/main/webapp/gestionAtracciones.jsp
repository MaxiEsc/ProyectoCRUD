<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Proyecto Tierra Media</title>
<link rel="stylesheet" href="css/estilos.css">

 <!--Implementamos booststrap 5 para un menu desplegable--> <!-- Necesario para el menu desplegable -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="css/style.css">
 <!-- Fin de archivos necesarios para Bootstrap 5 -->


</head>
<body>
	<div class="container">
		
   	<main class="container">
		<h1 class="container">Tierra Media</h1>
    </main>
   		<header class="container-fluid">
   			
   			<nav class="container-fluid bg-info" >
   				<ul>
					<li><button class="btn btn-info" type="button" data-bs-toggle="offcanvas" data-bs-target="#menu-desplegable" aria-controls="offcanvas"><b>Usuario Actual</b></button></li>					
					<li> <a href="GestionPromociones.do" class="btn btn-info">Promocion</a></li>
					<li> <a href="exitoRegistro.jsp" class="btn btn-info">Inicio</a></li>
					<li> <a href="GestionUsuario.do" class="btn btn-info">Usuario</a></li>
   				</ul>
   			</nav>
   		</header>

		    <!-- Contenido de Menu-Desplegable de Bootstrap 5 -->
    <div class="offcanvas offcanvas-start bg-info text-white" tabindex="-1"
	id="menu-desplegable" aria-labelledby="offcanvasLabel">
	<div class="offcanvas-header">
	  <h5 class="offcanvas-title">Mi Cuenta</h5>
	  <button type="button" class="btn-close text-reset " data-bs-dismiss="offcanvas" aria-label="Close"> </button>
	</div>
	<div class="offcanvas-body">
	  <div>
		  <p>Datos</p></br>
		  <input class="form-control" type="text" placeholder="Ingrese su usuario" id="carga-usuario_nombre" name="userName"> </br>
		  <input class="form-control" type="password" placeholder="********" name="password"> </br>
		  <a class="navlink" href="">¿Se encuentra desorientado? Pinche aqui</a></br></br>
		  <a class="navlink" href="registroUsuario.jsp">Si no tiene usuario, Registrese</a><br><br>
		  <button class="btn btn-primary bg-info">Aceptar</button>
		  <button class="btn btn-primary bg-info" data-bs-dismiss="offcanvas" aria-label="Close">Cerrar</button>
	  </div>
	  <div class="dropdown mt-4">
	  </div>
	</div>
  </div>
  <!-- Fin del contenido -->  

  <!-- Inicio de contendio de ventana modal-->
  <div class="container bg-info">
	<div class="modal" tabindex="-1" id="ingreso-codigo">
		<div class="modal-dialog bg-info">
			<div class="modal-content bg-info">
				<div class="modal-header bg-info">
					<p class="text-white">Gestor de codigos de empleado</p>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body bg-info">
					<p class="text-white">Ingrese su codigo de empleado</p></br>
					Contraseña: <input class="form-control" type="password" placeholder="Ingrese su codigo">				
				</br> 
					<a class="navlink" href="ayuda.jsp">¿Se encuentra desorientado? Pinche aqui</a></br></br>
					<a class="navlink" href="registroUsuario.jsp">Si no tiene usuario, Registrese</a><br><br>
				</div>
				<div class="modal-footer bg-info">
					<button class="btn btn-secondary">Guardar cambios</button></br>
					<button class="btn btn-danger">&times;</button>
				</div>
			</div>
		</div>
	</div>
</div>   
<!--Fin de ventana modal-->   

  <section> 

	<div class="container bg-dark text-white"> 
		<h1>Gestion de atracciones</h1>
        <p>lista de atracciones</p>
	</div>

    <div class="container">
		<button class="btn btn-info">Lista de Atraccion: </button>
	</div>

	<div class="container">
		<table class="table table">
			<thead>
			  <tr>
				<th scope="col">ID Cliente</th>
				<th scope="col">Nombre</th>
				<th scope="col">Valor</th>
				<th scope="col">Duracion</th>
				<th scope="col">Cupo</th>			
			  </tr>
			</thead>
			<tbody>
			 <c:forEach var="atraccion" items="${atracciones}">
             <tr>
                <th scope="row"><c:out value="${ atraccion.id_Atraccion }"></c:out></th>
                <td><c:out value="${ atraccion.nombre }"></c:out></td>
                <td><c:out value="${ atraccion.valor }"></c:out></td>
                <td><c:out value="${ atraccion.duracion }"></c:out></td>
                <td><c:out value="${ atraccion.cupo }"></c:out></td>
              </tr>
            </c:forEach>
			</tbody>
		  </table>
	</div>

	<div class="container">		
		<h2> ¿Que desea realizar?</h2>
		<button class="btn btn-info"><div class="container">
			<a href="altaAtraccion.jsp"> Nueva Atraccion</a>
		</div>
		</button>
		<button class="btn btn-info"><div class="container">
			<a href="modificarAtraccion.jsp">Modificar un Atraccion</a>
		</div>
		</button>
		<button class="btn btn-info"><div class="container">
			<a href="borrarAtracciones.jsp">Eliminar un Atraccion</a>
		</div>
		</button>
	</div>


	
</section>
<aside> 
	<p>Registrese y obtenga todas las posibilidades </p>
  	<div><img src="img/imagen.jpg" width="100" height="120" class="img-fluid"></div>
  	<p>Accedera a los mejores precios, mejores ofertas y todas las promociones</p>
</aside>

   </div>
</body>
</html>