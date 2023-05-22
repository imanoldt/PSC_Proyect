
# LudoFun ✏️
LudoFun es una ludoteca donde vas a poder alquilar o comprar los distintos libros en base a tus gustos mas preciado. Asi mismo, podras devolver o incluso generar el ticket de compra.

## Test 🧪
Para realizar los test ejecute el siguiente comando:

	mvn test

## Ejecución 🤖

Ejecute el siguiente comando para compilar todo y mejorar las clases de base de datos:

	mvn clean
	
   > Elimina los archivos y carpetas generados por una compilación previa de un proyecto Maven.
	
	mvn compile
	
 > Compilar el código fuente de un proyecto Maven.
 
Asegúrese de que la base de datos se haya configurado correctamente. Use el contenido del archivo *create-message.sql* para crear la base de datos y otorgar privilegios. Por ejemplo,

	mysql –uroot -p < sql/create-ludofunDB.sql

Ejecute el siguiente comando para crear el enhance de base de datos para esta muestra.

	mvn datanucleus:enhance
	
Ejecute el siguiente comando para realizar el esquema de base de datos para esta muestra.

	mvn datanucleus:schema-create

Para iniciar el servidor, ejecute el comando

	mvn jetty:run
	
 > A partir de ahora, el "enhance" queda separado del "compile"

Ahora, el código de muestra del cliente se puede ejecutar en una nueva ventana de comandos con

	mvn exec:java -Pclient
