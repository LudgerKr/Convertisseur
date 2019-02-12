package com.example.userinsta.convertisseur;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    //définir des objets de prog
    private Button btEuro, btFr, btTaux, btAc;
    private EditText txtMontant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //nous sommes dans le main
        //correspondance entre objets prog et objets graphiques
        this.btAc = (Button) findViewById(R.id.idAc);
        this.btEuro = (Button) findViewById(R.id.idEuro);
        this.btFr = (Button) findViewById(R.id.idFr);
        this.btTaux = (Button) findViewById(R.id.idTaux);
        this.txtMontant = (EditText) findViewById(R.id.idMontant);
        //rendre les boutons ecoutables

        this.btAc.setOnClickListener(this);
        this.btEuro.setOnClickListener(this);
        this.btFr.setOnClickListener(this);
        this.btTaux.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.idAc :
                this.txtMontant.setText("");
                break;
           case R.id.idEuro :
            {
                float mt =0;
                try {
                    mt = Float.parseFloat(this.txtMontant.getText().toString());
                    mt /= (float) 6.56;
                    this.txtMontant.setText(mt + "");
                    this.txtMontant.setBackgroundColor(Color.GRAY);
                }
                catch (NumberFormatException exp)
                {
                    // Toast = JOPTIONPane
                    Toast.makeText(this, "Erreur du montant saisi", Toast.LENGTH_LONG).show();
                    this.txtMontant.setBackgroundColor(Color.RED);
                }
            }
            break;
            case R.id.idFr :
            {
                float mt = Float.parseFloat(this.txtMontant.getText().toString());
                mt *= (float) 6.56;
                this.txtMontant.setText(mt+"");
            }
            break;
            case R.id.idTaux:
                Toast.makeText(this, "Le taux est de : 6.56", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
