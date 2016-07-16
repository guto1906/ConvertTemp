package br.com.fatecpg.converttemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //captura os objetos da activity
    public RadioButton getCelsOn(){
        RadioButton CelsOn = (RadioButton)findViewById(R.id.rbtnCelsOn);
        return CelsOn;
    }
    public RadioButton getFahrOn(){
        RadioButton FahrOn = (RadioButton)findViewById(R.id.rbtnFahrOn);
        return FahrOn;
    }
    public RadioButton getKelvOn(){
        RadioButton KelvOn = (RadioButton)findViewById(R.id.rbtnKelvOn);
        return KelvOn;
    }
    public RadioButton getCelsOut(){
        RadioButton CelsOut = (RadioButton)findViewById(R.id.rbtnCelsOut);
        return CelsOut;
    }
    public RadioButton getFahrOut(){
        RadioButton FahrOut = (RadioButton)findViewById(R.id.rbtnFahrOut);
        return FahrOut;
    }
    public RadioButton getKelvOut(){
        RadioButton KelvOut = (RadioButton)findViewById(R.id.rbtnKelvOut);
        return KelvOut;
    }

    public EditText getTempIn(){
        EditText TempIn = (EditText) findViewById(R.id.TempIn);
        return TempIn;
    }
    public TextView getTempOut(){
        TextView TempOut = (TextView) findViewById(R.id.TempOut);
        return TempOut;
    }
    public TextView getAviso(){
        TextView Aviso = (TextView) findViewById(R.id.aviso);
        return Aviso;
    }

    //Funcao que desabilita a escala da saida de acordo com radio box checado na entrada
    public void desabilitar(View view){
         if(getCelsOn().isChecked()){
             getCelsOut().setEnabled(false);
         } else {
             getCelsOut().setEnabled(true);
         }
         if(getKelvOn().isChecked()){
            getKelvOut().setEnabled(false);
         } else {
            getKelvOut().setEnabled(true);
         }
         if(getFahrOn().isChecked()){
            getFahrOut().setEnabled(false);
         } else {
            getFahrOut().setEnabled(true);
         }

    }
     //Funcao que converte de acordo com os radio box checados e acionado pelo click na saida
    public void converte(View view){
        EditText temp = getTempIn();
        if (temp.getText().toString().equals("")){
            Toast.makeText(getApplication(), "Entre com a Temp", Toast.LENGTH_LONG).show();
        }else {
            TextView tempF = getTempOut();
            TextView avs = getAviso();
            double TI = Double.parseDouble(temp.getText().toString());
            double TF = 0;
            String AV = "";
            if (getCelsOn().isChecked() && getKelvOut().isChecked()) {
                TF = TI + 273;
                AV = "Celsius para Kelvin";
            } else if (getCelsOn().isChecked() && getFahrOut().isChecked()) {
                TF = ((9 * TI) / 5) + 32;
                AV = "Celsius para Fahrenheit";
            } else if (getKelvOn().isChecked() && getFahrOut().isChecked()) {
                TF = (9 * ((TI - 273) / 5)) + 32;
                AV = "Kelvin para Fahrenheit";
            } else if (getKelvOn().isChecked() && getCelsOut().isChecked()) {
                TF = TI - 273;
                AV = "Kelvin para Celsius";
            } else if (getFahrOn().isChecked() && getCelsOut().isChecked()) {
                TF = ((TI - 32) * 5) / 9;
                AV = "Fahrenheit para Celsius";
            } else if (getFahrOn().isChecked() && getKelvOut().isChecked()) {
                TF = (((TI - 32) / 9) * 5) + 273;
                AV = "Fahrenheit para Kelvin";
            }

            tempF.setText("" + TF);
            avs.setText("" + AV);
        }
    }

}
