# Task-Manager

Software de gestión de tareas desarrollado como challenge para Coopeuch. Las tecnologías usadas son: ReactJS, Redux, Spring Boot, PostgreSQL, JPA, y Hibernate.

## Modulos

1. Rest API´s <task-manager-ws>

2. Task Manager UI <task-manager-ui>
  
## Requerimientos

1. Java - 1.8.x +

2. Maven - 3.x.x +

3. PostgreSQL 9.x +

## Pasos para Configurar

**1. Clonar la Aplicación

```bash
git clone https://github.com/gzendev/task-manager.git
```

**2. Crear PostgreSQL database

```bash
run create.sql
```

**3. Cambiar PostgreSQL username y password de acuerdo a tu instalación y entorno

+ open `src/main/resources/application-*.yml`

+ change `spring.datasource.username` , `spring.datasource.password` 

**4. Construir y correr la app usando Maven 

```bash
mvn package
java -jar task-manager-ws/target/task-manager-ws.jar

```
Alternativamente, también podés correr la app usando,

```bash
mvn spring-boot:run
```

La app comenzará a correr en <http://localhost:8080>


## Explorar Rest APIs

La app define los siguientes EndPoints. Ver en <http://localhost:8080/swagger-ui/>
   

