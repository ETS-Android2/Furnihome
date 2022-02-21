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

public class ShelfTabFragment extends Fragment
{
    private ArrayList<Furniture> shelfList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HomeActivity activity = (HomeActivity) getActivity();
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.shelf_tab_fragment, container, false);
        shelfList = new ArrayList<>();
        FurnitureAdapter adapter = new FurnitureAdapter(root.getContext(),R.layout.list_item, shelfList);
        ListView listview = root.findViewById(R.id.shelf_list);
        listview.setAdapter(adapter);

        Resources res = getResources();
        String[] allShelves = res.getStringArray(R.array.Shelves);
        String[] allShelfPrices = res.getStringArray(R.array.Shelf_Prices);
        String[] allShelfDescription = res.getStringArray(R.array.Shelf_descriptions);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), FurnitureDetails.class);
                intent.putExtra("USERNAME", activity.getUsername());
                intent.putExtra("FurnitureItem", (Parcelable) shelfList.get(i));
                startActivity(intent);
            }
        });

        populateShelfList(allShelves, allShelfPrices, allShelfDescription);

        return root;
    }

    public void populateShelfList(String[] shelves, String[] prices, String[] descriptions)
    {
        shelfList.add(new Furniture(shelves[0], prices[0], R.drawable.wall_mounted_shelf, descriptions[0]));
        shelfList.add(new Furniture(shelves[1], prices[1], R.drawable.big_cabinet_shelf, descriptions[1]));
        shelfList.add(new Furniture(shelves[2], prices[2], R.drawable.storage_shelf, descriptions[2]));
        shelfList.add(new Furniture(shelves[3], prices[3], R.drawable.rounded_shelf, descriptions[3]));
        shelfList.add(new Furniture(shelves[4], prices[4], R.drawable.book_shelf, descriptions[4]));
        shelfList.add(new Furniture(shelves[5], prices[5], R.drawable.modern_shelf, descriptions[5]));
        shelfList.add(new Furniture(shelves[6], prices[6], R.drawable.cabinet_shelf, descriptions[6]));
        shelfList.add(new Furniture(shelves[7], prices[7], R.drawable.display_rack_shelf, descriptions[7]));
        shelfList.add(new Furniture(shelves[8], prices[8], R.drawable.branch_book_shelf, descriptions[8]));
    }
}
