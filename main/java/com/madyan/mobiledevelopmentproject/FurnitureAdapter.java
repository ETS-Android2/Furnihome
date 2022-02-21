package com.madyan.mobiledevelopmentproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FurnitureAdapter extends ArrayAdapter<Furniture>
{
    private ArrayList<Furniture> furnitureList;

    public FurnitureAdapter(@NonNull Context context, int resource, ArrayList<Furniture> furnitureList) {
        super(context, resource, furnitureList);
        this.furnitureList = furnitureList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView furnitureImage = convertView.findViewById(R.id.furniture_imageview);
        TextView furnitureTitle = convertView.findViewById(R.id.furniture_textview);
        TextView furniturePrice = convertView.findViewById(R.id.furniture_price);
        furnitureImage.setImageResource(furnitureList.get(position).getFurnitureImageId());
        furnitureTitle.setText(furnitureList.get(position).getFurniture());
        furniturePrice.setText(furnitureList.get(position).getFurniturePrice());
        return convertView;
    }
}
