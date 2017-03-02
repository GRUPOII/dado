<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${afortunado!=null}">
	<h2> El afortunado es : ${afortunado}</h2>
</c:if>


<a href="lanzar"><img src="http://www.gifsanimados.org/data/media/710/dado-imagen-animada-0092.gif" alt="Dado de seis caras"/></a>


</body>
</html>
