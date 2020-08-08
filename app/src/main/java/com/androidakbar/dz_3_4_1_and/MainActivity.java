package com.androidakbar.dz_3_4_1_and;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private Spinner spnLanguage;
    private Spinner spnTheme;
    private String selectedLanguage;
    private int selectTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        ((Button)findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(selectedLanguage);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                ThemeUtils.changeToTheme(MainActivity.this, selectTheme);
            }
        });
    }

    private void initView() {
        appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));

        spnLanguage = findViewById(R.id.spn_language);
        initSpnLanguage();

        spnTheme = findViewById(R.id.spn_theme);
        initSpnTheme();

    }

    private void initSpnTheme() {
        ArrayAdapter<CharSequence> adpTheme = ArrayAdapter.createFromResource(MainActivity.this, R.array.sa_theme, R.layout.support_simple_spinner_dropdown_item);
        spnTheme.setAdapter(adpTheme);

        spnTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] theme = getResources().getStringArray(R.array.sa_theme);
                if (theme[i].equals(getResources().getString(R.string.str_name_theme_black))) {
                    selectTheme = R.style.BlackTheme;
                } else if (theme[i].equals(getResources().getString(R.string.str_name_theme_green))) {
                    selectTheme = R.style.GreenTheme;
                } else {
                    selectTheme = R.style.BlueTheme;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initSpnLanguage() {
        ArrayAdapter<CharSequence> adpLanguage = ArrayAdapter.createFromResource(MainActivity.this, R.array.sa_language, R.layout.support_simple_spinner_dropdown_item);
        spnLanguage.setAdapter(adpLanguage);

        spnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.sa_language);
                if (languages[i].equals(getResources().getString(R.string.str_name_local_ru))) {
                    selectedLanguage = "ru";
                } else {
                    selectedLanguage = "en";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}