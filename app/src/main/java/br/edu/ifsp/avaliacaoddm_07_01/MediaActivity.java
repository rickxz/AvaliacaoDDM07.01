package br.edu.ifsp.avaliacaoddm_07_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediaActivity extends AppCompatActivity {
    private EditText txtNota1;
    private EditText txtNota2;
    private Button btnCalcular;
    private TextView lblMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblMedia = findViewById(R.id.lblMedia);
        btnCalcular.setOnClickListener(new btnListener());
    }

    class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            double nota1 = Double.parseDouble(txtNota1.getText().toString());
            double nota2 = Double.parseDouble(txtNota2.getText().toString());
            double media = (nota1+nota2)/2;
            lblMedia.setText(Double.toString(media));
        }
    }
}