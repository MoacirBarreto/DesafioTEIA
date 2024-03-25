package devandroid.moacir.desafio;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Pessoa pessoa;
    private EditText editTextApelido;
    private TextView textViewCheck;
    private TextView textViewCheckSize;
    private Button btnSalvar;
    private Button btnLimpar;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle savedInstanceState1 = savedInstanceState;
        super.onCreate(savedInstanceState1);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
       // pessoa.setApelido("Zezinho");

        editTextApelido = findViewById(R.id.editTextApelido);
        textViewCheck = findViewById(R.id.textViewCheck);
        textViewCheckSize = findViewById(R.id.textViewCheckSize);
        btnCheck = findViewById(R.id.btnCheck);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);


        // Define o filtro para aceitar apenas caracteres alfanuméricos
        InputFilter alphanumFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                // Loop através de cada caractere
                for (int i = start; i < end; i++) {
                    // Verifica se o caractere não é alfanumérico
                    if (!Character.isLetterOrDigit(source.charAt(i))) {
                        return "";
                    }
                }
                // Retorna nulo para aceitar o caractere
                return null;
            }
        };
        // Aplica o filtro ao EditText
        editTextApelido.setFilters(new InputFilter[]{alphanumFilter});


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = editTextApelido.getText().toString();
                int size = texto.length();
                textViewCheck.setText("Seu apelido: " + texto);
                if (size >3 && size <= 20) {
                        textViewCheckSize.setText("Tamanho do texto: " + size + " caracteres");
                        btnSalvar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                findViewById(R.id.btnSalvar).setOnClickListener(view1 -> {
                                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                    intent.putExtra("apelido",texto);
                                    startActivity(intent);
                                });

                            }
                        });
                }
                    else{
                        textViewCheckSize.setText("O tamanho de ser maior que 3 e menor ou igual a 20");}
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextApelido.setText("");
                textViewCheck.setText("");
                textViewCheckSize.setText("");
            }
        });


            }
        }