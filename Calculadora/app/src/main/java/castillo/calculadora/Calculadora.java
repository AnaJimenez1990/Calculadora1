package castillo.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Calculadora extends ActionBarActivity {
    public String operacion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void escribir (View v){
        Button boton = (Button) v;
        TextView textview1 = (TextView) findViewById(R.id.textView);
        operacion += boton.getText();
        textview1.setText(operacion);
    }


    public void escribirsigno(View v){
        Button boton = (Button) v;
        TextView textview1 = (TextView) findViewById(R.id.textView);
        textview1.setText(operacion);
        if (!operacion.isEmpty()&&operacion.charAt(operacion.length() - 1) != '+') {
             operacion += boton.getText();
             textview1.setText(operacion);
        }
    }


    public void Calcular(View v) {
        long a=0;
        String cadena="";
        if (!operacion.isEmpty()&&operacion.charAt(operacion.length()-1)!='+'){
        for(int i=0;i<operacion.length();i++){
            if (operacion.charAt(i)!='+'){
                cadena+=operacion.charAt(i);
            }else{
                a+=Long.parseLong(cadena);
                cadena="";
            }
        };
            a+=Long.parseLong(cadena);
            TextView textview1 = (TextView) findViewById(R.id.textView);
            TextView textview2 = (TextView) findViewById(R.id.textViewResultado);
            cadena= String.valueOf(a);
            //textview1.setText(cadena);
            textview2.setText("="+cadena);
            operacion=cadena+"+";

        }


    }

    public void borrar(View v) {
        operacion="";
        TextView textview1 = (TextView) findViewById(R.id.textView);
        TextView textview2 = (TextView) findViewById(R.id.textViewResultado);
        textview1.setText("0");
        textview2.setText("");

    }

    public void retroceso(View v) {
        TextView textview1 = (TextView) findViewById(R.id.textView);
        if (!operacion.isEmpty()){
            operacion=operacion.substring(0,operacion.length()-1);
            textview1.setText(operacion);
            if (operacion.isEmpty()){
                textview1.setText("0");
            }
        }else{
            textview1.setText("0");
            TextView textview2 = (TextView) findViewById(R.id.textViewResultado);
            textview2.setText("");
        }


    }


}
