package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ParejaYellowCase extends AppCompatActivity {
    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pareja_yellow_case);
        mp = MediaPlayer.create(this,R.raw.sonido_botono_futiro);
    }

    // METODO PARA VOLVER AL INICIO
    public void volverAlInicio (View v) {  mp.start();
        Intent i = new Intent(this,MainActivity.class) ;
        startActivity(i); }


}