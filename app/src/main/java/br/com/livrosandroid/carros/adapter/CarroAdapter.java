package br.com.livrosandroid.carros.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.livrosandroid.carros.R;

import br.com.livrosandroid.carros.domain.Carros;

/**
 * Created by gabriel on 05/09/16.
 */
public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>{


    protected static final String TAG= "GAGAGAGAGAG";
    private final List<Carros> carros;
    private final Context context;

    private CarroOnClickListener carroOnClickListener;

    public CarroAdapter(Context context, List<Carros> carros, CarroOnClickListener carroOnClickListener){
        this.context = context;
        this.carros = carros;
        this.carroOnClickListener = carroOnClickListener;

    }
    @Override
    public int getItemCount(){return this.carros !=null ? this.carros.size():0;}


    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Infla a view do layout
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_carro, viewGroup, false);

        CardView cardView = (CardView) view.findViewById(R.id.card_view);

        // Cria o ViewHolder
        CarrosViewHolder holder = new CarrosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position) {
        // Atualiza a view
        Carros c = carros.get(position);

        holder.tNome.setText(c.nome);
        holder.progress.setVisibility(View.VISIBLE);

        Picasso.with(context).load(c.urlFoto).fit().into(holder.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.progress.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                holder.progress.setVisibility(View.GONE);
            }
        });

        //Click
        if (carroOnClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    // A Variável Position é final
                    carroOnClickListener.onClickCarro(holder.itemView,position);
                }
            });
        }


    }

    public interface CarroOnClickListener{
        public void onClickCarro(View view, int idx);
    }

    //ViewHolder Com as Views

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        public TextView tNome;
        ImageView img;
        ProgressBar progress;
        //CardViwe cardView;
        public CarrosViewHolder(View view){
            super(view);
            //Cria as views para salvar no viewHOlder
            tNome=(TextView) view.findViewById(R.id.text);
            img= (ImageView) view.findViewById(R.id.img);
            progress = (ProgressBar) view.findViewById(R.id.progressImg);
            //cardView = (CardView) view.findViewById(R.id.card_view);


        }

    }
}
