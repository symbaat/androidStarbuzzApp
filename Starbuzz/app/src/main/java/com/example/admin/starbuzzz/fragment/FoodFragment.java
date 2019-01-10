package com.example.admin.starbuzzz.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.adapter.FruitAdapter;
import com.example.admin.starbuzzz.model.Fruit;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    FruitAdapter adapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_third, container, false);
            ButterKnife.bind(this,view);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("starbuzz", 0);

            ArrayList<Fruit> fruitArrayList = new ArrayList<>();
            fruitArrayList.add(new Fruit("Damson",sharedPreferences.getBoolean("Damson", false)));
            fruitArrayList.add(new Fruit("Lychee",sharedPreferences.getBoolean("Lychee", false)));
            fruitArrayList.add(new Fruit("Mango",sharedPreferences.getBoolean("Mango", false)));
            fruitArrayList.add(new Fruit("Melon",sharedPreferences.getBoolean("Melon", false)));
            fruitArrayList.add(new Fruit("Orange",sharedPreferences.getBoolean("Orange", false)));

            onSetUpRecyclerView(fruitArrayList);
        }

        return view;
    }

    private void onSetUpRecyclerView(ArrayList<Fruit> fruitArrayList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitArrayList, getActivity());
        recyclerView.setAdapter(adapter);
    }

}
