package com.example.tungc.myfyp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser extends AsyncTask<Void,Integer,Boolean> {

    Context c;
    ListView lv;
    String data;

    ArrayList<DataObject> recy_info=new ArrayList<>();
    ProgressDialog pd;

    public Parser(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing ....Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        return this.parse();
    }

    @Override
    protected void onPostExecute(Boolean parse) {
        super.onPostExecute(parse);

        if(parse)
        {
            //ADAPTER
            ListviewAdapter adapter=new ListviewAdapter(c,recy_info);
            lv.setAdapter(adapter);

            //ADAPT TO LISTVIEW

            //rv.setAdapter(adapter);

            //LISTENET
            /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Snackbar.make(view,players.get(position),Snackbar.LENGTH_SHORT).show();;
                }
            });*/

        }else
        {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();
    }

    //PARSE RECEIVED DATA
    private Boolean parse()
    {
        try
        {
            //ADD THAT DATA TO JSON ARRAY FIRST
            JSONArray ja=new JSONArray(data);

            //CREATE JO OBJ TO HOLD A SINGLE ITEM
            JSONObject jo=null;

            recy_info.clear();
            DataObject dataObject;

            //LOOP THRU ARRAY
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                //RETRIOEVE NAME
                String company=jo.getString("company");
                String type=jo.getString("type");
                String weight=jo.getString("weight");
                String price=jo.getString("price");
                String contact_person=jo.getString("contact_person");
                String address=jo.getString("address");
                String tel_no=jo.getString("tel_no");
                String email=jo.getString("email");
                String desc=jo.getString("description");

                dataObject = new DataObject();

                dataObject.setCompany(company);
                dataObject.setType(type);
                dataObject.setWeight(weight);
                dataObject.setPrice(price);
                dataObject.setContact_person(contact_person);
                dataObject.setAddress(address);
                dataObject.setTel_no(tel_no);
                dataObject.setEmail(email);
                dataObject.setDescription(desc);

                //ADD IT TO OUR ARRAYLIST
                recy_info.add(dataObject);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}