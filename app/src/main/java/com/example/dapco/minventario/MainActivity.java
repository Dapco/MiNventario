package com.example.dapco.minventario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button Btn_inv;
    private Button Btn_Agr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Btn_Agr = (Button)findViewById(R.id.Btn_Agr);
        Btn_Agr.setOnClickListener(this);
        Btn_inv = (Button)findViewById(R.id.Btn_inv);
        Btn_inv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        switch (v.getId() ){
            case R.id.Btn_Agr:
                Intent i = new Intent(this, ScanAct.class);
                startActivity(i);
                break;
            case R.id.Btn_inv:
                Intent I = new Intent(this, Muestra_BusAct.class);
                startActivity(I);
                break;
        }
    }
}
