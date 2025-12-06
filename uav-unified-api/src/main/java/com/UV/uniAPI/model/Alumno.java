package com.UV.uniAPI.model;

public class Alumno {

    private String matricula;
    private String nombre;
    private String programa;

    public Alumno() {
    }

    public Alumno(String matricula, String nombre, String programa) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.programa = programa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
