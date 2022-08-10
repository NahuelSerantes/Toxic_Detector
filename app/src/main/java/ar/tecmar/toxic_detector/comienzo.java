package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class comienzo extends AppCompatActivity {
    MediaPlayer mp ;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienzo);
        mp = MediaPlayer.create(this, R.raw.sonido_botono_futiro) ;
        // METODO PUBLICIDAD BANNER

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);






    }
    // SE CREA METODO QUE INICIA PAREJA TOXICA
    public void btnParejaToxica (View v) {
        mp.start();
        Intent inicio = new Intent(this,ParejaToxica.class);
        startActivity(inicio);
    }

}