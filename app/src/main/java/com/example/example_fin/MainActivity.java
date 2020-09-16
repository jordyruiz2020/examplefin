package com.example.example_fin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,sal,horasex,vhora,p,salud,stotal;
    Button calculo;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                String salariom="780.800";
                sal.setText(salariom);
                break;

            case R.id.item2:
                name.setText("");
                sal.setText("");
                horasex.setText("");
                vhora.setText("");
                p.setText("");
                salud.setText("");
                stotal.setText("");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.txtempleado);
        sal=findViewById(R.id.txtsalario);
        horasex=findViewById(R.id.txthoraex);
        vhora=findViewById(R.id.txtvhora);
        p=findViewById(R.id.txtp);
        salud=findViewById(R.id.txtsalud);
        stotal=findViewById(R.id.txtsalariot);
        calculo=findViewById(R.id.btncalculo);


        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(sal.getText().toString()) || TextUtils.isEmpty(horasex.getText().toString()) || TextUtils.isEmpty(vhora.getText().toString()) ){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
                }else{

                    String s=sal.getText().toString();
                    double SL=Double.parseDouble(s);
                    String h=horasex.getText().toString();
                    double hx=Double.parseDouble(h);
                    String vah=vhora.getText().toString();
                    double v=Double.parseDouble(vah);

                    double phx=hx*v;
                    double salariobruto=SL+phx;
                    double pension=salariobruto*0.4;
                    double sal=salariobruto*0.4;
                    double total=salariobruto-pension-sal;

                    stotal.setText(String.valueOf(total));
                    p.setText(String.valueOf(pension));
                    salud.setText(String.valueOf(sal));

                }




            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

    }
}