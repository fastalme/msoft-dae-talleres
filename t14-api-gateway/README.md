# Taller 14 - Spring Cloud Gateway
## Guía

- Copiar la carpeta de este directorio llamada `ms` a la carpeta ***home*** de usuario de sistema
- Levantar `discovery-server`
- Levantar `config-server`
- Levantar `irs-ms`
- Levantar `customer-ms`
- Levantar `api-gateway`
- Para esquema Estático con reescritura de path
  - En el archivo [api-gateway.properties](./ms/config-repo/api-gateway.properties) del repositorio de configuraciones
    - Comentar las propiedades debajo del comentario `Estatico`
    - Habilitar las propiedades debajo del comentario `Estatico con reescritura de path`
  - Reiniciar `api-gateway`
- Para esquema Dinámico explicito
    - En el archivo [api-gateway.properties](./ms/config-repo/api-gateway.properties) del repositorio de configuraciones
        - Comentar las propiedades debajo del comentario `Estatico con reescritura de path`
        - Habilitar las propiedades debajo del comentario `Dinamico explicito`
    - Reiniciar `api-gateway`
    - En el archivo [customer-ms.properties](./ms/config-repo/customer-ms.properties) del repositorio de configuraciones
        - Cambiar el valor de `server-port` por `0`
    - Reiniciar `customer-ms`
    - En el proyecto `customer-ms` configurar `Allow multiple instances`
    - Iniciar nuevas instancias de `customer-ms`
- Para esquema Dinámico por locator
    - En el archivo [api-gateway.properties](./ms/config-repo/api-gateway.properties) del repositorio de configuraciones
        - Comentar las propiedades debajo del comentario `Dinamico explicito`
        - Habilitar las propiedades debajo del comentario `Dinamico por locator`
    - Reiniciar `api-gateway`

## Aspectos a tratar
- Tecnologías utilizadas
- Esquema estático
- Esquema estático con reescritura de path
- Esquema dinámico explícito
- Esquema dinámico por locator
- ¿Cuál nos serviría más en una aplicación a gran escala?

[Spring Cloud Gateway Docs](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html)