package br.com.livrosandroid.carros.Activity;

import android.os.Bundle;

import br.com.livrosandroid.carros.Fragments.CarroFragment;

import br.com.livrosandroid.carros.Fragments.CarrosFragment;
import br.com.livrosandroid.carros.R;
import br.com.livrosandroid.carros.domain.Carros;


public class CarroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_carro);

        // Configura a Toolbar como a action bar
        setUpToolbar();

        // Atualiza o carro no fragment
        CarroFragment cf = (CarroFragment) getSupportFragmentManager().findFragmentById(R.id.CarroFragment);
        Carros c = (Carros) getIntent().getSerializableExtra("carro");
        cf.setCarro(c);

        // Título da toolbar e botão up navigation
        getSupportActionBar().setTitle(c.nome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}