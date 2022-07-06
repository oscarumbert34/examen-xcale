# examen-xcale

#Config

La aplicacion quedo actualmente corriendo con H2 una base en memoria donde guarda en un archivo todos los registros
para acceder a la base hay que entrar a este link http://localhost:8080/h2-console con las siguientes credenciales
usuario:root
password:secret
Como alternativa se puede comentar la configuracion para H2 en el archivo aplication.properties y descomentar las de MySql para que se conecte
a una base MySql
En caso de hacerlo previamente se debe crear la base y poner la url de la misma en el archivo aplication.properties 
en la propertie spring.datasource.url

#Uso

Cuando se levanta la app se agrego una clase SimulateWhatsAppService que ejecutara un chat, se podra ver en la consola los mensajes
Tambien se habilita los enpoints para simular

		localhost:5000/whatsapp/simulate
		curl:
			curl --location --request POST 'localhost:5000/whatsapp/simulate'
			
		Para crear un grupo:
		
			curl caso feliz;
				curl --location --request POST 'localhost:5000/whatsapp/group' \
				--header 'Content-Type: application/json' \
				--data-raw '{
					"name":"Amigos",
					"contacts":[{
						"name":"fs",
						"mobilPhone":"4234234"
					}]
				}'
				
			curl caso numero de contacto mal ingresado debe ser un numero:
				curl --location --request POST 'localhost:5000/whatsapp/group' \
				--header 'Content-Type: application/json' \
				--data-raw '{
					"name":"fdfsdsd",
					"contacts":[{
						"name":"erwerwer",
						"mobilPhone":"fhgfhjgf"
					}]
				}'
			
Si no se entiende mucho la parte de los curls quedaron adjuntados la collecion con los dos curls.
