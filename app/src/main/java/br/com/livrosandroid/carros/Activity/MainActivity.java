package br.com.livrosandroid.carros.Activity;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;
import java.util.List;
import android.support.v4.app.Fragment;

import br.com.livrosandroid.carros.Fragments.AboutDialog;
import br.com.livrosandroid.carros.Fragments.CarrosFragment;
import br.com.livrosandroid.carros.Fragments.CarrosTabFragment;
import br.com.livrosandroid.carros.Fragments.SiteLivroFragment;
import br.com.livrosandroid.carros.R;

import br.com.livrosandroid.carros.adapter.NavDrawerMenuAdapter;
import br.com.livrosandroid.carros.adapter.NavDrawerMenuItem;
import livroandroid.lib.fragment.NavigationDrawerFragment;

public class MainActivity extends BaseActivity implements NavigationDrawerFragment.
        NavigationDrawerCallbacks {

    private NavDrawerMenuAdapter listAdapter;
    private NavigationDrawerFragment mNavDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        setUpToolbar();

        // Nav Drawer
        mNavDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_drawer_fragment);
        //Configura o Drawer layout
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Cor de Fundo da Barra de Status
        drawerLayout.setStatusBarBackground(R.color.primary_dark);
        mNavDrawerFragment.setUp(drawerLayout);


    }

    @Override
    public NavigationDrawerFragment.NavDrawerListView getNavDrawerView(NavigationDrawerFragment navDrawerFrag,
                                                                       LayoutInflater layoutInflater, ViewGroup container) {


        View view = layoutInflater.inflate(R.layout.nav_drawer_lilstview,container,false);

        // Deve retornar a view e o identificador do listView
        navDrawerFrag.setHeaderValues
                (view, R.id.listViewContainer, R.drawable.nav_drawer_header,
                        R.drawable.ic_drawer_carro, R.string.nav_drawer_username, R.string.nav_drawer_email);

        //return null;
        return new NavigationDrawerFragment.NavDrawerListView(view,R.id.listView);
    }

    @Override
    public ListAdapter getNavDrawerListAdapter(NavigationDrawerFragment navigationDrawerFragment) {
        // Este Metodo deve retornar o adapter que vai preencher o ListView
        List<NavDrawerMenuItem> list = NavDrawerMenuItem.getList();
        //Deixa o primeiro item selecionado
        list.get(0).selected = true;
        this.listAdapter = new NavDrawerMenuAdapter(this, list);
        return listAdapter;
    }

    @Override
    public void onNavDrawerItemSelected(NavigationDrawerFragment navigationDrawerFragment, int position) {
        // Metodo Chamado ao selecionar um item do ListView
        List<NavDrawerMenuItem> list = NavDrawerMenuItem.getList();
        NavDrawerMenuItem selectedItem = list.get(position);
        //Seleciona a linha
        this.listAdapter.setSelected(position,true);
        //toast("Clicou no item: "+ getString(selectedItem.title));

        if(position == 0){
           //replaceFragment(new CarrosFragment());
            replaceFragment(new CarrosTabFragment());
        } else if (position == 1){
            replaceFragment(new SiteLivroFragment());
        }else if (position == 2){
            toast( "Configurações");
        }else{
            Log.e("LIVRO ANDROID","Item de menu Inválido");
        }
    }

    // Cria o menu de opçoes no quanto da tela
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        // Chama o xml da pasta menu/menu_main.xml
        inf.inflate(R.menu.menu_main,menu);
        // Retorna Verdadeiro -- para indicar que o menu deve ser exibido
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item ){

        int id = item.getItemId();

        if(id == R.id.action_about){ // Mostra o dialog com informaçoes do aplicativo
            AboutDialog.showAbout(getSupportFragmentManager());
            //toast("Clicou no Sobre");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Adiciona o Fragment no centro da tela
    private void replaceFragment(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_drawer_container,
                frag,"TAG").commit();
    }
}
