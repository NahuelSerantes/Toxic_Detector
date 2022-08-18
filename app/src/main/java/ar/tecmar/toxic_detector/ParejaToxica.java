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

public class ParejaToxica extends AppCompatActivity {
    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.pt2,R.drawable.pt3,R.drawable.pt4,R.drawable.pt5,R.drawable.pt6,R.drawable.pt7
    ,R.drawable.pt8,R.drawable.pt9,R.drawable.pt10,R.drawable.pt11,R.drawable.pt12,R.drawable.pt13,R.drawable.pt14
    ,R.drawable.pt15,R.drawable.pt16,R.drawable.pt17,R.drawable.pt18,R.drawable.pt19,R.drawable.pt20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pareja_toxica);
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

    // FUNCION QUE DISPARA EL INTERSTICIAL EN 10ma IMAGEN

    public void anuncio () {
        if (contadorI==10) {if (mInterstitialAd != null) {
            mInterstitialAd.show(ParejaToxica.this);
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

        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
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
        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }

    }

// INICIA FUNCION BOTON ROJO

    public void redbtn (View v) {
        rb.start();
        if (contadorI<19) {
            contadorI++;
            anuncio();
            contadorToxico+=5;
            img.setImageResource(imagenes[contadorI]);
            }
        else { Intent inicio = new Intent(this,QuieresConocerlosResultados.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }

    }

}