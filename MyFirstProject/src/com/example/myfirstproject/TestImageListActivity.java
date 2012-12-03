package com.example.myfirstproject;

import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.net.ParseException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.list.view.*;
import com.example.myfirstproject.R;

public class TestImageListActivity extends Activity {
	private LayoutInflater mInflater;
	private Vector<RowData> data;
	private ListView mListView;
	TextView itemDesc;
	ImageView itemImg;
	LinearLayout layout;
	
	RowData rd;
	
	public void itemsInformation(int id)
	{
		Builder bd = new Builder(this);
		bd.setTitle("Item Description");
		bd.setView(layout);		
		//itemImg.setImageResource(R.drawable.ic_launcher);
		//itemDesc.setText(data.get(id).getmTitle()+"\n"+data.get(id).getmDetail());
		bd.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bd.show();		
	}

	static final String[] title = new String[] {
		    "*New*Apple iPad Wi-Fi (16GB)", "7 Touch Tablet -2GB Google Android",
		    "Apple iPad Wi-Fi (16GB) Rarely Used ","Apple iPad Wi-Fi (16GB) AppleCase",
		    "*New*Apple iPad Wi-Fi (16GB)", "7 Touch Tablet -2GB Google Android",
		    "Apple iPad Wi-Fi (16GB) Rarely Used ","Apple iPad Wi-Fi (16GB) AppleCase" ,
		    "*New*Apple iPad Wi-Fi (16GB)", "7 Touch Tablet -2GB Google Android",
		    "Apple iPad Wi-Fi (16GB) Rarely Used ","Apple iPad Wi-Fi (16GB) AppleCase" 
		    };

	static final String[] detail = new String[] {
			"1h 37m Shipping: $10.00","1h 39m Shipping: Free",
			"58m 6s Shipping: $10.00","59m 30s Shipping: $10.95",
			"1h 37m Shipping: $10.00","1h 39m Shipping: Free",
			"58m 6s Shipping: $10.00","59m 30s Shipping: $10.95",
			"1h 37m Shipping: $10.00","1h 39m Shipping: Free",
			"58m 6s Shipping: $10.00","59m 30s Shipping: $10.95"
			};

	private int[] imgid = {
	  R.drawable.ic_launcher,R.drawable.ic_launcher,
	  R.drawable.ic_launcher,R.drawable.ic_launcher,
	  R.drawable.ic_launcher,R.drawable.ic_launcher,
	  R.drawable.ic_launcher,R.drawable.ic_launcher,
	  R.drawable.ic_launcher,R.drawable.ic_launcher,
	  R.drawable.ic_launcher,R.drawable.ic_launcher
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	layout=(LinearLayout)findViewById(R.layout.items_desc);
	itemDesc =(TextView)findViewById(R.id.imgDesc);
	itemImg = (ImageView)findViewById(R.id.imgItems);
	mListView = (ListView)findViewById(R.id.list);
	mInflater = (LayoutInflater) getSystemService(
	Activity.LAYOUT_INFLATER_SERVICE);
	data = new Vector<RowData>();
	for(int i=0;i<title.length;i++){

	try {
	 	rd = new RowData(i,title[i],detail[i],imgid[i]);
	    } catch (ParseException e) {
	    	e.printStackTrace();
	   }
	   data.add(rd);
	}
	
	   CustomAdapter adapter = new CustomAdapter(
			   this, R.layout.list,R.id.title, data, mInflater
			   );
	   mListView.setAdapter(adapter);
	   mListView.setTextFilterEnabled(true);
	   mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			//itemsInformation(arg2);
			Toast.makeText(getApplicationContext(), "You have selected "
                    +(arg2+1)+"th item",  Toast.LENGTH_SHORT).show();
			
		}
	});
	}
	   
}