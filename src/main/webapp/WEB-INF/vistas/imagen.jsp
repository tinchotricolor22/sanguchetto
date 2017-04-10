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
						<div class="panel-heading">Seleccionar Imagen</div>
						<div class="panel-body">

						
							<div class="row">
								<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=defecto" class="thumbnail">
								      <img src="/Sangucheto/fonts/defecto.png" alt="que" width="100" height="100">
								    </a>
								 </div>
								<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=cebolla" class="thumbnail">
								      <img src="/Sangucheto/fonts/cebolla.png" alt="que" width="100" height="100">
								    </a>
								 </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=tomate" class="thumbnail">
								      <img src="/Sangucheto/fonts/tomate.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=lechuga" class="thumbnail">
								      <img src="/Sangucheto/fonts/lechuga.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=pepino" class="thumbnail">
								      <img src="/Sangucheto/fonts/pepino.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=bife chorizo" class="thumbnail">
								      <img src="/Sangucheto/fonts/bife chorizo.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=paty" class="thumbnail">
								      <img src="/Sangucheto/fonts/paty.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=milanesa" class="thumbnail">
								      <img src="/Sangucheto/fonts/milanesa.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=jamon c" class="thumbnail">
								      <img src="/Sangucheto/fonts/jamon c.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=matambre v" class="thumbnail">
								      <img src="/Sangucheto/fonts/matambre v.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=salame" class="thumbnail">
								      <img src="/Sangucheto/fonts/salame.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=matambre p" class="thumbnail">
								      <img src="/Sangucheto/fonts/matambre p.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=queso cheddar" class="thumbnail">
								      <img src="/Sangucheto/fonts/queso cheddar.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=mayonesa" class="thumbnail">
								      <img src="/Sangucheto/fonts/mayonesa.png" alt="que" width="100" height="100">
								    </a>
								 </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=mostaza" class="thumbnail">
								      <img src="/Sangucheto/fonts/mostaza.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=ketchup" class="thumbnail">
								      <img src="/Sangucheto/fonts/ketchup.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=sal" class="thumbnail">
								      <img src="/Sangucheto/fonts/sal.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=pan i" class="thumbnail">
								      <img src="/Sangucheto/fonts/pan i.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=pan f" class="thumbnail">
								      <img src="/Sangucheto/fonts/pan f.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=pan h" class="thumbnail">
								      <img src="/Sangucheto/fonts/pan h.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  <div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=chorizo" class="thumbnail">
								      <img src="/Sangucheto/fonts/chorizo.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=chimi" class="thumbnail">
								      <img src="/Sangucheto/fonts/chimi.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=huevo" class="thumbnail">
								      <img src="/Sangucheto/fonts/huevo.png" alt="que" width="100" height="100">
								    </a>
								  </div>
								  	<div class="col-xs-6 col-md-2">
								    <a href="alta_producto?imagen=mortadela" class="thumbnail">
								      <img src="/Sangucheto/fonts/mortadela.png" alt="que" width="100" height="100">
								    </a>
								  </div>

							  </div>
						</div>
					</div>			
				</div>
				<div class="col-md-2"></div>
			</div>
			
		</div> 	
	</body>
</html>