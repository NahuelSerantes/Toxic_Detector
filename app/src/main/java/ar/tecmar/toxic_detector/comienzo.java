package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class comienzo extends AppCompatActivity {
    MediaPlayer mp ;
    //restar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienzo);
        mp = MediaPlayer.create(this, R.raw.sonido_botono_futiro) ;

    }
    // SE CREA METODO QUE INICIA PAREJA TOXICA
    public void btnParejaToxica (View v) {
        mp.start();
        Intent inicio = new Intent(this,ParejaToxica.class);
        startActivity(inicio);
    }

}