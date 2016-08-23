package coop.nofuemagia.elgermen;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Tanoo on 22/8/2016.
 */
public class LibroPorLibroFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_libro_x_libro, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.sw_libro);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                mWebView.reload();
            }
        });

        mWebView = (WebView) v.findViewById(R.id.wv_libro);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.loadUrl(Util.leerMetaData(getContext(), "formulario_germen"));

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return v;
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            mSwipeRefreshLayout.setRefreshing(false);
            super.onPageFinished(view, url);
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mSwipeRefreshLayout.setRefreshing(true);
            super.onPageStarted(view, url, favicon);
        }


    }
}
