package me.kushalc.stitch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Kushal on 11/27/16.
 */

public class SearchAdapter extends BaseAdapter implements ListView.OnItemClickListener {

    private Activity activity;
    private List<Item> data;
    private static LayoutInflater inflater=null;

    public SearchAdapter(Activity a, List d)
    {
        this.activity= a;
        this.data = d;
        //Used to call an external xml file, in this case expandable_list_view.xml
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
