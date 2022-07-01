package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ParejaToxica extends AppCompatActivity {
    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.pt2,R.drawable.pt3,R.drawable.pt4,R.drawable.pt5,R.drawable.pt6,R.drawable.pt7
    ,R.drawable.pt8,R.drawable.pt9,R.drawable.pt10,R.drawable.pt11,R.drawable.pt12,R.drawable.pt13,R.drawable.pt14
    ,R.drawable.pt15,R.drawable.pt16,R.drawable.pt17,R.drawable.pt18,R.drawable.pt19,R.drawable.pt20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pareja_toxica);
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

        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
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
        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }

// INICIA FUNCION BOTON ROJO

    public void redbtn (View v) {
        rb.start();
        if (contadorI<19) {
            contadorI++;
            contadorToxico+=5;
            img.setImageResource(imagenes[contadorI]);
            }
        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }

}