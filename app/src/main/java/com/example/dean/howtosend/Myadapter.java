package com.example.dean.howtosend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dean on 2015/8/5.
 */
public class Myadapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<item> itemList = null;


    public Myadapter(Context context, List<item> itemList){
        mContext = context;
        this.itemList = itemList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view =inflater.inflate(R.layout.list_item,null);
        TextView name = (TextView) view.findViewById(R.id.company_name);
        TextView money = (TextView) view.findViewById(R.id.money);
        TextView time = (TextView) view.findViewById(R.id.send_time);

        name.setText(getItem(position).getName());
        money.setText(getItem(position).getMoney());
        time.setText(getItem(position).getday());


        return view;
    }
}
