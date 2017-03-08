<%@ include file="../includes/header.jsp"%>


<h2 id="h2center">Listado de usuarios</h2>

<div class="row">
	<div class="col-md">

		<table class="table table-striped table-bordered dt-responsive nowrap"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>MODIFICAR</th>
					<th>DAR DE BAJA</th>
					<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="u">
					<tr>
						<td>${u.id}</td>
						<td>${u.nombre}</td>
						<td><a style="color: green;"
							href="admin/usuario/edit/${u.id}">Modificar</a></td>
						<c:if test="${u.fechaBaja!=null}">
							<td><a style="color: blue"
								; href="admin/usuario/alta/${u.id}">Dar de alta</a></td>
						</c:if>
						<c:if test="${u.fechaBaja==null}">
							<td><a style="color: orange;"
								href="admin/usuario/baja/${u.id}">Dar de baja</a></td>
						</c:if>
						<td><a style="color: red;"
							href="admin/usuario/delete/${u.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="admin/usuario/edit">
			<input type="submit" value="Nuevo usuario" />
		</form>

	</div>
</div>
<!-- <div class="row"> -->

<%@ include file="../includes/footer.jsp"%>