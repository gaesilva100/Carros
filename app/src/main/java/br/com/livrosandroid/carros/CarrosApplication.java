package br.com.livrosandroid.carros;

import android.app.Application;
import android.util.Log;

/**
 * Created by gabriel on 22/07/16.
 */
public class CarrosApplication extends Application{

    // nota Pessoal buscar informaçoes sobre o private static final -->

    private static final String Tag = "CarrosApplication ";
    private static CarrosApplication instance = null;
    public static CarrosApplication getInstance(){
        return instance; // Singleton -- Buscar mais informaçoes....

    }

    @Override
    public void onCreate(){
        Log.d(Tag,"CarrosApplication.onCreate()");
        // Salva A instância para termos acesso com Singleton
        instance = this;
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        Log.d(Tag,"CarrosApplication.onterminate()");
    }

}
