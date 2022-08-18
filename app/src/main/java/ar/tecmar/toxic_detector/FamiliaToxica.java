package ar.tecmar.toxic_detector;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FamiliaToxica extends AppCompatActivity {

    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.ft2,R.drawable.ft3,R.drawable.ft4,R.drawable.ft5,R.drawable.ft6,R.drawable.ft7
            ,R.drawable.ft8,R.drawable.ft9,R.drawable.ft10,R.drawable.ft11,R.drawable.ft12,R.drawable.ft13,R.drawable.ft14
            ,R.drawable.ft15,R.drawable.ft16,R.drawable.ft17,R.drawable.ft18,R.drawable.ft19,R.drawable.ft20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia_toxica);
        // PUBLICIDAD INTERSTICIAL
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest2 = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-4497692161597147/8256315573", adRequest2,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("TAG", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });



        img = (ImageView) findViewById(R.id.visorpt);
        gb = MediaPlayer.create(this,R.raw.greenbtnsounefectreal);
        yb = MediaPlayer.create(this,R.raw.yellowbtnsoundefect);
        rb = MediaPlayer.create(this,R.raw.redbtnsound);


    }


    public void anuncio () {
        if (contadorI==10) {if (mInterstitialAd != null) {
            mInterstitialAd.show(FamiliaToxica.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        } }

    }


    // INICIA FUNCION BOTON VERDE

    public void greenbtn (View v) { gb.start();

        if (contadorI<19) {
            contadorI++;
            anuncio();
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
            anuncio();
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
            anuncio();
            contadorToxico += 5;
            img.setImageResource(imagenes[contadorI]);
        } else {
            Intent inicio = new Intent(this, ResultadosFamiliarToxic.class);
            inicio.putExtra("contoxic", contadorToxico);
            startActivity(inicio);
        }

    }


}