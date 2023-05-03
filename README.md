
# LudoFun ✏️

Este proyecto se basa en el complemento **DataNucleus** y  **Maven**. Compruebe la configuración de la base de datos en el archivo *datanucleus.properties* y la dependencia del controlador JDBC especificada en el archivo *pom.xml*. Además, el proyecto contiene los códigos de ejemplo de servidor y cliente.
## Test 🧪

## Ejecución 🤖

Ejecute el siguiente comando para compilar todo y mejorar las clases de base de datos:

	mvn clean
   > Elimina los archivos y carpetas generados por una compilación previa de un proyecto Maven.
	
	mvn compile
 > Compilar el código fuente de un proyecto Maven.
 
Asegúrese de que la base de datos se haya configurado correctamente. Use el contenido del archivo *create-message.sql* para crear la base de datos y otorgar privilegios. Por ejemplo,

	mysql –uroot -p < sql/create-ludofunDB.sql

Ejecute el siguiente comando para crear un esquema de base de datos para esta muestra.

	mvn datanucleus:schema-create
	
Ejecute el siguiente comando para realizar el enhance de base de datos para esta muestra.

	mvn datanucleus:enhance

Para iniciar el servidor, ejecute el comando

	mvn jetty:run
 > A partir de ahora, el "enhance" queda separado del "compile"

Ahora, el código de muestra del cliente se puede ejecutar en una nueva ventana de comandos con

	mvn exec:java -Pclient
