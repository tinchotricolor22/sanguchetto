<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sanguchetto</title>
		<link href="css/styles.css" rel="stylesheet">
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="page-header">
			<div class="container-fluid">
			
				<div id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a  href=".">Home<span class="sr-only">(current)</span></a></li>
			      </ul>
			    </div>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="lista_stock">Stock</a>
				</div>

			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<a href="img">
						<button class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> Agregar Producto</button>
					</a>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="panel panel-default">
				  <!-- Default panel contents -->
				  <div class="panel-heading"><b>Lista de Productos</b></div>
				
				  <!-- Table -->
				  <table class="table">
				     <tr>
					    <th>Nombre</th>
					    <th>Precio</th> 
					    <th>Tipo</th>
					    <th>Cantidad</th>
					    <th>Agregar</th>
					    <th>Vaciar</th>
					    <th><!--  Eliminar --></th>
					  </tr>
					  
					 
					  
					  <c:forEach var="ingrediente" items="${ingredientes}">
					  <tr>
					    <td>${ingrediente.key.nombre} </td>
					    <td>$ ${ingrediente.key.precio} </td>
					    <td>${ingrediente.key.tipo} </td>
					    <td>${ingrediente.value} </td>
					    <td>
							
								<form:form action="sumar_stock" method="POST" modelAttribute="ingrediente_nc">
									<form:input path="cantidad" type="number" size="10" min="0" value="0" />
									<form:hidden path="nombre" value="${ingrediente.key.nombre}" />
									<input type="submit" value="+" class="btn btn-primary">
								</form:form>
					    </td>
					    <td>
							<a href="vaciar_ingrediente/${ingrediente.key.nombre}">
								<button type="button" class="btn btn-warning">0</button>
							</a>
					    </td>
					    <td>
					    <!--  
							<a href="eliminar_ingrediente/${ingrediente.key.nombre}">
								<button type="button" class="btn btn-danger">X</button>
							</a>
						-->
					    </td>
					  </tr>  
					  </c:forEach>
					  
					  
				  </table>
				</div>
			</div>
			
		</div> 	
	</body>
</html>