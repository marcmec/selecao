package com.example.learning.organizapalestras;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getName;
import static java.lang.Character.getNumericValue;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public class MainActivity extends AppCompatActivity
{

    private ListView listView;
    private List<Palestras> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
            {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idlist);
        try {
            AssetManager assetManager = getResources().getAssets();

            InputStream imput = assetManager.open("proposals.txt");
            InputStreamReader reader = new InputStreamReader(imput);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String curso= null;

            while((curso= bufferedReader.readLine())!= null)
            {
                Palestras p= new Palestras(curso);
                list= new ArrayList<>();

                int countbyte;
                int countmin=0;

                for(int i=0; i<curso.length();i++)
                {
                    if(isDigit(curso.charAt(i))){
                        countbyte= getNumericValue(curso.charAt(i));
                        if(countbyte!= -1){
                            countmin= (countmin*10) + countbyte;

                            System.out.println(countmin+ " siaehhsudhas");
                        }
                        }
                }
                if(countmin==0){
                    countmin=5;
                    System.out.println(countmin+" puta merda vinicius");
                }



                }

                } catch (FileNotFoundException e)
            {
            e.printStackTrace();
                 } catch (IOException e)
            {
            e.printStackTrace();
                 }

             }


}



