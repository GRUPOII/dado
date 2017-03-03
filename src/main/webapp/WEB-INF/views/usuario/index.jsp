<%@ include file="../includes/header.jsp"%>


<h1>Listado de usuarios</h1>

<table class="tablePlugin" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>NOMBRE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.nombre}</td>
			</tr>
		</c:forEach>


	</tbody>
</table>


<%@ include file="../includes/footer.jsp"%>