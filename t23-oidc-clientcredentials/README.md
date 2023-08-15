# Taller 23 - OIDC Client Credentials
## Guía

- Levantar una instancia local de Keycloak: `docker run -p 9100:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.1 start-dev`
- Importar el realm del taller en la instancia de Keycloak
  - Acceder desde un browser a [http://localhost:9100/](http://localhost:9100/)
  - Dar clic en `Administration Console`
  - Ingresar con las credenciales: username:`admin`/password`admin`
  - En el combo de selección que dice `master`, seleccionar `Create Realm`
  - Arrastrar y soltar el archivo [realm/t23-oidc-cc-realm.json](realm/t23-oidc-cc-realm.json) en el área de `Resource File`
  - Dar clic en `Create`
- Ejecutar la clase `CustomerMsApplication`

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas
- Keycloak como Identity Provider
  - Configuración de `clients` y `client scopes`
    - Client: `customer-report-app` con permisos de lectura
      - Client scope: `customers:read`
    - Client: `customer-admin-app` con permisos de escritura
      - Client scopes: `customers:read`, `customers:write`
- Mapeo de token JWT
  - Revisarlo en https://jwt.io/
- Validación de permisos a través de `client scopes` 