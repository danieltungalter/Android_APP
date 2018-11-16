package com.example.tungc.myfyp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter{

    Context c;
    ArrayList<DataObject> dataObjects;

    public ListviewAdapter(Context c, ArrayList<DataObject> dataObjects) {
        this.c = c;
        this.dataObjects = dataObjects;
    }

    @Override
    public int getCount() {
        return dataObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return dataObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView companyTxt = (TextView) convertView.findViewById(R.id.companyTxt);
        TextView typeTxt = (TextView) convertView.findViewById(R.id.typeTxt);
        TextView weightTxt = (TextView) convertView.findViewById(R.id.weighTxt);
        TextView priceTxt = (TextView) convertView.findViewById(R.id.priceTxt);
        TextView addressTxt = (TextView) convertView.findViewById(R.id.addressTxt);
        ImageView img = (ImageView) convertView.findViewById(R.id.ImageDetail);

        final DataObject d = (DataObject) this.getItem(position);
        companyTxt.setText(d.getCompany());
        typeTxt.setText(d.getType());
        weightTxt.setText(d.getWeight());
        priceTxt.setText(d.getPrice());
        addressTxt.setText(d.getAddress());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(d.getCompany(),d.getType(),d.getWeight(),d.getPrice(),d.getAddress(),d.getContact_person(),d.getTel_no(),d.getEmail(),d.getDescription());
            }
        });

        return convertView;
    }

    private void openDetailActivity(String company, String type, String weight, String price, String address, String contact_person, String tel_no, String email, String description)
    {
        Intent i =new Intent(c,DetailActivity.class);
        i.putExtra("COMPANY_KEY", company);
        i.putExtra("TYPE_KEY", type);
        i.putExtra("WEIGHT_KEY", weight);
        i.putExtra("PRICE_KEY", price);
        i.putExtra("ADDRESS_KEY", address);
        i.putExtra("CONTACT_PERSON_KEY", contact_person);
        i.putExtra("TEL_NO_KEY", tel_no);
        i.putExtra("EMAIL_KEY", email);
        i.putExtra("DESCRIPTION_KEY", description);

        c.startActivity(i);
    }

}
