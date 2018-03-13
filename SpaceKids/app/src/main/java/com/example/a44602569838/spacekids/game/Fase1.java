package com.example.a44602569838.spacekids.game;

import android.content.ClipData;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.a44602569838.spacekids.R;

public class Fase1 extends AppCompatActivity {

    ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);

        iv1 = findViewById(R.id.slide_1);
        iv2 = findViewById(R.id.slide_2);

        iv1.setOnTouchListener(new ChoiceTouchListener());
        iv1.setOnDragListener(new ChoiceDragListener(1));
        iv2.setOnTouchListener(new ChoiceTouchListener());
        iv2.setOnDragListener(new ChoiceDragListener(2));

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

        private int ID;

        public ChoiceDragListener(int ID) {
            this.ID = ID;
        }

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("viewID",  String.valueOf(ID));
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:

                    break;

                case DragEvent.ACTION_DRAG_EXITED:

                    break;

                case DragEvent.ACTION_DROP:

                    ImageView imageView = (ImageView) dragEvent.getLocalState();
                    ((ImageView) view).setImageDrawable(getResources().getDrawable(R.drawable.slide1));
                    imageView.setImageDrawable(null);

                    break;

                case DragEvent.ACTION_DRAG_ENDED:

                    break;
            }
            return true;
        }
    }

}
