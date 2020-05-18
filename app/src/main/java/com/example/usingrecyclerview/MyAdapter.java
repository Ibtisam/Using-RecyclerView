package com.example.usingrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    // Create new views (invoked by the layout manager)
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        TextView textV = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item_rv, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(textV);
        return viewHolder;
    }

    @Override
    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset[position]);
    }

    @Override
    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return mDataset.length;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(@NonNull TextView tV) {
            super(tV);
            textView = tV;
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //you can use Shared ViewModel here
            Toast.makeText(v.getContext(), "You Pressed: "+((TextView)v).getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
