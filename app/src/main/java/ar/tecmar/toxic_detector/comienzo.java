package ar.tecmar.toxic_detector;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class comienzo extends AppCompatActivity {
    EditText nombre, nombrepareja,tiempojuntos ;
    RadioButton si1,si2 ;
    Button continuar ;
    MediaPlayer mp,mp2 ;
    String nom,nompar,tiempojunt ;

    int contador=0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienzo);

        nombre = (EditText) findViewById(R.id.nombre);
        nombrepareja = (EditText) findViewById(R.id.nombrepareja);
        tiempojuntos = (EditText) findViewById(R.id.timemeses);
        si1 = (RadioButton) findViewById(R.id.si1);
        si2 = (RadioButton) findViewById(R.id.si2);
        continuar =  (Button) findViewById(R.id.btncontinuuar);
        mp = MediaPlayer.create(this,R.raw.sonido_botono_futiro);
        mp2 = MediaPlayer.create(this,R.raw.click);

    }

      public void clicksound (View v) {mp2.start();}

      public void checkar1 (View v) { mp2.start();
        contador+=10;}

      public void checkar2 (View v) { mp2.start()
      ;contador+=5;}

      public void continuar (View v) {
        nom =nombre.getText().toString();
        nompar = nombrepareja.getText().toString();
        tiempojunt=nombrepareja.getText().toString();

        if (nom.length()!=0&&nompar.length()!=0&&tiempojunt.length()!=0) {
                 mp.start();

                 System.out.println(contador);}

        else { Toast t = Toast.makeText(this,"Completa TODOS los campos para continuar",Toast.LENGTH_LONG);
              t.show();


        }


    }



}