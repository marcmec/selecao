package com.example.learning.organizapalestras;

public class Palestras {

    private String curso;
    private int hora;

    public int getHora() {
            return hora;
        }


    public Palestras(String curso, int hora){
        this.curso=curso;
        this.hora=hora;
    }

    @Override
    public String toString() {
        return  String.valueOf(hora)+" min-"+ " "+ curso;
    }
}
