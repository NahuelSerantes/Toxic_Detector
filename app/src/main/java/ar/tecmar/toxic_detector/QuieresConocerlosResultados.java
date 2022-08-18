package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;

public class QuieresConocerlosResultados extends AppCompatActivity {
      int toxic_counter ;
      MediaPlayer mp ;
    private AdView mAdView;





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

    // FUNCION QUE DISPARA LAS 3 ACTIVITYS DEPENDIENDO EL RESULTADO

    public void resultado (View v ) {

        System.out.println(toxic_counter);
        mp.start();

        if (toxic_counter>61) { Intent i = new Intent (this,ParejaRedCase.class);
        startActivity(i);}

        else if (toxic_counter<=60 && toxic_counter >=25) { Intent i = new Intent (this,ParejaYellowCase.class);
            startActivity(i); }

        else {  Intent i = new Intent (this,ParejaGreenCase.class);
            startActivity(i); }




    }



}