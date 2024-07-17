package com.juanskpc.libreria.principal;

import com.juanskpc.libreria.model.DatosLibro;
import com.juanskpc.libreria.model.Libro;
import com.juanskpc.libreria.repositorio.LibroRepository;
import com.juanskpc.libreria.service.ConsumoAPI;
import com.juanskpc.libreria.service.ConvierteDatos;

import java.net.URL;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumoApi = new ConsumoAPI();
    private LibroRepository repositorio;
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    Scanner teclado = new Scanner(System.in);

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void mostrarMenu(){
        var opcion = -1;

        while(opcion != 0){
            var menu = """
                        1 - Buscar libro por titulo
                        2 - Listar libros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos por año
                        5 - Listar libros por idioma
                        0 - Salir
                    """;

            System.out.println(menu);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroTitulo();
                    break;
                /*case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresPorAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;*/
                case 0:
                    System.out.println("Gracias por usar la aplicación.... :)");
                default:
                    System.out.println("Opción no valida");
            }
        }
    } // Fin mostrar menu

    private void buscarLibroTitulo(){
        DatosLibro datos = getDatosLibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        System.out.println(datos);
    }// Fin buscarLibroTitulo

    private DatosLibro getDatosLibro(){
        System.out.println("Escribe el nombre del libro a buscar: ");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+"));
        System.out.println(json);

        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }


}
