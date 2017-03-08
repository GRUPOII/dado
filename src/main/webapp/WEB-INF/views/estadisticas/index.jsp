<%@ include file="../includes/header.jsp"%>

<h2 id="h2center">Estadisticas</h2>

<div class="row">

	<div class="col-md">
	<h2>Tiradas totales realizadas ${total}</h2>
	
	<!-- ${estadisticas} -->


<table class="table table-striped table-bordered dt-responsive nowrap"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>FECHA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${estadisticas}" var="e">
					<tr>
						<td>${e.id}</td>
						<td>${e.nombre}</td>
						<td>${e.fecha}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		
	</div>



</div>
<!-- <div class="row"> -->


<%@ include file="../includes/footer.jsp"%>