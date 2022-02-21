package com.madyan.mobiledevelopmentproject;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;

public class ChairTabFragment extends Fragment
{
    private ArrayList<Furniture> chairsList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HomeActivity activity = (HomeActivity) getActivity();
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.chairs_tab_fragment, container, false);
        chairsList = new ArrayList<>();
        FurnitureAdapter adapter = new FurnitureAdapter(root.getContext(),R.layout.list_item, chairsList);
        ListView listview = root.findViewById(R.id.chair_list);
        listview.setAdapter(adapter);

        Resources res = getResources();
        String[] allChairs = res.getStringArray(R.array.Chairs);
        String[] allChairsPrice = res.getStringArray(R.array.Chairs_Price);
        String[] allChairsDescription = res.getStringArray(R.array.Chairs_description);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), FurnitureDetails.class);
                intent.putExtra("USERNAME", activity.getUsername());
                intent.putExtra("FurnitureItem", (Parcelable) chairsList.get(i));
                startActivity(intent);
            }
        });

        populateChairsList(allChairs, allChairsPrice, allChairsDescription);

        return root;
    }

    public void populateChairsList(String[] chairs, String[] prices, String[] description)
    {
        chairsList.add(new Furniture(chairs[0], prices[0], R.drawable.modern_chair, description[0]));
        chairsList.add(new Furniture(chairs[1], prices[1], R.drawable.couch, description[1]));
        chairsList.add(new Furniture(chairs[2], prices[2], R.drawable.arm_chair, description[2]));
        chairsList.add(new Furniture(chairs[3], prices[3], R.drawable.leather_chair, description[3]));
        chairsList.add(new Furniture(chairs[4], prices[4], R.drawable.office_chair, description[4]));
        chairsList.add(new Furniture(chairs[5], prices[5], R.drawable.folding_chair, description[5]));
        chairsList.add(new Furniture(chairs[6], prices[6], R.drawable.beanbag_chair, description[6]));
        chairsList.add(new Furniture(chairs[7], prices[7], R.drawable.single_sofa_chair, description[7]));
        chairsList.add(new Furniture(chairs[8], prices[8], R.drawable.sun_chair, description[8]));
        chairsList.add(new Furniture(chairs[9], prices[9], R.drawable.rocking_chair, description[9]));
    }
}
