<%@ include file="includes/header.jsp"%>


<div class="row">
	<div class="col-md-4">
		<h2>Ranking</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Pos.</th>
					<th>Nombre</th>
					<th>Apariciones</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="u">
					<tr>
						<c:if test="${usuarios.size() > 0}">
							<td>${usuarios.lastIndexOf(u)+1}</td>
							<td>${u.nombre}</td>
							<td>${u.tiradas}</td>
						</c:if>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<div class="col-md-8">
		<a href="lanzar"><img
			src="http://www.gifsanimados.org/data/media/710/dado-imagen-animada-0092.gif"
			alt="Dado de seis caras" /></a> <br>

		<c:if test="${afortunado!=null}">
			<h3>El afortunado es : ${afortunado}</h3>
		</c:if>
	</div>
</div>


<%@ include file="includes/footer.jsp"%>
