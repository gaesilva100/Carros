package br.com.livrosandroid.carros.Activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.livrosandroid.carros.R;

/**
 * Created by gabriel on 22/07/16.
 */
public class BaseActivity extends livroandroid.lib.activity.BaseActivity{

    protected void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }
}
