package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fragmentos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = binding.txtWeb.getText().toString().trim();

                if (!url.isEmpty()){
                    if (!url.startsWith("http://") && (!url.startsWith("https://"))){
                        url= "https://" + url;
                        binding.txtWeb.setText(url);Toast.makeText(MainActivity.this,"Agregamos http",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }else{
                    binding.divWeb.setError("Ingresa una direccion web");
                }

            }
        });

        binding.txtWeb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    binding.divWeb.setError(null);
                }

            }

        });
    }
}