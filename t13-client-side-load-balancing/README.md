# Taller 13 - Spring Cloud Load Balanceer
## Guía

- Copiar el proyecto de `customer-ms`
- Copiar el proyecto de `config-server`
- Copiar el proyecto de `discovery-server`
- Crear proyecto nuevo REST llamado `irs-ms` con dependencias para `Actuator`, `Config Client` y `Discovery Client`
  - Configurarlo
  - Desarrollar endpoint de prueba `getEarningsByCustomerId`
- En el proyecto `customer-ms`
  - Agregar dependencias de `Open Feign` y `Spring Cloud Load Balancer`
  - Desarrollar nuevo método `getCustomerFullHistory` que consuma el servicio previamente creado en `client-ms`
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar y comprobar desde `customer-ms` 

## Aspectos a tratar
- Revisar los principales tecnologías utilizadas
- OpenFeign como mecanismo para generar clientes REST
- Comprobar Round Robin

[Spring Cloud Load Balancer Docs](https://docs.spring.io/spring-cloud-commons/docs/3.1.3/reference/html/#spring-cloud-loadbalancer)
[Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/3.1.3/reference/html/#netflix-feign-starter)