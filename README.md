# LiterAlura
# Proyecto de búsqueda, registro de libros y autores

Este proyecto es una aplicación Java para la búsqueda de libros mediante la API gutendex.com y la gestión de un registro local de libros y autores. 
Los usuarios pueden interactuar con la aplicación a través de un menú en la consola para buscar libro por titulo, lista de libros registrado, lista autores registrados, Lista de autores vivos en un año especifico y lista de libros por idioma.

## Funcionalidades

El menú principal de la aplicación ofrece las siguientes opciones:

1. **Buscar libro por titulo o palabra clave que lo identifique**: Permite al usuario buscar un libro introduciendo el título o palabra clave. La búsqueda se realiza mediante la API en línea `https://gutendex.com/books/`.
2. **Listar libros registrados**: Muestra todos los libros que han sido registrados en la base de datos local.
3. **Listar autores registrados**: Muestra todos los autores que han sido registrados en la base de datos local.
4. **Lista de autores vivos en un año especifico**: Filtra y realiza una lista de los autores que están vivos según un año específico.
5. **Lista de libros por idioma**: Permite al usuario mostrar una lista libros filtrándolos por idiomas específicos.
0. **Salir**: Cierra la aplicación.

## Requisitos

- **Java 17 o superior**
- **Maven** (para gestionar dependencias)
- **Internet** (para realizar búsquedas de libros en línea a través de la API)
- **Acceso a la API** de Gutendex (`https://gutendex.com/books/?search=`)
- **PostgreSQL**(almacenamiento de listas de datos)
