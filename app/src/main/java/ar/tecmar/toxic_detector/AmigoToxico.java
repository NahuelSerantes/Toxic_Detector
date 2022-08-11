package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AmigoToxico extends AppCompatActivity {
    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.at2,R.drawable.at3,R.drawable.at4,R.drawable.at5,R.drawable.at6,R.drawable.at7
            ,R.drawable.at8,R.drawable.at9,R.drawable.at10,R.drawable.at11,R.drawable.at12,R.drawable.at13,R.drawable.at14
            ,R.drawable.at15,R.drawable.at16,R.drawable.at17,R.drawable.at18,R.drawable.at19,R.drawable.at20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigo_toxico);
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

        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
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
        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
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
        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }




}