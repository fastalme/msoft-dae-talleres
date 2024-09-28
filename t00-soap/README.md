# Taller 00 - Servicio SOAP

## Aspectos a tratar
- Revisar contrato de servicio expuesto en internet [https://apps.learnwebservices.com/services/hello?WSDL](https://apps.learnwebservices.com/services/hello?WSDL)
- Revisar componente `client-cli`
  - Referencia hacia el contrato
  - Generación de clases proxy
  - Probar cliente, ejecutando la clase `ClientCliApplication`
- Revisar componente `greeetings-cli`
  - Referencia hacia el contrato
  - Probar cliente, ejecutando el script `main.py`
- Revisar componente `hello-ws`
  - Referencia y generación de clases similares
  - Implementación nueva del servicio (clase `HelloEndpointWS`)
  - Configuración de servlet para la gestión de servicios web SOAP
  - Publicación del servicio
- Volver a probar los clientes, actualizando la nueva URL del servicio (`http://localhost:8000/hello-ws/hello`) en:
  - La propiedad `hello-service.url` del archivo [client-cli/.../application.properties](./client-cli/src/main/resources/application.properties))
  - El script [greetings-cli/main.py](./greetings-cli/main.py)
