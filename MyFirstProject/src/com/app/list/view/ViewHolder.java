package com.app.list.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstproject.*;

public class ViewHolder {
    private View mRow;
    private TextView title = null;
    private TextView detail = null;
    private ImageView i11=null; 

    public ViewHolder(View row) {
    mRow = row;
}
 public TextView gettitle() {
     if(null == title){
         title = (TextView) mRow.findViewById(R.id.title);
        }
    return title;
 }     

 public TextView getdetail() {
     if(null == detail){
          detail = (TextView) mRow.findViewById(R.id.detail);
            }
   return detail;
 }
public ImageView getImage() {
     if(null == i11){
          i11 = (ImageView) mRow.findViewById(R.id.img);
                              }
        return i11;
}
}
