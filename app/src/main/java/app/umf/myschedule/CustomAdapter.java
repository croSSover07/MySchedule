package app.umf.myschedule;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.umf.myschedule.MainActivity;
import app.umf.myschedule.R;

/**
 * Created by umf on 03.10.16.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> numbers;
    ArrayList<String> pairs;

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public CustomAdapter(Context context, ArrayList<String> numbers, ArrayList<String>pairs){
            this.context=context;
            this.numbers=numbers;
            this.pairs=pairs;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.my_list_item2, null);
            //holder = new ViewHolder();
            //holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            //holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            //holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            //convertView.setTag(holder);

            TextView txt_number=(TextView) convertView.findViewById(R.id.textview_number);
            TextView txt_pair=(TextView) convertView.findViewById(R.id.textView_text);
            //convertView.setTag();
            txt_number.setText(numbers.get(position));
            txt_pair.setText(pairs.get(position));



        return convertView;
    }
}
