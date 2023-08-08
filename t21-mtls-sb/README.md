# Taller 21 - MTLS with Spring Boot

## Guía

### 1. Probar con server Spring

- Crear keystore del servidor en formato P12
  - Abrir una consola, ubicarse en el directorio `openssl-ca/req-restapi` 
  - Ejecutar: `openssl pkcs12 -export -inkey restapi.key -in restapi.crt -out restapi-keystore.p12`
  - Copiar el archivo `restapi-keystore.p12` en el directorio `customer-ms/src/main/resources`
- Copiar truststore en formato JKS al proyecto servidor 
  - Copiar el archivo `truststore.jks` generado en el taller anterior en el directorio `customer-ms/src/main/resources`
- Levantar `customer-ms`
- Copiar el archivo `openssl-ca/req-restclient/restclient-keystore.p12` en el directorio `client-mtls/src/main/resources`, reemplazando de ser necesario.
- Copiar el archivo `openssl-ca/truststore.jks` en el directorio `client-mtls/src/main/resources`, reemplazando de ser necesario.
- Ejecutar la clase `ClientMtlsApplication`

## Aspectos a tratar
- En proyecto `customer-ms`
  - Configuraciones en `application.properties`
  - Clase `SecurityConfig`
  - Inyección de usuario validado en el controlador `CustomerController`

