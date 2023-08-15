# Taller 22 - JWT
## Guía

El comando utilizado para extraer la llave pública de la llave privada fue: `openssl pkey -in restapi.key -pubout -out restapi.pub`

## Aspectos a tratar
- Revisar las principales tecnologías utilizadas
- Validación de contraseña con `BCryptPasswordEncoder`
- Generación de token JWT
  - Revisarlo en https://jwt.io/
- Validación de token JWT