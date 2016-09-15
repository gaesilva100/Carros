package br.com.livrosandroid.carros.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.livrosandroid.carros.Activity.CarroActivity;
import br.com.livrosandroid.carros.R;
import br.com.livrosandroid.carros.adapter.CarroAdapter;
import br.com.livrosandroid.carros.domain.Carros;
import br.com.livrosandroid.carros.domain.CarroService;


public class CarrosFragment extends BaseFragment {
    protected RecyclerView recyclerView;
    private List<Carros> carros;
    private LinearLayoutManager mLayoutManager;
    private String tipo;


    // Como ele faz para converter o tipo em Carro luxo ou  esportivos??
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.tipo = getArguments().getString("tipo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carros, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        taskCarros();
    }

    private void taskCarros() {
        // Busca os carros
        this.carros = CarroService.getCarros(getContext(), tipo);
        // Atualiza a lista
        recyclerView.setAdapter(new CarroAdapter(getContext(), carros, onClickCarro()));
    }

    private CarroAdapter.CarroOnClickListener onClickCarro() {
        return new CarroAdapter.CarroOnClickListener() {
            @Override
            public void onClickCarro(View view, int idx) {
                Carros c = carros.get(idx);
                Intent intent = new Intent(getContext(), CarroActivity.class);
                intent.putExtra("carros",c);
                startActivity(intent);
            }
        };
    }

}