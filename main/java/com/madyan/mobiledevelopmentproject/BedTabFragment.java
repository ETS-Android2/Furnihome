package com.madyan.mobiledevelopmentproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BedTabFragment extends Fragment
{
    private ArrayList<Furniture> bedsList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HomeActivity activity = (HomeActivity) getActivity();
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.beds_tab_fragment, container, false);
        getActivity();
        bedsList = new ArrayList<>();
        FurnitureAdapter adapter = new FurnitureAdapter(root.getContext(),R.layout.list_item, bedsList);
        ListView listview = root.findViewById(R.id.beds_list);
        listview.setAdapter(adapter);
        Resources res = getResources();
        String[] allBeds = res.getStringArray(R.array.Beds);
        String[] allBedsPrice = res.getStringArray(R.array.Bed_Prices);
        String[] allBedDescriptions = res.getStringArray(R.array.Bed_descriptions);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), FurnitureDetails.class);
                intent.putExtra("USERNAME", activity.getUsername());
                intent.putExtra("FurnitureItem", (Parcelable) bedsList.get(i));
                startActivity(intent);
            }
        });

        populateBedsList(allBeds, allBedsPrice, allBedDescriptions);

        return root;
    }

    public void populateBedsList(String[] beds, String[] prices, String[] description)
    {
        bedsList.add(new Furniture(beds[0], prices[0], R.drawable.rocking_bed, description[0]));
        bedsList.add(new Furniture(beds[1], prices[1], R.drawable.shaded_double_bed, description[1]));
        bedsList.add(new Furniture(beds[2], prices[2], R.drawable.round_bed, description[2]));
        bedsList.add(new Furniture(beds[3], prices[3], R.drawable.student_desk_bed, description[3]));
        bedsList.add(new Furniture(beds[4], prices[4], R.drawable.suspended_bed, description[4]));
        bedsList.add(new Furniture(beds[5], prices[5], R.drawable.kids_bunk_bed, description[5]));
        bedsList.add(new Furniture(beds[6], prices[6], R.drawable.dark_grain_wood_bed, description[6]));
    }
}
