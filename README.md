# Ejercicios 25 - Práctica JAVA

Proyecto Maven (Java 17, sin dependencias externas) con los 25 ejercicios.

## Abrir en NetBeans
File > Open Project > seleccionar la carpeta `ejercicios25java`.

- **Run Project (F6)**: lanza `com.practicajava.MainMenu`, un menú para elegir el ejercicio 1-25.
- **Ejecutar un ejercicio suelto**: clic derecho sobre `com.practicajava.ejercicioNN/Main.java` > *Run File* (Mayús+F6).

## Temas
| Ejercicios | Tema |
|---|---|
| 1-5 | Cajero Automático |
| 6-10 | Registro Académico |
| 11-15 | Tienda Online |
| 16-20 | Agenda de Contactos |
| 21-25 | Sistema de Notas con Curva |

Los ejercicios 9 y 20 crean `reporte_curso.txt` y `agenda.txt` en la carpeta de ejecución (en NetBeans, la raíz del proyecto).

## Línea de comandos
```
mvn compile
java -cp target/classes com.practicajava.MainMenu        # menú
java -cp target/classes com.practicajava.MainMenu 7      # ejecuta directamente el ejercicio 7
```
