package com.example.a44602569838.spacekids.game;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a44602569838.spacekids.R;

public class Fase1 extends AppCompatActivity {

    ImageView num6_vermelho, num6_verde, num6_azul;
    ImageView num_resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);
        findViews();

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

                    if (imageView.getId() != R.id.numero_seis) {
                        Toast.makeText(Fase1.this, "RESPOSTA ERRADA TENTE NOVAMENTE", Toast.LENGTH_SHORT).show();
                    } else {
                        ((ImageView) view).setImageDrawable(getResources().getDrawable(R.drawable.cards4_fase2));
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("", String.valueOf(view.getId()));
                    break;
            }
            return true;
        }
    }

}
