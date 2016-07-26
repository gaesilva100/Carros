package br.com.livrosandroid.carros.Activity;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.List;

import br.com.livrosandroid.carros.R;

import livroandroid.lib.fragment.NavigationDrawerFragment;

public class MainActivity extends BaseActivity implements NavigationDrawerFragment.
        NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        // Nav Drawer
        mNavDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_drawer_fragment);
        //Configura o Drawer layout
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavDrawerFragment.setUp(drawerLayout);
    }

    @Override
    public NavigationDrawerFragment.NavDrawerListView getNavDrawerView(NavigationDrawerFragment navDrawerFrag, LayoutInflater layoutInflater, ViewGroup container) {


        View view = layoutInflater.inflate(R.layout.nav_drawer_lilstview,container,false);

        // Deve retornar a view e o identificador do listView
        //return null;
        return new NavigationDrawerFragment.NavDrawerListView(view,R.id.listView);
    }

    @Override
    public ListAdapter getNavDrawerListAdapter(NavigationDrawerFragment navDrawerFrag) {
        // Este Metodo deve retornar o adapter que vai preencher o ListView
        return null;
    }

    @Override
    public void onNavDrawerItemSelected(NavigationDrawerFragment navDrawerFrag, int position) {
        // Metodo Chamado ao selecionar um item do ListView
    }
}
