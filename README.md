# Task Application

Esta aplicación Android permite la gestión de tareas mediante operaciones CRUD (crear, leer, actualizar y eliminar).

## Instrucciones de instalación y ejecución

1. Clonar o descargar el repositorio del proyecto.
2. Abrir el proyecto en Android Studio.
3. Compilar el proyecto y ejecutarlo en: Un emulador Android, o un dispositivo físico.
4. Al iniciar la aplicación se mostrará la lista de tareas disponibles.
5. Desde la interfaz principal se puede:
   - Agregar nuevas tareas.
   - Editar o eliminar tareas existentes.

## Estructura de la base de datos

La aplicación utiliza SQLite y está compuesta por las siguientes tablas:

### Tabla: `task`

 task_id          INTEGER  Clave primaria autoincremental     
 
 task_title       TEXT     Título de la tarea     
 
 task_description TEXT     Descripción de la tarea    
 
 created_at       INTEGER  Fecha de creación 
 
 is_completed     BOOLEAN  Estado de la tarea

## Capturas de pantalla de la interfaz
<img width="265" height="587" alt="PantallaDeInicio" src="https://github.com/user-attachments/assets/72428d64-b106-40f4-bff9-00f77ac57b8b" />
<img width="265" height="588" alt="PantallaAgregarTarea" src="https://github.com/user-attachments/assets/0b1b2c60-13c7-4a11-b62d-878ccff955db" />
<img width="264" height="589" alt="PantallaEditar" src="https://github.com/user-attachments/assets/c77b0b6f-5d98-4d35-9ce8-e14a62cacf19" />



