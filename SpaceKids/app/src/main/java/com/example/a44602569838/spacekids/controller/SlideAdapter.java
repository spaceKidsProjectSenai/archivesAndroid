package com.example.a44602569838.spacekids.controller;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a44602569838.spacekids.R;

/**
 * Created by 44602569838 on 28/02/2018.
 */

public class SlideAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3
    };

    public String[] slide_headings = {
            "HEAD",
            "SLEEP",
            "CODE"
    };

    public String[] slide_descs = {
      "Na Space Kids, você pode proporcionar muita diversão para o seu filho.",
      "Acompanhe o desempenho do seu filho.",
      "Cadastre-se e adicione quantos jogadores quiser"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);


        ImageView slideImageView = view.findViewById(R.id.jogo_1);
        TextView slideHeading = view.findViewById(R.id.slide_desc);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }
}
