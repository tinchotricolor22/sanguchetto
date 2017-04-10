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
				<div id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			      <li class="active"><a  href="lista_stock">Stock</a></li>
				  </ul>
			    </div>
			    <div id="shopping-cart" class="dropdown">

			    </div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="panel panel-primary">
						<div class="panel-heading">Ingresar Producto</div>
						<div class="panel-body">
							<div class="col-md-8">
						
							<form:form action="recibe_alta" method="POST" modelAttribute="ingrediente" >
								<div class="form-group">
											<form:label path="nombre" class="col-2 col-form-label" >Nombre</form:label>
											<form:input path="nombre" class="form-control" value="${imagen}"/>
								</div>
								<div class="form-group">
											<form:label path="precio">Precio</form:label>
											<form:input path="precio" class="form-control" type="number" step="0.01" value="0.0" />
								</div>				
								<div class="form-group">
									<form:label path="tipo">Tipo</form:label>
									<form:select path="tipo"  class="form-control" >
										<form:options items="${countryList}" />
									</form:select>
								</div>		  
								<form:hidden path="imagen" value="${imagen}.png" /> 
						 		<div class="form-group">
									<button type="submit" class="btn btn-primary">Guardar</button>
								</div>
							</form:form>	
							</div>
							<div class="col-md-4">
								<p class="text-center">
								<img src="/Sangucheto/fonts/${imagen}.png" alt="que" width="100" height="100">
								</p>
							</div>
						</div>
					</div>			
				</div>
				<div class="col-md-2"></div>
			</div>
			
		</div> 	
	</body>
</html>