# Taller 13 - Spring Cloud Load Balanceer
## Guía

- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar `customer-ms`
- Para esquema Random
  - En el archivo `customer-ms/src/main/resources/application.properties`
    - Habilitar la propiedad `spring.profiles.active` debajo del comentario `Random`
  - Reiniciar `customer-ms`

## Aspectos a tratar
- Revisar los principales tecnologías utilizadas
- OpenFeign como mecanismo para generar clientes REST
- Guardar 1 nuevo cliente desde `customer-ms`
- Consultar `full-history` del cliente desde `customer-ms`
- Aumentar las instancias de `irs-ms` 
  - Editar las configuraciones de ejecución `Edit Configurations`
  - Seleccionar `IrsMsApplication`, `Modify options`, habilitar `Allow multiple instances`
  - Ahora se pueden arrancar varias instancias desde el IDE
- Comprobar Round Robin desde `customer-ms` chequeando el valor de `sourcePID` en cada request
- Comprobar Random desde `customer-ms` chequeando el valor de `sourcePID` en cada request

[Spring Cloud Load Balancer Docs](https://docs.spring.io/spring-cloud-commons/docs/3.1.3/reference/html/#spring-cloud-loadbalancer)
[Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/3.1.3/reference/html/#netflix-feign-starter)