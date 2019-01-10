package com.example.admin.starbuzzz.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.adapter.DrinksAdapter;
import com.example.admin.starbuzzz.model.Drink;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class
DrinksFragment extends Fragment {

    ArrayList<Drink> mDrinkArrayList = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    DrinksAdapter adapter;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_second, container, false);
            ButterKnife.bind(this, view);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("starbuzz", 0);

            mDrinkArrayList.add(new Drink("Wheatgrass",sharedPreferences.getBoolean("Wheatgrass", false)));
            mDrinkArrayList.add(new Drink("Grape",sharedPreferences.getBoolean("Grape", false)));
            mDrinkArrayList.add(new Drink("Aloe Vera",sharedPreferences.getBoolean("Aloe Vera", false)));
            mDrinkArrayList.add(new Drink("Apple",sharedPreferences.getBoolean("Apple", false)));
            mDrinkArrayList.add(new Drink("Claim",sharedPreferences.getBoolean("Claim", false)));

            onSetRecyclerView(mDrinkArrayList);
        }

        return view;
    }

    private void onSetRecyclerView(ArrayList<Drink> drinkArrayList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DrinksAdapter(drinkArrayList, getActivity());
        recyclerView.setAdapter(adapter);
    }
}
