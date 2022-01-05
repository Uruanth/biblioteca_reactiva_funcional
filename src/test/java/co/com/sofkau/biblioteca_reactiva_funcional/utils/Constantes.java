package co.com.sofkau.biblioteca_reactiva_funcional.utils;

import co.com.sofkau.biblioteca_reactiva_funcional.model.Book;

import java.time.LocalDate;

public class Constantes {
    public static Book bookAvaible = new Book("idBookAvaible",
            "Quijote",
            true,
            LocalDate.parse("1992-08-02"),
            "Revista",
            "Ficcion");

    public static Book bookUnavaible = new Book("idBookUnavaible",
            "Tin Tin",
            false,
            LocalDate.parse("2020-09-15"),
            "Libro",
            "Aventura");


    public static Book bookToCreate = new Book("Spiderman",
            false,
            LocalDate.parse("2010-02-15"),
            "Comic",
            "Accion");

    public static Book bookCreated = new Book("idCreated",
            "Spiderman",
            false,
            LocalDate.parse("2010-02-15"),
            "Comic",
            "Accion");
}
