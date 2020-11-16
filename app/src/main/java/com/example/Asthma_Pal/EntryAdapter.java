package com.example.Asthma_Pal;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EntryAdapter extends ArrayAdapter<JournalEntry> {

    private Context mContext;
    private int mResource;

    public EntryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<JournalEntry> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String Date = getItem(position).getDate();
        String Cough = getItem(position).getCough();
        String Wheeze = getItem(position).getWheeze();
        String Chest = getItem(position).getChest();
        String Sleep = getItem(position).getSleep();
        String Exercise = getItem(position).getExcercise();
        String Meds = getItem(position).getMeds();

        JournalEntry entry = new JournalEntry(Date, Cough, Wheeze, Chest, Sleep, Exercise,Meds);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView Tdate = (TextView) convertView.findViewById(R.id.tvDate);
        TextView Tcough = (TextView) convertView.findViewById(R.id.tvCough);
        TextView Twheeze =(TextView) convertView.findViewById(R.id.tvWheeze);
        TextView Tchest = (TextView) convertView.findViewById(R.id.tvChest);
        TextView Tsleep = (TextView) convertView.findViewById(R.id.tvSleep);
        TextView Texercise = (TextView) convertView.findViewById(R.id.tvExercise);
        TextView Tmeds = (TextView) convertView.findViewById(R.id.tvMeds);

        Tdate.setText(Date);
        Tcough.setText(Cough);
        Twheeze.setText(Wheeze);
        Tsleep.setText(Sleep);
        Tchest.setText(Chest);
        Texercise.setText(Exercise);
        Tmeds.setText(Meds);

        return convertView;
    }
}
