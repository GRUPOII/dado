#Proyecto dado

Proyecto Web 2.5 desarrollado con Java6 y Spring 3.
Multidioma para Castellano, Euskera e Ingles

![Alt text](documentacion/screenshot.png?raw=true 'pantallazo de ranking dado')

##Requisitos

	Es necesario tener instalado el siguiente entorno para poder ejecutar la App
		-Java JDK 6 o superior
		-SGBD:MySQL 5.0.8 o superior
		-Servidor Aplicaciones Tomcat6 o superior
		

##instalacion:

	Si se desea cambiar las credenciales de la base de datos, modificar el fichero \src\main\resources\database.properties
	
	-importar script de la carpeta deploy/install-dado-eq2.sql
	-Desplegar deploy/dado-eq2.war en Tomcat
	-Acceder mediante navegador a url: "localhost:8080/dado-eq2"