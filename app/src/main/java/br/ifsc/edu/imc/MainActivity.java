package br.ifsc.edu.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText edPeso;
    EditText edAltura;
    TextView imc;
    ImageView imagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);
        imc= findViewById(R.id.imc);
        imagem = findViewById(R.id.ivPeso);
    }

    public float CalculaIMC(float peso, float altura){
        return peso/(altura*altura);
    }

    public void Calcular(View view){
        DecimalFormat df = new DecimalFormat("#.##");


        float peso = Float.parseFloat(edPeso.getText().toString());

        float altura = Float.parseFloat(edAltura.getText().toString());
        float IMC = CalculaIMC(peso,altura);

        if(IMC<18.5){
            imagem.setImageResource(R.drawable.abaixopeso);
        }else if((IMC >= 18.5)&&(IMC<=24.9)){
            imagem.setImageResource(R.drawable.normal);
        }else if((IMC >= 25)&&(IMC<=29.9)){
            imagem.setImageResource(R.drawable.sobrepeso);
        }else if((IMC >= 30)&&(IMC<=34.9)){
            imagem.setImageResource(R.drawable.obesidade1);
        }else if ((IMC >= 35)&&(IMC<=39.9)){
            imagem.setImageResource(R.drawable.obesidade2);
        }else if(IMC >=40) {
            imagem.setImageResource(R.drawable.obesidade3);
        }

        imc.setText(df.format(IMC));

    }
}
