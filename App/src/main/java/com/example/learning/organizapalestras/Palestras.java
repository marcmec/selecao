package com.example.learning.organizapalestras;

public class Palestras {

    private String curso;
    private int hora;

    public int getHora() {
            return hora;
        }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Palestras(String curso){
        this.curso=curso;

    }

    @Override
    public String toString() {
        return  curso;
    }
}
