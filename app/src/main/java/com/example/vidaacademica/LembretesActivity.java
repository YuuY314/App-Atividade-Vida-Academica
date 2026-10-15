package com.example.vidaacademica;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class LembretesActivity extends AppCompatActivity {

    private Button btnSalvarLembrete;
    private TextInputEditText edtTituloLembrete, edtDescricaoLembrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lembretes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbarTop);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSalvarLembrete = findViewById(R.id.btnSalvarLembrete);
        edtTituloLembrete = findViewById(R.id.edtTituloLembrete);
        edtDescricaoLembrete = findViewById(R.id.edtDescricaoLembrete);

        btnSalvarLembrete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String titulo = edtTituloLembrete.getText().toString().trim();

                if(titulo.isEmpty()){
                    edtTituloLembrete.setError("Informe o título do lembrete");
                    return;
                }

                Toast.makeText(LembretesActivity.this, "Lembrete Registrado!", Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}