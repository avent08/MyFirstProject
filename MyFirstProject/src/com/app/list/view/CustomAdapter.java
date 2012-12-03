package com.app.list.view;

import java.util.List;

import com.example.myfirstproject.R;


import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<RowData> {

	LayoutInflater  mInflater;
	
	public CustomAdapter(Context context, int resource,
			int textViewResourceId, List<RowData> objects,LayoutInflater mInflater) {               

	 super(context, resource, textViewResourceId, objects);
	 this.mInflater=mInflater;
	}
	
	      @Override
	       public View getView(int position, View convertView, ViewGroup parent) {   

	       ViewHolder holder = null;
	       TextView title = null;
	       TextView detail = null;
	       ImageView img=null;
	       RowData rowData= getItem(position);
	       	       
	       if(convertView==null){
	            convertView = mInflater.inflate(R.layout.list, null);
	            holder = new ViewHolder(convertView);
	            convertView.setTag(holder);
	 }
	             holder = (ViewHolder) convertView.getTag();
	             title = holder.gettitle();
	             title.setText(rowData.getmTitle());
	             detail = holder.getdetail();
	             detail.setText(rowData.getmDetail());                                                     

	             img=holder.getImage();
	             img.setImageResource(rowData.getIdImg());
	             return convertView;
	}
}
