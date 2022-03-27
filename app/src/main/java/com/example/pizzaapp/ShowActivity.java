package com.example.pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    TextView nombre, seleccion,Ftotal, indica;
    TextView beef,cheese,pepe,bacon, mush, pineA,olives;
    LinearLayout ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        nombre = (TextView) findViewById(R.id.txtName);
        seleccion = (TextView) findViewById(R.id.txtSize);
        Ftotal = (TextView) findViewById(R.id.TxtTotal);
        beef = (TextView) findViewById(R.id.txtBeef);
        cheese= (TextView) findViewById(R.id.txtCheese);
        pepe = (TextView) findViewById(R.id.txtPepe);
        bacon = (TextView) findViewById(R.id.txtBacon);
        mush = (TextView) findViewById(R.id.txtMush);
        pineA = (TextView) findViewById(R.id.txtPineA);
        olives = (TextView) findViewById(R.id.txtOlives);
        ingredients = (LinearLayout) findViewById(R.id.LyIngre);
        indica = (TextView) findViewById(R.id.txtSelect);

        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("nombre");
        String d2 = extras.getString("tama");
        Double d3 = extras.getDouble("total");

        boolean i1= extras.getBoolean("chk1");
        boolean i2= extras.getBoolean("chk2");
        boolean i3= extras.getBoolean("chk3");
        boolean i4= extras.getBoolean("chk4");
        boolean i5= extras.getBoolean("chk5");
        boolean i6= extras.getBoolean("chk6");
        boolean i7= extras.getBoolean("chk7");

        nombre.setText("Estimado cliente: "+d1);
        seleccion.setText("Producto seleccionado: "+d2);
        Ftotal.setText("Total: $"+d3);

        if(i1 || i2 || i3 || i4 || i5 || i6 || i7){

            if(!i1){beef.setVisibility(View.GONE);}
            if(!i2){cheese.setVisibility(View.GONE);}
            if(!i3){pepe.setVisibility(View.GONE);}
            if(!i4){bacon.setVisibility(View.GONE);}
            if(!i5){mush.setVisibility(View.GONE);}
            if(!i6){pineA.setVisibility(View.GONE);}
            if(!i7){olives.setVisibility(View.GONE);}

        }else {
            indica.setText("No ha seleccionado ingredientes");
            beef.setVisibility(View.GONE);
            cheese.setVisibility(View.GONE);
            pepe.setVisibility(View.GONE);
            bacon.setVisibility(View.GONE);
            mush.setVisibility(View.GONE);
            pineA.setVisibility(View.GONE);
            olives.setVisibility(View.GONE);
        }






    }
    public void regresar(View v){
        finish();
    }

}