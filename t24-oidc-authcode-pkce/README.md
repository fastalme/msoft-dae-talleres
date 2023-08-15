# Taller 24 - OIDC Authorization Code with PKCE
## Guía

- Levantar una instancia local de Keycloak: `docker run -p 9100:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.1 start-dev`
- Importar el realm del taller en la instancia de Keycloak
  - Acceder desde un browser a [http://localhost:9100/](http://localhost:9100/)
  - Dar clic en `Administration Console`
  - Ingresar con las credenciales: username:`admin`/password`admin`
  - En el combo de selección que dice `master`, seleccionar `Create Realm`
  - Arrastrar y soltar el archivo [realm/t24-oidc-authcode-pkce-realm.json](realm/t24-oidc-authcode-pkce-realm.json) en el área de `Resource File`
  - Dar clic en `Create`
- Ejecutar la clase `CustomerMsApplication`
- Levantar el frontend
  - Desde la terminal, acceder a la carpeta `app`
  - Ejecutar el comando: `npm install`
    - Si `npm` no está instalado, instalarlo con alguna de [estas alternativas](https://nodejs.org/en/download/package-manager). [Más información](https://nodejs.org/en/download)
  - Ejecutar el comando: `ng serve`
    - Si `ng` no está instalado, instalarlo ejecutando:  `npm install -g @angular/cli`. [Más información](https://angular.io/guide/setup-local)
  - Abrir en el explorador: [http://localhost:4200](http://localhost:4200)

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas
- Keycloak como Identity Provider
  - Configuración de `clients` y `client scopes`-
    - Client: `client-app`
      - Client scope: `customers:manage`
    - Client: `customer-ms`
      - Roles: `customer-basic-reader`, `customer-advanced-reader`
    - User: `basic-user` (Password: `password`) con permisos **básicos** de lectura
      - Rol asignado: `customer-basic-reader`
    - User: `advanced-user` (Password: `password`) con permisos **avanzados** de lectura
      - Roles asignados: `customer-basic-reader`, `customer-advanced-reader`
- Mapeo de token JWT
  - Revisarlo en https://jwt.io/
- Validación de permisos a través de `client scopes` y `roles`
- Debug de `Authorization Code with PKCE Flow` desde el browser
