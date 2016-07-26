package br.com.livrosandroid.carros.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.livrosandroid.carros.R;

/**
 * Created by gabriel on 26/07/16.
 */
public class NavDrawerMenuItem {

    // Titulo : R.string.xxx
    public int title;

    //Figura: R.drawable.xx

    public int img;

    //para colocar um fundo cinza quan a linha está selecionada

    public boolean selected;

    public NavDrawerMenuItem(int title, int img){
        this.title = title;
        this.img = img;
    }


    // Cria a lista com os itens de menu

     public static List<NavDrawerMenuItem> getList(){
         List<NavDrawerMenuItem> list = new ArrayList<NavDrawerMenuItem>();
         list.add(new NavDrawerMenuItem(R.string.carros,R.drawable.ic_drawer_carro));
         list.add(new NavDrawerMenuItem(R.string.site_livro,R.drawable.ic_drawer_site_livro));
         list.add(new NavDrawerMenuItem(R.string.configuracoes, R.drawable.ic_drawer_settings));
         return list;
     }
}
