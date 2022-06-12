package ar.tecmar.toxic_detector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuieresConocerlosResultados extends AppCompatActivity {

    int cont = getIntent().getIntExtra("contoxic");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quieres_conocerlos_resultados);


        System.out.println();

    }
}