package masxdeveloper.infobmkg.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import masxdeveloper.infobmkg.R;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.DataItems;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class AdapterInfoProvinsiSpinner extends ArrayAdapter {

    List<DataItems> dataItems;
    int rowLayout;

    public AdapterInfoProvinsiSpinner(Context context, int resource, List<DataItems> objects) {
        super(context, resource, objects);
        dataItems = objects;
        rowLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int Position, View Converview, ViewGroup Parent){

        Converview = LayoutInflater.from(Parent.getContext()).inflate(rowLayout , Parent , false);

        TextView Provinsi = (TextView) Converview.findViewById(R.id.rowProvinsi);
        Provinsi.setText(dataItems.get(Position).getNama());

        return Converview;
    }
}
