package com.juanskpc.libreria.model;

public class Autor {
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioFallecimiento;

    public Autor (DatosAutor autor){
        this.nombre = autor.nombre;
        this.anioNacimiento = autor.anioNacimiento();
        this.anioFallecimiento = autor.anioFallecimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }
}
