# Taller 13 - Spring Cloud Load Balanceer
## Guía

- Editar el archivo [./config-server/src/main/resources/application.properties](./config-server/src/main/resources/application.properties)
  - Habilitar la línea de la propiedad `spring.cloud.config.server.native.search-locations` conforme corresponda de acuerdo al sistema operativo.
- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar `customer-ms`
- Para esquema Random
  - En el archivo [./customer-ms/src/main/resources/application.properties](./customer-ms/src/main/resources/application.properties)
    - Habilitar la propiedad `spring.profiles.active` debajo del comentario `Random`
  - Reiniciar `customer-ms`

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas
- OpenFeign como mecanismo para generar clientes REST
- Guardar 1 nuevo cliente desde `customer-ms`
- Consultar `full-history` del cliente desde `customer-ms`
- Aumentar las instancias de `irs-ms` 
  - Editar las configuraciones de ejecución `Edit Configurations`
  - Seleccionar `IrsMsApplication`, `Modify options`, habilitar `Allow multiple instances`
  - Ahora se pueden arrancar varias instancias desde el IDE
- Comprobar Round Robin desde `customer-ms` chequeando el valor de `sourcePID` en cada request
- Comprobar Random desde `customer-ms` chequeando el valor de `sourcePID` en cada request

[Spring Cloud Load Balancer Docs](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer)
[Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#netflix-feign-starter)