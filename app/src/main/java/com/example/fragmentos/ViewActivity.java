package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fragmentos.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding vbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vbinding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(vbinding.getRoot());

        Intent vintent = getIntent();
        String url = vintent.getStringExtra("url");
        vbinding.webTxt.setText(url.toLowerCase());

        vbinding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Cargar el WebFragment con la URL proporcionada
        loadWebFragment(url);
    }

    private void loadWebFragment(String url) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        WebFragment webFragment = WebFragment.newInstance(url);
        transaction.replace(R.id.fragmentContainerView2, webFragment);
        transaction.commit();

    }
}
