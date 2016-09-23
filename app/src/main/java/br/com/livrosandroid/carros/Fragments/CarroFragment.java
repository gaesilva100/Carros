package br.com.livrosandroid.carros.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.livrosandroid.carros.R;
import br.com.livrosandroid.carros.domain.Carros;

/**
 * Created by gabriel on 10/09/16.
 */
public class CarroFragment extends BaseFragment{
    private Carros carro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_carros,container,false);

        return view;
    }

    // Metodo public chamado pela activity para atualizar os dados do carro
    public void setCarro(Carros carro){

             this.carro = carro;
            setTextString(R.id.tDesc, carro.desc);
            //final ImageView imgView = (ImageView) getView().findViewById(R.id.img);
           // Picasso.with(getContext()).load(carro.urlFoto).fit().into(imgView);
        }

    }



