package com.example.a44602569838.spacekids.game;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.controller.SelecionarCriancasActivity;
import com.example.a44602569838.spacekids.model.Desempenho;
import com.example.a44602569838.spacekids.rest.RestInterface;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import es.dmoral.toasty.Toasty;

public class Fase1 extends AppCompatActivity {

    ImageView num6_vermelho, num6_verde, num6_azul;
    ImageView num_resposta;
    Desempenho desempenho = new Desempenho();
    int criancaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);
        findViews();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            criancaId = extras.getInt("criancaId");
        }
        desempenho.setHoraInicial(df.format(new Date(Calendar.getInstance().getTimeInMillis())));
    }

    public void findViews() {
        num6_vermelho = findViewById(R.id.numero_seis);
        num6_verde = findViewById(R.id.numero_seis_verde);
        num6_azul = findViewById(R.id.numero_seis_azul);

        num_resposta = findViewById(R.id.numero_q_3);

        //Evento de arrastar e soltar
        num6_vermelho.setOnTouchListener(new ChoiceTouchListener());
        num6_vermelho.setOnDragListener(new ChoiceDragListener());

        num6_verde.setOnTouchListener(new ChoiceTouchListener());
        num6_verde.setOnDragListener(new ChoiceDragListener());

        num6_azul.setOnTouchListener(new ChoiceTouchListener());
        num6_azul.setOnDragListener(new ChoiceDragListener());

        num_resposta.setOnTouchListener(new ChoiceTouchListener());
        num_resposta.setOnDragListener(new ChoiceDragListener());


    }

    private final class ChoiceTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if ((motionEvent.getAction() == MotionEvent.ACTION_DOWN) && ((ImageView) view).getDrawable() != null) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);

                return true;
            }
            return false;
        }
    }

    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("", "FOI DROPADO NO ACTION_DRAG_STARTED");
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("", "FOI DROPADO NO ACTION_DRAG_ENTERED");
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("", "FOI DROPADO NO ACTION_DRAG_EXITED");
                    break;

                case DragEvent.ACTION_DROP:
                    ImageView imageView = (ImageView) dragEvent.getLocalState();
                    ImageView ouvinte = (ImageView) view;


                    @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if (imageView.getId() == R.id.numero_seis) {
                        if (ouvinte.getId() != R.id.numero_seis_azul && ouvinte.getId() != R.id.numero_seis_verde && ouvinte.getId() != R.id.numero_seis) {
                            desempenho.setAcertou(true);
                            desempenho.setCriancaID(criancaId);
                            desempenho.setFaseID(1);
                            desempenho.setHoraFinal(df.format(new Date(Calendar.getInstance().getTimeInMillis())));
                            enviarDesempenho();
                            new MaterialStyledDialog.Builder(Fase1.this)
                                    .setTitle("Fántastico !!!")
                                    .setDescription("Parabéns você acertou por favor ir para a próxima fase")
                                    .setIcon(R.drawable.trofeu)
                                    .setPositiveText("Próximo")
                                    .onPositive((dialog, which) -> {
                                        Intent i = new Intent(getBaseContext(), Fase2.class);
                                        i.putExtra("criancaId", criancaId);
                                        startActivity(i);
                                        finish();
                                    })
                                    .setCancelable(false)
                                    .setNegativeText("Sair")
                                    .onNegative((dialog, which) -> {
                                        Intent i = new Intent(getBaseContext(), SelecionarCriancasActivity.class);
                                        startActivity(i);
                                        finish();
                                    })
                                    .setHeaderColor(R.color.verde)
                                    .setStyle(Style.HEADER_WITH_ICON).show();
                        }
                    } else {
                        if (ouvinte.getId() != R.id.numero_seis_azul && ouvinte.getId() != R.id.numero_seis_verde && ouvinte.getId() != R.id.numero_seis && ouvinte.getId() != R.id.numero_q_3) {
                            desempenho.setAcertou(false);
                            desempenho.setCriancaID(criancaId);
                            desempenho.setFaseID(1);
                            desempenho.setHoraFinal(df.format(new Date(Calendar.getInstance().getTimeInMillis())));
                            enviarDesempenho();
                            new MaterialStyledDialog.Builder(Fase1.this)
                                    .setTitle("Ops...")
                                    .setDescription("Que pena você errou por favor va para a próxima fase")
                                    .setIcon(R.drawable.ic_error_outline_white_48dp)
                                    .setPositiveText("Próximo")
                                    .onPositive((dialog, which) -> {
                                        Intent i = new Intent(getBaseContext(), Fase2.class);
                                        i.putExtra("criancaId", criancaId);
                                        startActivity(i);
                                        finish();
                                    })
                                    .setCancelable(false)
                                    .setNegativeText("Sair")
                                    .onNegative((dialog, which) -> {
                                        Intent i = new Intent(getBaseContext(), SelecionarCriancasActivity.class);
                                        startActivity(i);
                                        finish();
                                    })
                                    .setHeaderColor(R.color.vermelho)
                                    .setStyle(Style.HEADER_WITH_ICON).show();
                        }
                    }


                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }

    public void enviarDesempenho() {
        SharedPreferences preferences = getSharedPreferences("spacekids", MODE_PRIVATE);
        final String tokenAuth = preferences.getString("token", "");

        OkHttpClient defaultHttpClient = new OkHttpClient.Builder().addInterceptor((chain) -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", tokenAuth).build();
            return chain.proceed(request);
        }).build();

        Retrofit.Builder builder = new Retrofit.Builder().client(defaultHttpClient).baseUrl("http://spacekids-001-site1.dtempurl.com").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RestInterface restInterface = retrofit.create(RestInterface.class);

        Call<ResponseBody> call = restInterface.cadastrarDesempenho(desempenho);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("Desempenho", desempenho.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
