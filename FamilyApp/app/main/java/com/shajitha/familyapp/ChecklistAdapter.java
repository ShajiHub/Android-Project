package com.shajitha.familyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import static com.shajitha.familyapp.ChecklistItems.imageLayout;
import static com.shajitha.familyapp.ChecklistItems.listLayout;

public class ChecklistAdapter extends RecyclerView.Adapter {


    List<ChecklistItems> itemClassList;


    public ChecklistAdapter(List<ChecklistItems> itemClassList)
    {
        this.itemClassList = itemClassList;
    }


    //setLayout based on layoutType
    @Override
    public int getItemViewType(int position)
    {
        switch (itemClassList.get(position).getchooseLayout()) {
            case 1:
                return listLayout;
            case 2:
                return imageLayout;
            default:
                return -1;
        }
    }


    class listLayoutViewHolder extends RecyclerView.ViewHolder {

        private TextView textview;
        private LinearLayout linearLayout;

        public listLayoutViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // Find the Views
            textview = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }

        private void setView(String text)
        {
            textview.setText(text);
        }
    }


    class imageLayoutTwoViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView text1;
        private LinearLayout linearLayout;

        public imageLayoutTwoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            text1 = itemView.findViewById(R.id.text1);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }

        private void setViews(int image, String textOne)
        {
            img.setImageResource(image);
            text1.setText(textOne);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        switch (viewType) {
            case listLayout:
                View firstLayout = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.text_layout, parent, false);
                return new listLayoutViewHolder(firstLayout);

            case imageLayout:
                View secondLayout = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.image_and_text_layout, parent, false);
                return new imageLayoutTwoViewHolder(secondLayout);

            default:
                return null;
        }
    }

    // set views

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {

        switch (itemClassList.get(position).getchooseLayout()) {
            case listLayout:
                String text = itemClassList.get(position).getText();
                ((listLayoutViewHolder)holder).setView(text);
                break;

            case imageLayout:

                int img = itemClassList.get(position).getimg();
                String dispText = itemClassList.get(position).getdispText();
                ((imageLayoutTwoViewHolder)holder).setViews(img, dispText);
                break;

            default:
                return;
        }
    }
    @Override
    public int getItemCount()
    {
        return itemClassList.size();
    }
}

