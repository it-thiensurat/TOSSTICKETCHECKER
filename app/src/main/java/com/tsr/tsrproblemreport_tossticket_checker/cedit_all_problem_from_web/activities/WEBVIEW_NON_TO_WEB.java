package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


        import android.graphics.Bitmap;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.ProgressBar;

        import com.tsr.tsrproblemreport_tossticket_checker.R;

public class WEBVIEW_NON_TO_WEB extends AppCompatActivity {
    WebView webView;
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_non_to_wab);
        webView = (WebView) findViewById(R.id.webView);
        bar=(ProgressBar) findViewById(R.id.progressBar2);
        webView.setWebViewClient(new myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real.php?InformID=6105000001&Contno=70102488&CashTeamCode=10601078&InformEmpID=A27643&InformDepartID=AL&AdminEmpID=NULL&AdminDepartID=NULL&user_code=A07407&ipaddress=192.168.43.9&computername=Acer+B1-723+5.1+LOLLIPOP&NoteData=NULL&InformStatus=1&Outstanding=null&CustomerStatus=null&AccountStatus=null&PayLastPeriod=null");


    }

    public class myWebclient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            bar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
