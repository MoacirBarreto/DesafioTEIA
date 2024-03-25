package devandroid.moacir.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    private TextView TxtViewValorRecebido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TxtViewValorRecebido = findViewById(R.id.TxtViewValorRecebido );

        // Receber o valor da Intent
        int valorRecebido = getIntent().getIntExtra("apelido", 0);

        // Mostrar o valor recebido no TextView
        TxtViewValorRecebido.setText("Apelido :" + valorRecebido);
    }

    }
