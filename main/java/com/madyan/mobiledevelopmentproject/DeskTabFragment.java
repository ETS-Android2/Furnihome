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

public class DeskTabFragment extends Fragment
{
    private ArrayList<Furniture> deskList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HomeActivity activity = (HomeActivity) getActivity();
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.desk_tab_fragment, container, false);
        deskList = new ArrayList<>();
        FurnitureAdapter adapter = new FurnitureAdapter(root.getContext(),R.layout.list_item, deskList);
        ListView listview = root.findViewById(R.id.desk_list);
        listview.setAdapter(adapter);

        Resources res = getResources();
        String[] allDesks = res.getStringArray(R.array.Desks);
        String[] allDeskPrices = res.getStringArray(R.array.Desk_Prices);
        String[] allDeskDescription = res.getStringArray(R.array.Desk_descriptions);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), FurnitureDetails.class);
                intent.putExtra("USERNAME", activity.getUsername());
                intent.putExtra("FurnitureItem", (Parcelable) deskList.get(i));
                startActivity(intent);
            }
        });

        populateDeskList(allDesks, allDeskPrices, allDeskDescription);

        return root;
    }

    public void populateDeskList(String[] desks, String[] prices, String[] descriptions)
    {
        deskList.add(new Furniture(desks[0], prices[0], R.drawable.birchwood_desk, descriptions[0]));
        deskList.add(new Furniture(desks[1], prices[1], R.drawable.computer_desk, descriptions[1]));
        deskList.add(new Furniture(desks[2], prices[2], R.drawable.decorated_desk, descriptions[2]));
        deskList.add(new Furniture(desks[3], prices[3], R.drawable.front_desk, descriptions[3]));
        deskList.add(new Furniture(desks[4], prices[4], R.drawable.glass_desk, descriptions[4]));
        deskList.add(new Furniture(desks[5], prices[5], R.drawable.office_desk, descriptions[5]));
        deskList.add(new Furniture(desks[6], prices[6], R.drawable.wooden_desk, descriptions[6]));
    }
}