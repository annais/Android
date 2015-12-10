package com.example.anais.basketball;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class TeamActivity extends AppCompatActivity {

    static int pestaña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        configToolbar();
        configViewPager();
    }

    // Configura la Toolbar.
    private void configToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    // Configura el ViewPager.
    private void configViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(TabFragment.newInstance(getResources().getColor(R.color.colorPrimary)),
                "Home", R.drawable.balon);
        viewPagerAdapter.addFragment(TabFragment.newInstance(getResources().getColor(R.color.colorAccent)),
                "Guest", R.drawable.balon);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pestaña = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    // Adaptador para el ViewPager.
    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();
        private final List<Integer> mFragmentIcons = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Añade un fragmento al adaptador. Recibe el fragmento, el título
        // para la tab y el icono para la tab.
        public void addFragment(Fragment fragment, String title,
                                @DrawableRes int resIdIcon) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
            mFragmentIcons.add(resIdIcon);
        }

        // Retorna el fragmento correspondiente a la posición recibida.
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        // Retorna el número de fragmentos del adaptador.
        @Override
        public int getCount() {
            return mFragments.size();
        }

        // Retorna el título asociado a una determinada página.
        @Override
        public CharSequence getPageTitle(int position) {
            return " " + mFragmentTitles.get(position);
        }

        // Retorna el resId del icono asociado a una determinada página.
        @DrawableRes
        public int getPageIcon(int position) {
            return mFragmentIcons.get(position);
        }

    }

}
