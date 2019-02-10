## Mr Jeff Test

### Código

Subí el código a github en el siguiente enlace --> https://github.com/andreablp/mrjefftest.git

### Arranque

He añadido el plugin docker-maven-plugin de modo que con el siguiente comando, crea la imagen de docker con el nombre del proyecto y la versión como tag, además de con el tag latest.

``` shellscript
mvn clean package docker:build -DskipTests
```
```shellscript
docker-compose up -d
```
Esto debería levantar todo sin problemas.

He añadido las implementaciones básicas necesarias junto con tests unitarios e integración rest.

He tenido muchos problemas con docker creo que debido a que hace poco me hicieron una clonación del disco y ha estado dando problemas desde entonces. Lo he tenido que ejecutar con otro pc que me han prestado y lo he podido ejecutar bien, si tenéis algún problema por favor, decidmelo e intentaré solucionarlo.

Si se levanta correctamente, accediendo a -->  *localhost:8080/swagger-ui.html* <-- podréis probar facilmente la llamada al API.

No he metido ningún script en docker-entrypoint-initdb.d con lo que la base de datos se inicializa limpia, asi que a no se que se le inserte un cupón, no va a encontrar ninguno en ningún caso.