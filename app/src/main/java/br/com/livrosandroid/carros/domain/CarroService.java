package br.com.livrosandroid.carros.domain;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;

/**
 * Created by gabriel on 05/09/16.
 */

public class CarroService {
    private static final String URL = "http://www.livroiphone.com.br/carros/carros_{tipo}.json";
    private static final boolean LOG_ON = false;
    private static final String TAG = "CarroService";

    public static List<Carros> getCarros(Context context, String tipo) {
        List<Carros> carros = new ArrayList<Carros>();
        for (int i = 0; i < 20; i++) {
            Carros c = new Carros();
            c.nome = "Carro " + tipo + ": " + i;
            c.desc = "Desc " + i;
            c.urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png";
            carros.add(c);
        }
        return carros;
    }
}