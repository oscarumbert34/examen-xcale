# examen-xcale

La aplicacion quedo actualmente corriendo con H2 una base en memoria donde guarda en un archivo todos los registros
para acceder a la base hay que entrar a este link http://localhost:8080/h2-console con las siguientes credenciales
usuario:root
password:secret
Como alternativa se puede comentar la configuracion para H2 en el archivo aplication.properties y descomentar las de MySql para que se conecte
a una base MySql
En caso de hacerlo previamente se debe crear la base y poner la url de la misma en el archivo aplication.properties 
en la propertie spring.datasource.url