package pe.kr.kit.test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.kr.kit.test.DashBoardActivity;
import pe.kr.kit.test.OnListViewItemClickListener;
import pe.kr.kit.test.data.Item;

public class MainAdapter extends BaseAdapter {
    Context context;
    List<Item> items;
    OnListViewItemClickListener onListViewItemClickListener;


    interface OnListItemClickListener {

    }

    public MainAdapter(Context context, List<Item> items, OnListViewItemClickListener onListViewItemClickListener) {
        this.context = context;
        this.items = items;
        this.onListViewItemClickListener = onListViewItemClickListener;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, null);

        TextView title = view.findViewById(android.R.id.text1);
        TextView content = view.findViewById(android.R.id.text2);

        Item item = getItem(position);
        title.setText(item.title);
        content.setText(item.content);

        final int pos = position;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListViewItemClickListener.onListViewClicked(pos);
            }
        });

        return view;
    }
}
