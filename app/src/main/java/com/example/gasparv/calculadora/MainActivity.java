package com.example.gasparv.calculadora;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    String PO="",SO="", op="";
    double total= Double.MAX_VALUE;
    private TextView mTextView;
    private static final String Saved = "textValue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.Pantalla);
        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString(Saved);
            mTextView.setText(savedText);
        }
    }
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Saved, mTextView.getText().toString());
    }

    public void Operacion(View v) {
        TextView Resultado = (TextView) findViewById(R.id.Pantalla);
        Button bot=(Button) findViewById(v.getId());
        op = bot.getText().toString();
        if (SO.equals(""))
        {   PO=Resultado.getText().toString();
            Resultado.setText(Resultado.getText().toString()+op);
        }

    }
public void BorrarUno(View V){
    TextView screen = (TextView) findViewById(R.id.Pantalla);
    screen.setText("");
}
public void BorrarDos(View V){
    BorrarUno(V);
    PO="";SO="";op="";total= Double.MAX_VALUE;
}
public void Igual(View v)
{   TextView screen = (TextView) findViewById(R.id.Pantalla);
    if(!screen.getText().toString().equals("") && !op.equals("")){

        double pri,seg;
        String pant="";
        SO = screen.getText().toString().substring(screen.getText().toString().indexOf(op)+1);
        pri=Double.parseDouble(PO);
        seg=Double.parseDouble(SO);
        switch (op) {
            case "+":
                      total=pri+seg;
                      pant=String.valueOf(total);
                      break;

            case "-": total=pri-seg;
                      pant=String.valueOf(total);
                      break;

            case "*": total=pri*seg;
                      pant=String.valueOf(total);
                      break;
            case "/":if(seg!=0.0) {
                        total = pri / seg;
                        pant=String.valueOf(total);
                    }else
                        {
                           total=Double.MAX_VALUE;
                            pant="NaN";
                        }

                      break;
                    }
        screen.setText(pant);
        SO="";PO="";
    }
}
public void Mostrar(View v)
{
    TextView screen = (TextView) findViewById(R.id.Pantalla);
    if (screen.getText().toString().equalsIgnoreCase("0") ||screen.getText().toString().equalsIgnoreCase("NaN")){

        screen.setText(v.getTag().toString());
    }else{
        screen.setText(screen.getText() + v.getTag().toString());
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}