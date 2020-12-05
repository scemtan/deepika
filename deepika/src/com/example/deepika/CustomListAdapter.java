// DEAKTÝF
package com.example.deepika;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
	
	private final Activity context;
	private final String[] itemname;
	private final Integer[] imageid;
	
	public CustomListAdapter(Activity context, String[] itemname, Integer[] imageid) {
		super(context, R.layout.firma_listesi, itemname);
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.itemname=itemname;
		this.imageid=imageid;
	}
	
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.firma_listesi, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textcustomer);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		TextView extratxt = (TextView) rowView.findViewById(R.id.texcredit);
		
		txtTitle.setText(itemname[position]);
		imageView.setImageResource(imageid[position]);
		extratxt.setText("Description "+itemname[position]);
		return rowView;
		
	};
}