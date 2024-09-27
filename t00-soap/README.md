# Taller 00 - Servicio SOAP

## Aspectos a tratar
- Revisar contrato de servicio expuesto en internet [https://apps.learnwebservices.com/services/hello?WSDL](https://apps.learnwebservices.com/services/hello?WSDL)
- Revisar componente `client-cli`
  - Referencia hacia el contrato
  - Generación de clases proxy
  - Probar cliente, ejecutando la clase `ClientCliApplication`
- Revisar componente `hello-ws`
  - Referencia y generación de clases similares
  - Implementación nueva del servicio (clase `HelloEndpointWS`)
  - Configuración de servlet para la gestión de servicios web SOAP
  - Publicación del servicio
- Volver a probar el cliente, actualizando la propiedad `hello-service.url` con el valor `http://localhost:8000/hello-ws/hello`. (Archivo [client-cli/.../application.properties](./client-cli/src/main/resources/application.properties)) 
