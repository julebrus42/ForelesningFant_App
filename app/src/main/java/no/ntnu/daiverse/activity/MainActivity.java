package no.ntnu.daiverse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import no.ntnu.daiverse.R;
import no.ntnu.daiverse.fragment.ItemsFragment;
import no.ntnu.daiverse.fragment.LoginFragment;
import no.ntnu.daiverse.fragment.RegisterFragment;
import no.ntnu.daiverse.preference.UserPrefs;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private Menu navMenu;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navMenu = navigationView.getMenu();

        updateOnStartUp();

       /* FragmentManager fm = getSupportFragmentManager();
        ItemsFragment itemsFragment = new ItemsFragment();
        fm.beginTransaction().replace(R.id.fragment_contatiner, itemsFragment).commit();*/

        //  Set which fragment to run when the app opens
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,
                    new ItemsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_items);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_items:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,
                        new ItemsFragment()).commit();
                break;

            case R.id.nav_register:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,
                        new RegisterFragment()).commit();
                break;


            case R.id.nav_login:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,
                        new LoginFragment()).commit();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public void updateOnStartUp() {

        UserPrefs userPrefs = new UserPrefs(getApplicationContext());

        if (userPrefs.getToken().isEmpty()) {
            navMenu.findItem(R.id.nav_items).setVisible(true);
            navMenu.findItem(R.id.nav_login).setVisible(true);
            navMenu.findItem(R.id.nav_register).setVisible(true);
        }

        else {
            navMenu.findItem(R.id.nav_items).setVisible(true);
            navMenu.findItem(R.id.nav_login).setVisible(false);
            navMenu.findItem(R.id.nav_register).setVisible(false);
        }

    }
}