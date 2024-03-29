package com.android.uraall.carsdbwithroomstartercode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.Car;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Car> cars;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView priceTextView;


        public MyViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            priceTextView = view.findViewById(R.id.priceTextView);
        }
    }


    public CarsAdapter(Context context, ArrayList<Car> cars, MainActivity mainActivity) {
        this.context = context;
        this.cars = cars;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Car car = cars.get(position);

        holder.nameTextView.setText(car.getName());
        holder.priceTextView.setText(car.getPrice() + " $");

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                mainActivity.addAndEditCars(true, car, position);
            }
        });

    }

    @Override
    public int getItemCount() {

        return cars.size();
    }


}
