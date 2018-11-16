package com.example.tungc.myfyp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mCategory;
    int[] mImage;

    public ImageAdapter(Context c, String[] cat, int[] img) {
        this.mContext = c;
        this.mCategory = cat;
        this.mImage = img;
    }

    public int getCount() {
        return mCategory.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gridview, null);
        }
        //get view
        TextView catview = (TextView) convertView.findViewById(R.id.cat);
        ImageView imgview = (ImageView) convertView.findViewById(R.id.img);
        //asign data
        catview.setText(mCategory[position]);
        imgview.setImageResource(mImage[position]);

        return convertView;
    }

}