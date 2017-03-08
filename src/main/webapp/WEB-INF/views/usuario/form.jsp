<%@ include file="../includes/header.jsp"%>

<c:if test="${not empty usuario.nombre}">
	<h2>${usuario.nombre}</h2>
</c:if>

<c:if test="${empty usuario.nombre}">
	<h2>Crear nuevo usuario</h2>
</c:if>

${msg}

<div class="row">
	<div class="col-md-6">
		<form:form action="admin/usuario/crear" modelAttribute="usuario">

			<form:hidden path="id" readonly="true" />
			<br>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" />
			<br>
			<form:errors path="nombre" cssStyle="color:red;" />
			<br>

			<c:choose>
				<c:when test="${usuario.id == -1}">
					<form:button type="submit">Crear</form:button>
				</c:when>
				<c:otherwise>
					<form:button type="submit">Modificar</form:button>
				</c:otherwise>
			</c:choose>

			<form action="admin">
				<input type="submit" value="Volver" />
			</form>

		</form:form>
	</div>

</div>
<!-- <div class="row"> -->

<c:if test="${usuario.id != -1}">
	<br>
	<a style="color: red;" href="admin/usuario/delete/${usuario.id}">Eliminar</a>
</c:if>