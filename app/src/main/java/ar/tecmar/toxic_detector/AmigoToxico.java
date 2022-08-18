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

public class AmigoToxico extends AppCompatActivity {
    ImageView img ;
    int contadorToxico = 0 ;
    Integer [] imagenes = {0,R.drawable.at2,R.drawable.at3,R.drawable.at4,R.drawable.at5,R.drawable.at6,R.drawable.at7
            ,R.drawable.at8,R.drawable.at9,R.drawable.at10,R.drawable.at11,R.drawable.at12,R.drawable.at13,R.drawable.at14
            ,R.drawable.at15,R.drawable.at16,R.drawable.at17,R.drawable.at18,R.drawable.at19,R.drawable.at20} ;
    int contadorI =0;
    MediaPlayer gb,yb,rb ;
    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigo_toxico);
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
            mInterstitialAd.show(AmigoToxico.this);
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

        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
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
        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
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
        else { Intent inicio = new Intent(this,ResultadosAmigoToxico.class);
            inicio.putExtra("contoxic",contadorToxico);
            startActivity(inicio);  }



    }




}