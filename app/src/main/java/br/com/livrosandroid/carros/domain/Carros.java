package br.com.livrosandroid.carros.domain;
import java.io.Serializable;


/**
 * Created by gabriel on 05/09/16.
 */
public class Carros implements Serializable{

    private static final long serialVersionUID = 6601006766832473959L;

    public long id;
    public String tipo;
    public String nome;
    public String desc;
    public String urlFoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;


}