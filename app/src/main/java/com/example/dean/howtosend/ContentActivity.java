package com.example.dean.howtosend;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dean on 2015/8/4.
 */
public class ContentActivity extends Activity {
    private MyDBHelper db;
    private List<item> itemList  =null;
    private Myadapter adapter;
    private static ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listview = (ListView)findViewById(R.id.contentList);

        Bundle bundle = getIntent().getExtras();
        db = new MyDBHelper(this);
        String cla = "";
        Cursor cursor = db.getCursor(bundle.getString("cla"),bundle.getString("size"),bundle.getString("weight")
                ,bundle.getString("from"),bundle.getString("to"),bundle.getString("not"));
        if(bundle.getString("cla").equals("1")){
            cla = "常溫";
        }else{
            cla = "低溫";
        }
        itemList = new ArrayList<item>();
        while(cursor.moveToNext()) {
            item map = new item();
            map.setItem(cursor.getString(0),cursor.getString(8),cursor.getString(9),"1-1-1",cursor.getString(6)
                    ,cursor.getString(7),cla );
            itemList.add(map);
        }

        if (itemList == null || itemList.size() == 0) {

            Toast.makeText(ContentActivity.this, "沒有資料...",
                    Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        adapter = new Myadapter(ContentActivity.this,itemList);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }

}
