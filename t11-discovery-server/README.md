# Taller 11 - Spring Cloud Netflix Eureka Server
## Guía

- Editar el archivo [./config-server/src/main/resources/application.properties](./config-server/src/main/resources/application.properties)
  - Habilitar la línea de la propiedad `spring.cloud.config.server.native.search-locations` conforme corresponda de acuerdo al sistema operativo.
- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema
- Para esquema ConfigFirst
  - Levantar `config-server`
  - Levantar `discovery-server`
  - Levantar `customer-ms`
- Para esquema DisConfig 
  - Levantar `disconfig-server`
  - En el archivo `customer-ms/src/main/resources/application.properties`
    - Comentar las propiedades `spring.profiles.active` y `spring.config.import` debajo del comentario `ConfigFirst`
    - Habilitar las propiedades `spring.profiles.active` y `spring.config.import` debajo del comentario `Disconfig`
  - Levantar `customer-ms`

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas
- Esquema Config First (análisis)
  - Revisar en el browser: `http://localhost:8100/`
- Esquema Disconfig: Discovery y Config en el mismo componente (alternativa, no muy recomendada en Producción)
  - Revisar en el browser: `http://localhost:8200/`
- Esquema Discovery First (ver taller12)

[Eureka Server Docs](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/)
