<%@ include file="../includes/header.jsp"%>


<h2>Listado de usuarios</h2>
<a href="admin/usuario/edit">Nuevo usuario</a>
<div class="row">
<div class="col-md-6">

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
				<td><a href="admin/usuario/edit/${u.id}">${u.nombre}</a></td>
				<td>Bot�n modificar</td>
				<td>Bot�n eliminar</td>
			</tr>
		</c:forEach>


	</tbody>
</table>


</div>



</div><!-- <div class="row"> -->

<%@ include file="../includes/footer.jsp"%>