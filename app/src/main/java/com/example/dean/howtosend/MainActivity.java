package com.example.dean.howtosend;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Button button;
    private Cursor cursor;
    private Spinner sp_class,sp_weight,sp_from,sp_to;
    private EditText ed_long,ed_mid,ed_short;
    private ArrayAdapter<String> ad_class;
    private ArrayAdapter<String> ad_weight;
    private ArrayAdapter<String> ad_from;
    private ArrayAdapter<String> ad_to;
    private String[] st_class ={"常溫","低溫","種類"};
    private String[] st_weight = {"小於等於250公克","大於250公克 小於等於1公斤","大於1公斤 小於等於5公斤","大於5公斤 小於等於10公斤"
                                ,"大於10公斤 小於等於15公斤","大於15公斤 小於等於20公斤","重量"};
    private String[] st_from = {"本島","澎湖","金門","馬祖","綠島","小琉球","寄件地"};
    private String[] st_to1 = {"本島同縣市","本島不同縣市","澎湖","金門","馬祖","綠島","小琉球","目的地"};
    private String[] st_to2 = {"本島","澎湖","金門","馬祖","綠島","小琉球","目的地"};
    private String[] st_to3 = {"本島","澎湖","金門","馬祖","綠島","目的地"};
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_class = (Spinner)findViewById(R.id.sp_class);
        sp_weight = (Spinner)findViewById(R.id.sp_weight);
        sp_from = (Spinner)findViewById(R.id.sp_from);
        sp_to = (Spinner)findViewById(R.id.sp_to);
        ed_long =(EditText)findViewById(R.id.ed_long);
        ed_mid =(EditText)findViewById(R.id.ed_mid);
        ed_short =(EditText)findViewById(R.id.ed_short);
        button = (Button)findViewById(R.id.button);
        final Typeface font = Typeface.createFromAsset(getAssets(),"fonts/GenJyuuGothic-Medium.ttf");


        ad_class =  new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st_class){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                    ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                    ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                }

                return v;
            }
            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }

        };

        sp_class.setAdapter(ad_class);
        sp_class.setSelection(sp_class.getCount());

        ad_weight = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st_weight){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                    ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                    ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                }

                return v;
            }
            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }

        };

        sp_weight.setAdapter(ad_weight);
        sp_weight.setSelection(sp_weight.getCount());

        ad_from = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st_from){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                    ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                    ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                }

                return v;
            }
            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }

        };

        sp_from.setAdapter(ad_from);
        sp_from.setSelection(sp_from.getCount());
        sp_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    ad_to =  new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,st_to1){

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View v = super.getView(position, convertView, parent);
                            if (position == getCount()) {
                                ((TextView)v.findViewById(android.R.id.text1)).setText("");
                                ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                                ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                                ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                            }

                            return v;
                        }
                        @Override
                        public int getCount() {
                            return super.getCount()-1; // you dont display last item. It is used as hint.
                        }

                    };

                    sp_to.setAdapter(ad_to);
                    sp_to.setSelection(sp_to.getCount());
                }else  if(position >= 1&&position<=4){
                    ad_to =  new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,st_to2){

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View v = super.getView(position, convertView, parent);
                            if (position == getCount()) {
                                ((TextView)v.findViewById(android.R.id.text1)).setText("");
                                ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                                ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                                ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                            }

                            return v;
                        }
                        @Override
                        public int getCount() {
                            return super.getCount()-1; // you dont display last item. It is used as hint.
                        }

                    };

                    sp_to.setAdapter(ad_to);
                    sp_to.setSelection(sp_to.getCount());
                }else  if(position == 5){
                    ad_to =  new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,st_to3){

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View v = super.getView(position, convertView, parent);
                            if (position == getCount()) {
                                ((TextView)v.findViewById(android.R.id.text1)).setText("");
                                ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                                ((TextView)v.findViewById(android.R.id.text1)).setTypeface(font);
                                ((TextView)v.findViewById(android.R.id.text1)).setGravity(Gravity.CENTER);
                            }

                            return v;
                        }
                        @Override
                        public int getCount() {
                            return super.getCount()-1; // you dont display last item. It is used as hint.
                        }

                    };

                    sp_to.setAdapter(ad_to);
                    sp_to.setSelection(sp_to.getCount());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ed_long.setTypeface(font);
        ed_mid.setTypeface(font);
        ed_short.setTypeface(font);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new searchThread();
                thread.start();
            }
        });

    }
    private class searchThread extends Thread{
        @Override
        public void run() {
            String cla,size,weight,from,to;
            String not = "";
            weight = "";
            int size1;

            if(sp_class.getSelectedItemPosition()==0){

                Boolean notGreen1 = false;
                Boolean notGreen2 = false;
                Boolean notSeven = false;
                Boolean notFamily = false;
                if(Integer.parseInt(ed_long.getText().toString())>45||Integer.parseInt(ed_mid.getText().toString())>30
                        ||Integer.parseInt(ed_short.getText().toString())>30){
                    notSeven = true;
                }
                if(Integer.parseInt(ed_long.getText().toString())>=45||Integer.parseInt(ed_mid.getText().toString())>=45
                        ||Integer.parseInt(ed_short.getText().toString())>=45){
                    notFamily = true;
                }
                if(Integer.parseInt(ed_long.getText().toString())>150||Integer.parseInt(ed_mid.getText().toString())>150
                        ||Integer.parseInt(ed_short.getText().toString())>150||
                        (Integer.parseInt(ed_long.getText().toString())+2*Integer.parseInt(ed_mid.getText().toString())+
                        2*Integer.parseInt(ed_short.getText().toString()))>300){
                    notGreen1 = true;
                }
                if(Integer.parseInt(ed_long.getText().toString())>100||Integer.parseInt(ed_mid.getText().toString())>100
                        ||Integer.parseInt(ed_short.getText().toString())>100||
                        (Integer.parseInt(ed_long.getText().toString())+2*Integer.parseInt(ed_mid.getText().toString())+
                                2*Integer.parseInt(ed_short.getText().toString()))>200){
                    notGreen2 = true;
                }


                cla = "1";
                //System.out.println(sp_weight.getSelectedItemPosition());
                int condition_weight = sp_weight.getSelectedItemPosition();
                switch (condition_weight){
                    case 0:
                        //搜尋下限 == 0
                        weight = "0";
                        break;
                    case 1:
                        //搜尋下限 < 0.8 上限>0.8
                        weight = "0.8";
                        break;
                    case 2:
                        weight = "4";
                        break;
                    case 3:
                        weight = "8";
                        break;
                    case 4:
                        weight = "14";
                        break;
                    case 5:
                        weight = "18";
                        break;
                }
                size1 = Integer.parseInt(ed_long.getText().toString())+Integer.parseInt(ed_mid.getText().toString())+Integer.parseInt(ed_short.getText().toString());
                //System.out.println(size1);
                size = String.valueOf(size1);
                if(sp_from.getSelectedItem().toString().equals("小琉球")){
                    from ="小";
                }else {
                    from = sp_from.getSelectedItem().toString();
                }

                if(sp_to.getSelectedItem().toString().equals("小琉球")){
                   to ="小";
                }else {
                    to = sp_to.getSelectedItem().toString();
                }

                if(notGreen1){
                    not = not + " and id !=\"郵局普通\" ";
                }
                if(notGreen2){
                    not = not + " and id !=\"郵局快捷\" ";
                }
                if(notSeven){
                    not = not + " and id !=\"7-11交貨便\" ";
                }
                if(notFamily){
                    not = not + " and id !=\"全家店到店\" ";
                }
                System.out.println(not);




                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ContentActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("cla",cla);
                bundle.putString("size",size);
                bundle.putString("weight",weight);
                bundle.putString("from",from);
                bundle.putString("to",to);
                bundle.putString("not",not);
                intent.putExtras(bundle);
                startActivity(intent);

            }else{
                cla = "2";
                Boolean notPelican = false;


                if(Integer.parseInt(ed_long.getText().toString())>75||Integer.parseInt(ed_mid.getText().toString())>75
                        ||Integer.parseInt(ed_short.getText().toString())>75){
                    notPelican = true;
                }
                //System.out.println(sp_weight.getSelectedItemPosition());
                int condition_weight = sp_weight.getSelectedItemPosition();
                switch (condition_weight){
                    case 0:
                        //搜尋下限 == 0
                        weight = "0";
                        break;
                    case 1:
                        //搜尋下限 < 0.8 上限>0.8
                        weight = "0.8";
                        break;
                    case 2:
                        weight = "4";
                        break;
                    case 3:
                        weight = "8";
                        break;
                    case 4:
                        weight = "14";
                        break;
                    case 5:
                        weight = "18";
                        break;
                }
                if(notPelican){
                    not = not + " and id !=\"宅配通\" ";
                }
                size1 = Integer.parseInt(ed_long.getText().toString())+Integer.parseInt(ed_mid.getText().toString())+Integer.parseInt(ed_short.getText().toString());
                //System.out.println(size1);
                size = String.valueOf(size1);
                from = sp_from.getSelectedItem().toString();
                to = sp_to.getSelectedItem().toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ContentActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("cla",cla);
                bundle.putString("size",size);
                bundle.putString("weight",weight);
                bundle.putString("from",from);
                bundle.putString("to",to);
                bundle.putString("not",not);
                intent.putExtras(bundle);
                startActivity(intent);




            }
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
