# Taller 30 - Kubernetes
## Guía

### En Docker Hub
- Crear cuenta gratuita (En el ejemplo: `fastalme`)
- Crear repositorios públicos: `irs-ms` y `customer-ms`
- Iniciar sesión en Docker Desktop con sus nuevas credenciales (`Sign in`)
  - Luego de este proceso, el ícono de Docker Desktop debería actualizarce, indicando que hemos iniciado sesión correctamente
  - Si esto no ocurre, realizar los siguientes pasos:
    - En la terminal ejecutar `docker login -u <usuario>`
    - La terminal solicitará ingresar la contraseña
    - Luego de ingresarla y aceptar, deberiamos ver el mensaje `Login Succeeded`

**En cada uno de los ejemplos y archivos siguientes, reemplazar `fastalme` por el nombre de la cuenta creada.** 

### Servicio de Customer
- Entrar a la carpeta `customer-ms`
- Armar paquete `./mvnw clean package`
- Crear imagen `docker build . -t fastalme/customer-ms:0.0.1-SNAPSHOT`
  - Revisar: `docker image list`
- Levantar contenedor `docker run -p 8080:8080 --name customer fastalme/customer-ms:0.0.1-SNAPSHOT`
  - Revisar con request vía Postman
- Publicar imagen en Docker Hub `docker push fastalme/customer-ms:0.0.1-SNAPSHOT`

### Servicio de IRS
- Entrar a la carpeta `irs-ms`
- Armar paquete `./mvnw clean package`
- Crear imagen `docker build . -t fastalme/irs-ms:0.0.1-SNAPSHOT`
  - Revisar: `docker image list`
- Levantar contenedor `docker run -p 8090:8080 --name irs fastalme/irs-ms:0.0.1-SNAPSHOT`
  - Revisar con request vía Postman
- Publicar imagen en Docker Hub `docker push fastalme/irs-ms:0.0.1-SNAPSHOT`

### Kubernetes (kubectl + Lens)
- Entrar a la carpeta `k8s`
- Desde Docker Desktop habilitar Kubernetes:
  - Settings -> Kubernetes -> Check `Enable Kubernetes` -> Apply & restart
- Revisar contextos configurados `kubectl config get-contexts`
- Seleccionar contexto de docker-desktop: `kubectl config use-context docker-desktop`
- Presentar namespaces existentes `kubectl get ns`
- Crear namespace del taller `kubectl apply -f namespace.yaml`
- Establecer el nuevo namespace por defecto `kubectl config set-context --current --namespace=t30-k8s`
- Presentar config maps existentes `kubectl get cm`
- Crear config map para customer-ms `kubectl apply -f configmap.yaml`
- Presentar deployments existentes `kubectl get deploy`
- Crear los deployments para customer-ms y irs-ms `kubectl apply -f deployment.yaml`
- Presentar services existentes `kubectl get svc`
- Crear los services para customer-ms y irs-ms `kubectl apply -f service.yaml`

## Aspectos a tratar
- Tecnologías utilizadas
- Docker
  - Imágenes
  - Contenedores
  - Registros (Docker, DockerHub, Kubernetes)
- Kubernetes
  - Mapas de configuraciones
  - Descubrimiento
  - Balanceo de Carga
  - Estado esperado
  - Actualizaciones
- Diferencias entre Kubernetes & Spring Cloud: Menos código de infraestructura dentro de la aplicación.
