# Taller 31 - Observability in Kubernetes
## Guía

- Descargar agente de elastic `curl -o 'elastic-apm-agent.jar' -L 'https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=co.elastic.apm&a=elastic-apm-agent&v=LATEST'`

### En Docker Hub
- Crear cuenta gratuita (En el ejemplo: `fastalme`)
- Crear repositorios públicos: `irs-ms` y `customer-ms`

**En cada uno de los ejemplos y archivos siguientes, reemplazar `fastalme` por el nombre de la cuenta creada.** 

### Servicio de Customer
- Entrar a la carpeta `customer-ms`
- Armar paquete `./mvnw clean package`
- Volver a la carpeta raíz `cd ..`
- Crear imagen `docker build . -f customer-ms/Dockerfile -t fastalme/customer-ms:0.0.1-SNAPSHOT`
  - Revisar: `docker image list`
- Levantar contenedor `docker run -p 8080:8080 --name customer fastalme/customer-ms:0.0.1-SNAPSHOT`
  - Revisar con request vía Postman
- Publicar imagen en Docker Hub `docker push fastalme/customer-ms:0.0.1-SNAPSHOT`

### Servicio de IRS
- Entrar a la carpeta `irs-ms`
- Armar paquete `./mvnw clean package`
- Volver a la carpeta raíz `cd ..`
- Crear imagen `docker build . -f irs-ms/Dockerfile -t fastalme/irs-ms:0.0.1-SNAPSHOT`
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
- Instalar operador de ECK
  - `kubectl create -f https://download.elastic.co/downloads/eck/2.13.0/crds.yaml`
  - `kubectl apply -f https://download.elastic.co/downloads/eck/2.13.0/operator.yaml`
  - Revisar `kubectl -n elastic-system logs -f statefulset.apps/elastic-operator`
- Presentar namespaces existentes `kubectl get ns`
- Crear namespace del taller `kubectl create namespace t31-k8s-observability`
- Establecer el nuevo namespace por defecto `kubectl config set-context --current --namespace=t31-k8s-observability`
- Crear los secrets para el usuario de Kibana y el usuario del agente
  - `kubectl create secret generic eck-es-elastic-user --from-literal=elastic=elastic`
  - `kubectl create secret generic eck-apm-token --from-literal=secret-token=my-secret-token`
- Crear los elementos de ECK `kubectl apply -f eck`
- Crear los elementos aplicativos `kubectl apply -f .`

- Probar con requests a Postman
- Acceder en la interfaz de Kibana: [http://localhost:5601/app/home#/](http://localhost:5601/app/home#/)
  - Usuario: `elastic`
  - Clave: `elastic`

## Aspectos a tratar
- Tecnologías utilizadas
- ELK
  - Elasticsearch
  - Kibana
  - APM Server
    - Log sending
- Formato de logs para ECS
