# Taller 15 - Spring Cloud Sleuth
## Guía

- Copiar el proyecto de `customer-ms`
- Copiar el proyecto de `irs-ms`
- Copiar el proyecto de `config-server`
- Copiar el proyecto de `discovery-server`
- Copiar el proyecto de `api-gateway`
- Levantar vía Docker una instancia de `jaeger jaegertracing/all-in-one:1.36`
  - `docker run -d -p 9411:9411 -p 16686:16686 -e COLLECTOR_ZIPKIN_HOST_PORT=9411  --name jaeger jaegertracing/all-in-one:1.36`
- Agregar dependencia de `Spring Cloud Sleuth` en los componentes: `api-gateway`, `customer-ms` y `irs-ms`
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar `customer-ms`
- Levantar y comprobar acceso desde `api-gateway`

## Aspectos a tratar
- Tecnologías utilizadas
- Capacidades que agrega `Sleuth` a los ms
- Capacidades que agrega `Zipkin Client` a los ms
- Consulta de trazabilidad distribuida desde el explorador

[Spring Cloud Sleuth](https://docs.spring.io/spring-cloud-sleuth/docs/3.1.3/reference/html/)