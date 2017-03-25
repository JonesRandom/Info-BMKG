package masxdeveloper.infobmkg;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import masxdeveloper.infobmkg.MyFragment.InfoGempaDirasakan;
import masxdeveloper.infobmkg.MyFragment.InfoGempaTerkini;
import masxdeveloper.infobmkg.MyFragment.InfoPrakiraanCuaca;
import masxdeveloper.infobmkg.MyInterfaces.FilterPencarianListener;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnFocusChangeListener {

    @BindView(R.id.Toolbar)
    Toolbar MyToolbar;

    @BindView(R.id.drawerItem)
    DrawerLayout drawerLayout;

    @BindView(R.id.navItem)
    NavigationView navigationView;

    ActionBarDrawerToggle drawerToggle;
    FilterPencarianListener pencarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initDrawer();
        initNavigation();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new InfoGempaDirasakan()).commit();
        }
    }

    private void initDrawer() {
        setSupportActionBar(MyToolbar);
        MyToolbar.setTitle("Info Gempa");
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, MyToolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        drawerToggle.syncState();

    }

    private void initNavigation() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment f = null;
                Class fClass = null;
                switch (item.getItemId()) {
                    case R.id.nav_gempa:
                        fClass = InfoGempaDirasakan.class;
                        break;
                    case R.id.nav_gempa_terkini:
                        fClass = InfoGempaTerkini.class;
                        break;
                    case R.id.nav_Prakiraan:
                        fClass = InfoPrakiraanCuaca.class;
                        break;
                }

                try {
                    if (fClass != null) {
                        f = (Fragment) fClass.newInstance();
                    }

                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                MyToolbar.setTitle(item.getTitle());
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentContainer, f).commit();
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);

        MenuItem search = menu.findItem(R.id.menu_pencarian);
        SearchView searchView = (SearchView)search.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setOnQueryTextFocusChangeListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        pencarian.OnPencarianQuery(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        pencarian.OnPencarianQuery(newText);
        return true;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        pencarian.OnPencarianFokusListener(b);
    }

    public void DataPencarian(FilterPencarianListener pencarians){
        pencarian = pencarians;
    }

}
