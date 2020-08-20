package com.example.test3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    // group titles
    private List<String> listDataGroup;
    // child data
    private HashMap<String, List<String>> listDataChild;
    public ExpandableListViewAdapter(Context context, List<String> listDataGroup,
                                     HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listDataGroup = listDataGroup;
        this.listDataChild = listChildData;
    }
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataGroup.get(groupPosition))
                .get(childPosititon);
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);//when we want to access one of few Android system-level services.&&create bridge between system hardware layer and my application
            convertView = layoutInflater.inflate(R.layout.child_item, null);//we can inflate and create views from xml layout resource files
        }
        TextView textViewChild = convertView
                .findViewById(R.id.textViewChild);
        textViewChild.setText(childText);
        return convertView;
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataGroup.get(groupPosition))
                .size();
    }
    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataGroup.get(groupPosition);
    }
    @Override
    public int getGroupCount() {
        return this.listDataGroup.size();
    }
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_item, null);
        }
        TextView textViewGroup = convertView
                .findViewById(R.id.textViewGroup);
        textViewGroup.setTypeface(null, Typeface.BOLD);
        textViewGroup.setText(headerTitle);
        return convertView;
    }
    @Override
    public boolean hasStableIds() {
        return false;//each time call notifyDataSetChanged() my Adapter will look at the returned value of getItemId and will eventually call getView only for those items which id has changed.
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
