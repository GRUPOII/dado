<%@ include file="../includes/header.jsp"%>


<h2>Listado de usuarios</h2>

<table class="tablePlugin" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>MODIFICAR</th>
			<th>ELIMINAR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.nombre}</td>
				<td>Botón modificar</td>
				<td>Botón eliminar</td>
			</tr>
		</c:forEach>


	</tbody>
</table>


<%@ include file="../includes/footer.jsp"%>