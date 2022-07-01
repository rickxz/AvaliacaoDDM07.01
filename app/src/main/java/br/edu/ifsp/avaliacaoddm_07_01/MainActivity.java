package br.edu.ifsp.avaliacaoddm_07_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Herick Victor Rodrigues
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class DialogListenerCancelar implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Toast.makeText(MainActivity.this, "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }

    private class DialogListenerFechar implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
            Toast.makeText(MainActivity.this, "Saindo...", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCalcular:
                Intent intent = new Intent(getApplicationContext(), MediaActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuFinalizar:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Fechando o app");
                dialog.setMessage("Deseja mesmo fechar o app?");
                dialog.setPositiveButton("Fechar o app", new DialogListenerFechar());
                dialog.setNegativeButton("Cancelar", new DialogListenerCancelar());
                dialog.setCancelable(false);
                dialog.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}