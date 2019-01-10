package com.example.admin.starbuzzz.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.model.Drink;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ItemViewHolder> {

    List<Drink> mDrinkList;
    Context mContext;

    public DrinksAdapter(List<Drink> drinkList, Context mContext) {
        this.mDrinkList = drinkList;
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
        holder.bind(mDrinkList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDrinkList.size();
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

        public void bind(final Drink drink) {
            name.setText(drink.name);

            final SharedPreferences sharedPreferences = mContext.getSharedPreferences("starbuzz", 0);
            if (sharedPreferences.getBoolean(drink.getName(), false)) {
                ivStar.setBackgroundResource(R.drawable.ic_star);
            } else {
                ivStar.setBackgroundResource(R.drawable.ic_empty_star);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (sharedPreferences.getBoolean(drink.getName(), false)) {
                        ivStar.setBackgroundResource(R.drawable.ic_empty_star);
                        drink.setFavourite(false);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(drink.getName(), false);
                        editor.apply();

                        Log.d("ADA", drink.getName());

                    } else {
                        ivStar.setBackgroundResource(R.drawable.ic_star);
                        drink.setFavourite(true);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(drink.name, true);
                        editor.apply();

                        Log.d("ADA", drink.getName());
                    }
                }
            });
        }
    }

}
