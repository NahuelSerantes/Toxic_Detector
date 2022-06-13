package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QuieresConocerlosResultados extends AppCompatActivity {
      int toxic_counter ;
      MediaPlayer mp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quieres_conocerlos_resultados);
        Intent i = getIntent();
        toxic_counter = i.getIntExtra("contoxic",0);
        mp = MediaPlayer.create(this,R.raw.sonido_botono_futiro) ;

    }
    //FUNCION QUE MANDA A VOLVER HACER EL TEST
    public void volver(View v) {
        mp.start();
        Intent i = new Intent(this,ParejaToxica.class) ;
        startActivity(i);


    }



}