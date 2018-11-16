package com.example.tungc.myfyp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt,typeTxt,weightTxt,priceTxt,addressTxt,contactTxt,tel_noTxt,emailTxt,descTxt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nameTxt = (TextView) findViewById(R.id.nameTxtDetail);
        typeTxt = (TextView) findViewById(R.id.typeTxtDetail);
        weightTxt = (TextView) findViewById(R.id.weighTxtDetail);
        priceTxt = (TextView) findViewById(R.id.priceTxtDetail);
        addressTxt = (TextView) findViewById(R.id.addressTxtDetail);
        contactTxt = (TextView) findViewById(R.id.con_perTxtDetail);
        tel_noTxt = (TextView) findViewById(R.id.telnoTxtDetail);
        emailTxt = (TextView) findViewById(R.id.emailTxtDetail);
        descTxt = (TextView) findViewById(R.id.descDetailTxt);
        img = (ImageView) findViewById(R.id.ImageDetail);

        Intent i= this.getIntent();
        String company=i.getExtras().getString("COMPANY_KEY");
        String type=i.getExtras().getString("TYPE_KEY");
        String weight=i.getExtras().getString("WEIGHT_KEY");
        String price=i.getExtras().getString("PRICE_KEY");
        String address=i.getExtras().getString("ADDRESS_KEY");
        String contact_person=i.getExtras().getString("CONTACT_PERSON_KEY");
        String tel_no=i.getExtras().getString("TEL_NO_KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String desc=i.getExtras().getString("DESCRIPTION_KEY");


        //String desc=i.getExtras().getString("DESC_KEY");

        nameTxt.setText(company);
        typeTxt.setText(type);
        weightTxt.setText(weight);
        priceTxt.setText(price);
        addressTxt.setText(address);
        contactTxt.setText(contact_person);
        tel_noTxt.setText(tel_no);
        emailTxt.setText(email);
        descTxt.setText(desc);
        //descTxt.setText(desc);
        //PicassoClient.downloadImage(this,imageurl,img);


    }
}