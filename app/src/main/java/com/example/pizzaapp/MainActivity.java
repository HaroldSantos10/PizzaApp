package com.example.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioButton size1,size2,size3;
    CheckBox carne,queso,peperoni, tocino,champi,pineapple, aceitunas;
    RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.eTxtName);
        size1 = (RadioButton) findViewById(R.id.rBtnSmall);
        size2 = (RadioButton) findViewById(R.id.rBtnMedium);
        size3 = (RadioButton) findViewById(R.id.rBtnBig);
        carne = (CheckBox) findViewById(R.id.cbCarne);
        queso = (CheckBox) findViewById(R.id.cbQueso);
        peperoni = (CheckBox) findViewById(R.id.cbPeperoni);
        tocino = (CheckBox) findViewById(R.id.cbTocino);
        champi= (CheckBox) findViewById(R.id.cbChampi);
        pineapple = (CheckBox) findViewById(R.id.cbPineApple);
        aceitunas = (CheckBox) findViewById(R.id.cbAceitunas);
        grupo = (RadioGroup) findViewById(R.id.rgIngredientes);

    }


    public void process(View view){
        double tama= 0;

        if ((!size1.isChecked() && !size2.isChecked()) && !size3.isChecked()){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Seleccione un tamaño", Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            if(size1.isChecked()){ tama = 4.00;}
            if(size2.isChecked()){ tama = 8.00;}
            if(size3.isChecked()){ tama = 12.00;}
        }

        ArrayList<Double> ingre = returnArrayList();
        double suma= 0;
        for(int i=0; i<ingre.size();i++){
            double valor = ingre.get(i);
            suma += valor;
        }
        double sumaTotal= suma + tama;


        //Toast toast1 = Toast.makeText(getApplicationContext(), "Total de "+ sumaTotal, Toast.LENGTH_SHORT);
        //toast1.show();
        Intent intent = new Intent(MainActivity.this,ShowActivity.class);
        intent.putExtra("nombre",name.getText().toString());
        intent.putExtra("total",sumaTotal);

        if (size1.isChecked()){intent.putExtra("tama",size1.getText().toString());}
        if (size2.isChecked()){intent.putExtra("tama",size2.getText().toString());}
        if (size3.isChecked()){intent.putExtra("tama",size3.getText().toString());}


        if(carne.isChecked() || queso.isChecked() || peperoni.isChecked() || tocino.isChecked()
                || champi.isChecked() || pineapple.isChecked() || aceitunas.isChecked()){

            intent.putExtra("chk1",carne.isChecked());
            intent.putExtra("chk2",queso.isChecked());
            intent.putExtra("chk3",peperoni.isChecked());
            intent.putExtra("chk4",tocino.isChecked());
            intent.putExtra("chk5",champi.isChecked());
            intent.putExtra("chk6",pineapple.isChecked());
            intent.putExtra("chk7",aceitunas.isChecked());

        }
        else{
            intent.putExtra("chk1",false);
            intent.putExtra("chk2",false);
            intent.putExtra("chk3",false);
            intent.putExtra("chk4",false);
            intent.putExtra("chk5",false);
            intent.putExtra("chk6",false);
            intent.putExtra("chk7",false);

        }




        startActivity(intent);
    }


    public ArrayList<Double> returnArrayList(){
        ArrayList<Double> ingredientes= new ArrayList<>();

        if(carne.isChecked() || queso.isChecked() || peperoni.isChecked() || tocino.isChecked()
        || champi.isChecked() || pineapple.isChecked() || aceitunas.isChecked()){
            if(carne.isChecked()){ingredientes.add(1.50);}
            if(queso.isChecked()){ingredientes.add(1.75);}
            if(peperoni.isChecked()){ingredientes.add(1.75);}
            if(tocino.isChecked()){ingredientes.add(2.00);}
            if(champi.isChecked()){ingredientes.add(1.25);}
            if(pineapple.isChecked()){ingredientes.add(0.50);}
            if(aceitunas.isChecked()){ingredientes.add(1.00);}
        }
        else{
            ingredientes.add(0.00);
        }

        return ingredientes;
    }





}