# Taller 15 - Spring Cloud Sleuth
## Guía

- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar `customer-ms`
- Levantar `api-gateway`
- Levantar vía Docker una instancia de `jaeger jaegertracing/all-in-one:1.36`
  - La primera vez: `docker run -d -p 9411:9411 -p 16686:16686 -e COLLECTOR_ZIPKIN_HOST_PORT=9411  --name jaeger jaegertracing/all-in-one:1.47`
  - Posteriormente: `docker stop jaeger`, `docker start jaeger`, etc.

## Aspectos a tratar
- Tecnologías utilizadas
- Capacidades que agrega `Sleuth` a los ms
- Capacidades que agrega `Zipkin Client` a los ms
- Revisar en el browser: `http://localhost:16686/`

[Spring Cloud Sleuth](https://docs.spring.io/spring-cloud-sleuth/docs/3.1.3/reference/html/)