package com.saurabh.GNI;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Notification;
import android.app.NotificationManager;

import java.io.File;
import java.sql.Time;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private InterstitialAd interstitial;
    private WebView mwebView;
    NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mwebView = (WebView) findViewById(R.id.myWebView);
        WebSettings webSettings = mwebView.getSettings();
        mwebView.setInitialScale(1);

        webSettings.setJavaScriptEnabled(true);
        mwebView.getSettings().setLoadWithOverviewMode(true);
        mwebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mwebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mwebView.getSettings().setAppCacheEnabled(true);
        mwebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mwebView.getSettings().setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        mwebView.clearHistory();
        mwebView.clearFormData();
        mwebView.clearCache(true);
        mwebView.loadUrl("http://gnitc-csedept.blogspot.in");
        mwebView.setWebViewClient(new MyWebViewClient());

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-2217594665875771/6783145845");

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


         if (id == R.id.AboutCse){
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/blog-page.html");
        } else if (id == R.id.fp) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/profiles.html");
        } else if (id == R.id.materials) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/course-files.html");
        } else if (id == R.id.activities) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/value-added-programs-department-engages.html");
        } else if (id == R.id.gallery) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/photo-gallery-honble-shri-e.html");
        } else if (id == R.id.events) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/events.html");
        } else if (id == R.id.ed) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/examinations.html");
        }else if (id == R.id.it) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/innovations-and-technology.html");
        } else if (id == R.id.kb) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/knowledge-bank.html");
        }else if (id == R.id.placements) {
            mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/placements.html");
        }else if (id == R.id.cdntr) {
             mwebView.loadUrl("http://gnitc-csedept.blogspot.in/p/coordinators.html");
         }else if (id == R.id.Contactus) {
             mwebView.loadUrl("http://gniindia.org/contact_address.html");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("gnitc-csedept.blogspot.in")) {
                return false;
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

        }
        ProgressDialog progressDialog = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);

        }


        @Override
        public void onPageFinished(WebView view, String url) {

            progressDialog.dismiss();
            super.onPageFinished(view, url);

        }

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        try {
            trimCache(getApplicationContext());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void trimCache(Context context) {
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

}

