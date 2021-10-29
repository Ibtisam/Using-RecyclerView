package com.example.usingrecyclerview;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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