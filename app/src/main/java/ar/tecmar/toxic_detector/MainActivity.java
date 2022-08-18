package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button bt1, bt2;
    String miweb = "https://tecmar.org/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.startbt);
        bt2 = (Button) findViewById(R.id.sabermasboton);
        mp = MediaPlayer.create(this, R.raw.sonido_botono_futiro);
        mp.start();


    }

    // METOODO QUE INICIA LA APP ---> INTENT QUE ABRE ACTIVITY "comienzo"

    public void inicioapp (View v) {
        mp.start();
        Intent inicio = new Intent(this,comienzo.class);
        startActivity(inicio);
    }

    // METODO QUE MANDA A LA PAGINA DE TECMAR

    public void saber (View v) {
        mp.start();
        Uri link = Uri.parse(miweb);
        Intent i = new Intent (Intent.ACTION_VIEW,link );
        startActivity(i);

    }


}