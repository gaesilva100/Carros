package br.com.livrosandroid.carros.Fragments;


import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.webkit.JavascriptInterface;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.ProgressBar;


        import br.com.livrosandroid.carros.R;


public class SiteLivroFragment extends BaseFragment {

    protected SwipeRefreshLayout swipeLayout;
    private static final String URL_SOBRE="http://www.livroandroid.com.br/sobre.htm";
    private WebView webview;
    private ProgressBar progress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_site_livro, container, false);

        //outro possivel codigo --

        View view = inflater.inflate(R.layout.fragment_site_livro, container, false);


        webview = (WebView) view.findViewById(R.id.webview);
        progress =(ProgressBar) view.findViewById(R.id.progress);
        setWebViewClient(webview);

        configJavaScript();
        //Carrega a página
        webview.loadUrl(URL_SOBRE);

         //SWIPE TO REFRESH -- ATUALIZA OS DADOS DA LISTA.
        swipeLayout =(SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(OnRefreshListener());
        swipeLayout.setColorSchemeColors(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3);


        return view;

    }

    private void configJavaScript() {
        WebSettings settings = webview.getSettings();
        // Ativa o javascript na página
        settings.setJavaScriptEnabled(true);
        // Publica a interface para o javascript
        webview.addJavascriptInterface(new LivroAndroidInterface(), "LivroAndroid");
        // Configura o webview
    }

    class LivroAndroidInterface {
        @JavascriptInterface
        public void sobre() {
            toast("Clicou na figura do livro!");
        }
    }



    private SwipeRefreshLayout.OnRefreshListener OnRefreshListener(){
        return new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                webview.reload();// Atualiza a página
            }
        };
    }




    private void setWebViewClient (WebView webview){
        webview.setWebViewClient(new WebViewClient(){
          @Override
            public void onPageStarted(WebView webview,String url,Bitmap favicon){
              super.onPageStarted(webview,url,favicon);
              //Liga o Progress
              progress.setVisibility(View.VISIBLE);
          }
          @Override
            public void onPageFinished(WebView webview, String url){
              // Desliga o Progress
              progress.setVisibility(View.INVISIBLE);
              swipeLayout.setRefreshing(false);
          }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                Log.d("Livroandroid" , "Webview url: " + url);
                if(url != null && url.endsWith("sobre.htm")){
                    AboutDialog.showAbout(getFragmentManager());
                    //toast("Clicou em mais informaçoes ");
                    // RETORNA TRUE para informar q interceptamos o evento
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
    }


}
