package com.example.tattlerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FeaturesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView tattler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tattler = (WebView) findViewById(R.id.web);
        tattler.setWebViewClient(new WebViewClient());
        tattler.getSettings().setJavaScriptEnabled(true);
        tattler.loadUrl("http://www.ihstattler.com/blog/category/features/");
    }


    @Override
    public void onBackPressed() {
        if (tattler.canGoBack()) {
            tattler.goBack();
        } else {
            finish();
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
            Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch(id) {
            case R.id.main:
                Intent h = new Intent(FeaturesActivity.this, MainActivity.class);
                startActivity(h);
                break;
            case R.id.news:
                Intent i = new Intent(FeaturesActivity.this, NewsActivity.class);
                startActivity(i);
                break;
            case R.id.opinion:
                Intent j = new Intent(FeaturesActivity.this, OpinionActivity.class);
                startActivity(j);
                break;
            case R.id.features:
                Intent k = new Intent(FeaturesActivity.this, FeaturesActivity.class);
                startActivity(k);
                break;
            case R.id.centerspread:
                Intent l = new Intent(FeaturesActivity.this, CenterSpreadActivity.class);
                startActivity(l);
                break;
            case R.id.literary:
                Intent m = new Intent(FeaturesActivity.this, LiteraryActivity.class);
                startActivity(m);
                break;
            case R.id.arts:
                Intent n = new Intent(FeaturesActivity.this, ArtsActivity.class);
                startActivity(n);
                break;
            case R.id.sports:
                Intent o = new Intent(FeaturesActivity.this, SportsActivity.class);
                startActivity(o);
                break;
            case R.id.backpage:
                Intent p = new Intent(FeaturesActivity.this, BackpageActivity.class);
                startActivity(p);
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
