package tech.sobre.appreview.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tech.sobre.appreview.R;

public class CitiesAdapter extends ArrayAdapter<String> {

    Activity ctx;
    List<String> list;

    public CitiesAdapter(Activity ctx,List<String> list){
        this(ctx, R.layout.item_list,list);
        this.ctx = ctx;
        this.list = list;
    }

    public CitiesAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = null;

        if(convertView == null) {
            row = ctx.getLayoutInflater().inflate(R.layout.item_list, parent, false);
        }else{
            row = convertView;
        }

        TextView cityName = row.findViewById(R.id.tvItem);

        String item = list.get(position);

        cityName.setText(item);

        return row;

    }
}
