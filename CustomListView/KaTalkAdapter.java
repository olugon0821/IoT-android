package com.example.customlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
public class KaTalkAdapter extends BaseAdapter {
    private static final String TAG = "KaTalkAdapter";
    private final Activity activity;
    private ArrayList<ItemData> arrayList = new ArrayList<>();

    public KaTalkAdapter(Activity activity){
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("SimpleDataFormat")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull

    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        Log.i(TAG,"getView called");
        if (convertView == null){
            Log.i(TAG,"getView: convertView == null");
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_item, parent,false);
        }
        LinearLayout linearLayout = (LinearLayout)convertView;

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int itemHeight = size.x/5;
        ViewGroup.LayoutParams params = linearLayout.getLayoutParams();
        params.height = itemHeight;
        linearLayout.setLayoutParams(params);

        ItemData itemData = arrayList.get(position);
        ImageView imageView = linearLayout.findViewById(R.id.imageView);
        TextView textViewName = linearLayout.findViewById(R.id.textViewName);
        ToggleButton toggleButton = linearLayout.findViewById(R.id.toggle);

        // 토글 상태 저장 //
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean toggled) {
                itemData.setToggle(toggled);
                notifyDataSetChanged();
            }
        });
//        TextView textViewTime = linearLayout.findViewById(R.id.textViewTime);
        TextView textViewMessage = linearLayout.findViewById(R.id.textViewMessage);
        imageView.setImageResource(itemData.getImage());
        textViewName.setText(itemData.getName());
        toggleButton.setChecked(itemData.isToggle()); // 토글 상태 불러오기
        // Date date = new Date(itemData.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        textViewTime.setText(""+simpleDateFormat.format(date));
        textViewMessage.setText(itemData.getMessage());
        return linearLayout;
    }

    public void addItem(int rid, String name, String message){
        ItemData item = new ItemData(rid, name, System.currentTimeMillis(), message);
        arrayList.add(item);
    }
}
