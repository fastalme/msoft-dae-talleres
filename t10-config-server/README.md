# Taller 10 - Spring Cloud Config Server
## Guía

- Editar el archivo [./config-server/src/main/resources/application.properties](./config-server/src/main/resources/application.properties)
  - Habilitar la línea de la propiedad `spring.cloud.config.server.native.search-locations` conforme corresponda de acuerdo al sistema operativo.
- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema 
- Levantar `config-server`
- Levantar `customer-ms`

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas

[Config Server Docs](https://docs.spring.io/spring-cloud-config/docs/3.1.3/reference/html/)
[Config refresh strategies](https://soshace.com/spring-cloud-config-refresh-strategies/)