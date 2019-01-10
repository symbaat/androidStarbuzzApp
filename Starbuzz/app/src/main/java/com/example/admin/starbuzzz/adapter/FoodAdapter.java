package com.example.admin.starbuzzz.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.model.Drink;
import com.example.admin.starbuzzz.model.Food;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ItemViewHolder> {

    List<Food> mFoodList;
    Context mContext;

    public FoodAdapter(List<Food> drinkList, Context mContext) {
        this.mFoodList = drinkList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mFoodList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.ivStar)
        ImageView ivStar;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Food food) {
            name.setText(food.name);

            final SharedPreferences sharedPreferences = mContext.getSharedPreferences("starbuzz", 0);
            if (sharedPreferences.getBoolean(food.getName(), false)) {
                ivStar.setBackgroundResource(R.drawable.ic_star);
            } else {
                ivStar.setBackgroundResource(R.drawable.ic_empty_star);
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sharedPreferences.getBoolean(food.getName(), false)) {
                        ivStar.setBackgroundResource(R.drawable.ic_empty_star);
                        food.setFavourite(false);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(food.getName(), false);
                        editor.apply();

                        Log.d("ADA", food.getName());

                    } else {
                        ivStar.setBackgroundResource(R.drawable.ic_star);
                        food.setFavourite(true);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(food.name, true);
                        editor.apply();

                        Log.d("ADA", food.getName());
                    }
                }
            });
        }
    }

}
