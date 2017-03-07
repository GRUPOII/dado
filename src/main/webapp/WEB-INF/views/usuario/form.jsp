<%@ include file="../includes/header.jsp" %> 

<a href="admin">Volver</a>

<c:if test="${not empty usuario.nombre}">
	<h1>${usuario.nombre}</h1>
</c:if>

<c:if test="${empty usuario.nombre}">
	<h1>Crear nuevo usuario</h1>
</c:if>



${msg}

<div class="row">
<div class="col-md-6">
	<form:form action="admin/usuario/crear" modelAttribute="usuario">
	
		<form:input path="id" readonly="true"/><br>
		<form:input path="nombre"/><br>	
		<form:errors path="nombre" cssStyle="color:red;"/><br>

		<br>
		
			<c:choose>
			<c:when test="${usuario.id == -1}">
				<form:button type="submit">Crear</form:button>
			</c:when>
			<c:otherwise>
				<form:button type="submit">Modificar</form:button>
			</c:otherwise>
		</c:choose>
	
	</form:form>
</div>

</div><!-- <div class="row"> -->

<c:if test="${usuario.id != -1}">
	<br>
	<a style="color:red;" href="admin/usuario/delete/${usuario.id}">Eliminar</a>
</c:if>