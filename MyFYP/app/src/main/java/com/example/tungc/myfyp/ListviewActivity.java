package com.example.tungc.myfyp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;

public class ListviewActivity extends AppCompatActivity {

    String urlAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_panel);

        String category = getIntent().getStringExtra("CATEGORY");
        urlAddress = getUrlAddress(category);

        final ListView lv = (ListView) findViewById(R.id.lv);
        final Downloader d=new Downloader(this,urlAddress,lv);
        d.execute();

    }

    public String getUrlAddress(String category) {

        String url;
        switch (category) {
            case "Paper":
                url = "http://10.0.2.2/FYP/paper.php";
                return url;
            case "Metal":
                url = "http://10.0.2.2/FYP/metal.php";
                return url;
            case "Plastic":
                url = "http://10.0.2.2/FYP/plastic.php";
                return url;
            case "Glass":
                url = "http://10.0.2.2/FYP/glass.php";
                return url;
            case "Battery":
                url = "http://10.0.2.2/FYP/battery.php";
                return url;
            default:
                return null;
        }
    }

}
