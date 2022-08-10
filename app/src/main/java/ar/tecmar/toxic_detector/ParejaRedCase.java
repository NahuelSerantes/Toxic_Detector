package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ParejaRedCase extends AppCompatActivity {

    MediaPlayer mp ;
    String miapp = "https://play.google.com/store/apps/details?id=ar.tecmar.toxic_detector";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pareja_red_case);
        mp = MediaPlayer.create(this,R.raw.sonido_botono_futiro);
    }

    // METODO PARA VOLVER AL INICIO
    public void volverAlInicio (View v) {  mp.start();
        Intent i = new Intent(this,MainActivity.class) ;
        startActivity(i); }


    // METODO PARA MANDAR AL USUARIO A CALIFICAR TU APP ---
    // USA ESTE LINK "https://play.google.com/store/apps/details?id=ar.tecmar.toxic_detector";

    public void calificar (View v) {
        mp.start();
        Uri link = Uri.parse(miapp);
        Intent i = new Intent (Intent.ACTION_VIEW,link );
        startActivity(i);}

}