package coop.nofuemagia.elgermen;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

public class PantallaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ConfigurarMenu(navigationView);
    }

    private void ConfigurarMenu(NavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_actividades).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_bookmark).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_libro_x_libro).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_book).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_calendario).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_calendar).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_recomendaciones).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_comments).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_redes).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_facebook).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_notas).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_newspaper_o).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_mapas).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_map).colorRes(R.color.colorPrimary));
        menu.findItem(R.id.nav_como_llegar).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_map_signs).colorRes(R.color.colorPrimary));
//        menu.findItem(R.id.nav_cerrar_sesion).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_close).colorRes(R.color.colorPrimary));
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
        getMenuInflater().inflate(R.menu.pantalla_principal, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment;
        Class fragmentClass = ActividadesFragment.class;

        if (id == R.id.nav_actividades) {
            // Handle the camera action
        } else if (id == R.id.nav_libro_x_libro) {
            fragmentClass = LibroPorLibroFragment.class;
        } else if (id == R.id.nav_calendario) {

        } else if (id == R.id.nav_recomendaciones) {

        } else if (id == R.id.nav_redes) {

        } else if (id == R.id.nav_notas) {

        } else if (id == R.id.nav_mapas) {

        } else if (id == R.id.nav_como_llegar) {

        }

        fragment = (Fragment.instantiate(this, fragmentClass.getName()));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
