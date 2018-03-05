package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a44602569838.spacekids.R;

public class InicioActivity extends AppCompatActivity {

    private LinearLayout mDotLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //FindViwes
        ViewPager mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        Button btnCadastro = findViewById(R.id.btnCadastro);
        Button btnLogin = findViewById(R.id.btnLogin);

        SlideAdapter slideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicador(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


        //Chama a tela de cadastro quando clicado no botão
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(getBaseContext(), CadastroActivity.class);
                startActivity(cadastro);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(login);
            }
        });
    }

    public void addDotsIndicador(int position) {
        TextView[] mDots = new TextView[3];
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.amareloDark));

            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.amareloDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicador(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
