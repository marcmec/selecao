package com.example.learning.organizapalestras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    public List<Palestras> listCursos;
    private List<Palestras> listPalestrasTrackAmanha;
    private List<Palestras> listPalestrasTrackAtarde;
    private List<Palestras> listPalestrasTrackBmanha;
    private List<Palestras> listPalestrasTrackBtarde;
    private ArrayAdapter<Palestras> adapter;
    private ArrayAdapter<Palestras> adapter1;
    private int trackamanha=0;
    private int trackatarde=0;
    private int trackbmanha=0;
    private int trackbtarde=0;
    private boolean eu=true;
    private Button btn;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idlist);
        btn= findViewById(R.id.btn);
        txt= findViewById(R.id.track);
        txt.setText("TRACK A");


        listPalestrasTrackAmanha= new ArrayList<>();
        listPalestrasTrackAtarde= new ArrayList<>();

        listPalestrasTrackBmanha= new ArrayList<>();
        listPalestrasTrackBtarde= new ArrayList<>();
        listCursos= new ArrayList<>();
        listCursos.add(new Palestras("Diminuindo tempo de execução de testes em aplicações Rails enterprise",60));
        listCursos.add(new Palestras("Reinventando a roda em ASP clássico",45));
        listCursos.add(new Palestras("Apresentando Lua para as massas",30));
        listCursos.add(new Palestras("Erros de Ruby oriundos de versões erradas de gems",45));
        listCursos.add(new Palestras("Erros comuns em Ruby ",45));
        listCursos.add(new Palestras("Rails para usuários de Django lightning",30));
        listCursos.add(new Palestras("Trabalho remoto: prós e cons",60));
        listCursos.add(new Palestras("Desenvolvimento orientado a gambiarras",45));
        listCursos.add(new Palestras("Aplicações isomórficas: o futuro (que talvez nunca chegaremos) ",30));
        listCursos.add(new Palestras("Codifique menos, Escreva mais! ",45));
        listCursos.add(new Palestras("Programação em par",45));
        listCursos.add(new Palestras("A mágica do Rails: como ser mais produtivo",60));
        listCursos.add(new Palestras("Ruby on Rails: Por que devemos deixá-lo para trás",60));
        listCursos.add(new Palestras("Clojure engoliu Scala: migrando minha aplicação",45));
        listCursos.add(new Palestras("Ensinando programação nas grotas de Maceió",30));
        listCursos.add(new Palestras("Ruby vs. Clojure para desenvolvimento backend",30));
        listCursos.add(new Palestras("Manutenção de aplicações legadas em Ruby on Rails",60));
        listCursos.add(new Palestras("Um mundo sem StackOverflow ",30));
        listCursos.add(new Palestras("Otimizando CSS em aplicações Rails", 30));

        //track A- Manha
        for (int i=0; i < listCursos.size(); i++) {
            trackamanha+= listCursos.get(i).getHora();
            if(trackamanha>180){
                trackamanha-= listCursos.get(i).getHora();
            }else{
                listPalestrasTrackAmanha.add(listCursos.get(i));
            }
        }
        for(int i=0; i<listCursos.size(); i++){

            for(int j=0; j<listPalestrasTrackAmanha.size();j++){

                if(listCursos.get(i).equals(listPalestrasTrackAmanha.get(j))){
                    listCursos.remove(listCursos.get(i));
                }
            }
        }
//track A tarde
        for (int i=0; i < listCursos.size(); i++) {
            trackatarde+= listCursos.get(i).getHora();
            if(trackatarde>240){
                trackatarde-= listCursos.get(i).getHora();
            }else{
                listPalestrasTrackAtarde.add(listCursos.get(i));
            }
        }
        for(int i=0; i<listCursos.size(); i++){

            for(int j=0; j<listPalestrasTrackAtarde.size();j++){

                if(listCursos.get(i).equals(listPalestrasTrackAtarde.get(j))){
                    listCursos.remove(listCursos.get(i));
                }
            }
        }

        System.out.println(listCursos);

        //Track B manha
        for (int i=0; i < listCursos.size(); i++) {
            trackbmanha+= listCursos.get(i).getHora();
            if(trackbmanha>180){
                trackbmanha-= listCursos.get(i).getHora();
            }else{
                listPalestrasTrackBmanha.add(listCursos.get(i));
            }
        }
        for(int i=0; i<listCursos.size(); i++){

            for(int j=0; j<listPalestrasTrackBmanha.size();j++){

                if(listCursos.get(i).equals(listPalestrasTrackBmanha.get(j))){
                    listCursos.remove(listCursos.get(i));
                }
            }
        }
        System.out.println(listCursos);
//track A tarde
        for (int i=0; i < listCursos.size(); i++) {
            trackbtarde+= listCursos.get(i).getHora();
            if(trackbtarde>240){
                trackatarde-= listCursos.get(i).getHora();
            }else{
                listPalestrasTrackBtarde.add(listCursos.get(i));
            }
        }
        for(int i=0; i<listCursos.size(); i++){

            for(int j=0; j<listPalestrasTrackBtarde.size();j++){

                if(listCursos.get(i).equals(listPalestrasTrackBtarde.get(j))){
                    listCursos.remove(listCursos.get(i));
                }
            }
        }
        listPalestrasTrackAmanha.addAll(listPalestrasTrackAtarde);
       adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPalestrasTrackAmanha);
        listPalestrasTrackBmanha.addAll(listPalestrasTrackBtarde);
       adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPalestrasTrackBmanha);
       listView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eu){
                listView.setAdapter(adapter1);
                    txt.setText("TRACK B");
                    eu=false;
                }else{
                    txt.setText("TRACK A");
                    listView.setAdapter(adapter);
                    eu=true;
                }
            }
        });

    }


    }



