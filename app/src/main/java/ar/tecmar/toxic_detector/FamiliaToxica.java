package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FamiliaToxica extends AppCompatActivity {

    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.ft2,R.drawable.ft3,R.drawable.ft4,R.drawable.ft5,R.drawable.ft6,R.drawable.ft7
            ,R.drawable.ft8,R.drawable.ft9,R.drawable.ft10,R.drawable.ft11,R.drawable.ft12,R.drawable.ft13,R.drawable.ft14
            ,R.drawable.ft15,R.drawable.ft16,R.drawable.ft17,R.drawable.ft18,R.drawable.ft19,R.drawable.ft20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia_toxica);
        img = (ImageView) findViewById(R.id.visorpt);
        gb = MediaPlayer.create(this,R.raw.greenbtnsounefectreal);
        yb = MediaPlayer.create(this,R.raw.yellowbtnsoundefect);
        rb = MediaPlayer.create(this,R.raw.redbtnsound);


    }

    // INICIA FUNCION BOTON VERDE

    public void greenbtn (View v) { gb.start();

        if (contadorI<19) {
            contadorI++;
            img.setImageResource(imagenes[contadorI]); }

        else { Intent inicio = new Intent(this,ResultadosFamiliarToxic.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }

    // INICIA FUNCION BOTON AMARILLO

    public void yellowbtn (View v) {
        yb.start();
        if (contadorI<19) {
            contadorI++;
            contadorToxico+=3;
            img.setImageResource(imagenes[contadorI]); }
        else { Intent inicio = new Intent(this,ResultadosFamiliarToxic.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }

// INICIA FUNCION BOTON ROJO

    public void redbtn (View v) {
        rb.start();
        if (contadorI < 19) {
            contadorI++;
            contadorToxico += 5;
            img.setImageResource(imagenes[contadorI]);
        } else {
            Intent inicio = new Intent(this, ResultadosFamiliarToxic.class);
            inicio.putExtra("contoxic", contadorToxico);
            startActivity(inicio);
        }

    }


}