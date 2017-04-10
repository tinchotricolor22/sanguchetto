<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<script src="js/main.js"></script>
	</head>
	<body>
		<div id="header-main" class="page-header">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">Home</a>
				</div>
				<div id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="lista_stock">Stock<span class="sr-only">(current)</span></a></li>
			      </ul>
			    </div>
			</div>
		</div>
		<div class="container">
			<div id="ingredient-list" class="col-md-9">
				<c:if test="${fn:length(errors) gt 0}">
					<div id="errors" class="row">
						<c:forEach items="${errors}" var="error" varStatus="status">
							<div class="col-md-12">
								<div class="alert alert-danger">
						  			${error}
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
				<form:form class="form-group" action="agregar_ingredientes" method="POST" modelAttribute="stockFormRequest">
					<div class="row">
						<div class="col-md-2">
							<button id="buttonAdd"class="btn btn-success" disabled="true"><i class="glyphicon glyphicon-plus"></i> Agregar Seleccionados</button>
						</div>
					</div>
					<div class="row">
						<c:forEach items="${stock}" var="ingrediente" varStatus="status">
							<div class="col-md-4">
								<div class="well ingredient">
									<div class="ingredient-body row">
										<div class="col-md-7">
											<img src="${ingrediente.key.img}">
										</div>
										<div class="col-md-5">
											<span class="nombre-ingrediente">${ ingrediente.key.nombre}</span> <br>
											<strong>$<span class="precio-ingrediente">${ ingrediente.key.precio}</span></strong><br>
											<span class="precio-descuento"></span><br>
											<div class="descuento">
												<label>Desc.(%)</label>
											    <form:input id="dI${status.index}" path="ingredientes[${status.index}].descuento" class="form-control descuentoInput" type="number" max="100" min="0" value="0" />
											</div>
										</div>
									</div>
									<div class="row">	
										<c:if test="${ingrediente.value > 0}">
											<span class="disponibles">${ingrediente.value} Disponibles</span>
											<form:input path="ingredientes[${status.index}].cantidad" class="form-control ingredientValue" type="number" max="${ingrediente.value}" min="0" value="0"/>
										</c:if>
										<c:if test="${ingrediente.value <= 0}">
											<span class="sinStock"> Sin Stock</span>
											<input type="number" class="form-control"style="visibility:hidden;">
										</c:if>
									</div>
								</div>				
							</div>
						</c:forEach>
					</div>
				</form:form>
			</div> 	
			<div id="sanguchetto-container" class="col-md-3">
				<div id="sanguchetto-header"class="row">
					<div class="col-md-12">
						<h1>Sanguchetto <span class="hamburger-icon"></span></h1>
					</div>
				</div>
				<c:if test="${fn:length(sanguchettoIngredientes) gt 0}">
					<div class="row">
						<div id="header-ingredient" class="col-md-12">
							<h4> Ingredientes</h4>
						</div>
						<c:forEach items="${sanguchettoIngredientes}" var="sanguchettoIngrediente">
							<div class="sanguchetto-ingredient col-md-12">
								<div class="col-md-7">
									<c:if test="${not empty sanguchettoIngrediente.key.img}">
										<img src="${sanguchettoIngrediente.key.img}">
									</c:if>
								</div>
								<div class="col-md-5">
									<p align="center">
										<span class="nombre-ingrediente">${ sanguchettoIngrediente.key.nombre }</span> <br>
										${ sanguchettoIngrediente.value } x <strong>$${ sanguchettoIngrediente.key.precio }</strong>										
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${fn:length(sanguchettoCondimentos) gt 0}">
					<div class="row">
						<div id="header-condiment" class="col-md-12">
							<h4> Condimentos</h4>
						</div>
						<c:forEach items="${sanguchettoCondimentos}" var="sanguchettoCondimento">
							<div class="sanguchetto-ingredient col-md-12">
								<div class="col-md-7">
									<c:if test="${not empty sanguchettoCondimento.key.img}">
										<img src="${sanguchettoCondimento.key.img}">
									</c:if>
								</div>
								<div class="col-md-5">
									<p align="center">
										<span class="nombre-ingrediente">${ sanguchettoCondimento.key.nombre }</span> <br>
										${ sanguchettoCondimento.value } x <strong>$${ sanguchettoCondimento.key.precio }</strong>					
									</p>
								</div>				
							</div>
						</c:forEach>
					</div>
				</c:if>
				<div id="sanguchetto-footer">
					<div class="row">
						<c:if test="${sanguchettoAhorro <= 0}">
							<div class="col-md-12">
								<h2>Total: <span class="price">$${sanguchettoTotal}</span></h2>
							</div>
						</c:if>
						<c:if test="${sanguchettoAhorro > 0}">
							<div class="col-md-12">
								<h2>Total: <span class="price tachado">$${sanguchettoTotal}</span></h2>
								<h2 class="ahorro"><span class="price">$${sanguchettoTotal - sanguchettoAhorro}</span></h2>
							</div>
						</c:if>
					</div>
					<c:if test="${fn:length(sanguchettoCondimentos) gt 0 || fn:length(sanguchettoIngredientes) gt 0}">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">
									<a href="/Sangucheto/vaciar_sanguchetto" class="btn btn-danger" onclick="vaciarSanguchetto()">Cancelar</a>
								</div>
								<div class="col-md-6">
									<a href="/Sangucheto/confirmar_sanguchetto" class="btn btn-success" onclick="confirmarSanguchetto()">Comprar</a>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</body>
</html>