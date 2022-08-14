# Taller 20 - MTLS

## Guía

### 1. Probar con server Spring

- Crear keystore del servidor en formato P12
  - Abrir una consola, ubicarse en el directorio `openssl-ca/req-restapi` 
  - Ejecutar: `openssl pkcs12 -export -inkey restapi.key -in restapi.crt -out restapi-keystore.p12`
  - Copiar el archivo `restclient-keystore.p12` en el directorio `customer-ms/src/main/resources`
- Copiar truststore en formato JKS al proyecto servidor 
  - Copiar el archivo `truststore.jks` generado en el taller anterior en el directorio `customer-ms/src/main/resources`
- Levantar `customer-ms`  
- Ejecutar la clase `ClientMtlsApplication`

## Aspectos a tratar
- En proyecto `customer-ms`
  - Headers nuevos
  - Dockerfile
- Docker compose
- En proyecto `client-mtls`
  - Archivos `keystore.p12` y `truststore.jks`
  - Clases `CustomerClientConfiguration` y `CustomerPrinterRunner`
