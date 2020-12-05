package com.example.deepika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BinderData extends BaseAdapter {

	// XML node keys
    static final String KEY_TAG = "id_list"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_COMP = "comp";
    static final String KEY_ICON = "icon";
	
	LayoutInflater inflater;
	ImageView thumb_image;
	List<HashMap<String,String>> DataCollection;
	ViewHolder holder;
	public BinderData() {
		// TODO Auto-generated constructor stub
	}
	
	public BinderData(Activity act, List<HashMap<String,String>> map) {
		
		this.DataCollection = map;
		
		inflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	public int getCount() {
		// TODO Auto-generated method stub
//		return idlist.size();
		return DataCollection.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		 
		View vi=convertView;
	    if(convertView==null){
	     
	      vi = inflater.inflate(R.layout.list_row, null);
	      holder = new ViewHolder();
	     
	      holder.tvCity = (TextView)vi.findViewById(R.id.tvCity); // company name
	      holder.tvWeatherImage =(ImageView)vi.findViewById(R.id.list_image); // thumb image
	 
	      vi.setTag(holder);
	    }
	    else{
	    	
	    	holder = (ViewHolder)vi.getTag();
	    }

	      // Setting all values in listview
	      
	      holder.tvCity.setText(DataCollection.get(position).get(KEY_COMP));
	      
	      //Setting an image
	      String uri = "drawable/"+ DataCollection.get(position).get(KEY_ICON);
	      int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
	      Drawable image = vi.getContext().getResources().getDrawable(imageResource);
	      holder.tvWeatherImage.setImageDrawable(image);
	      
	      return vi;
	}
	
	/*
	 * 
	 * */
	static class ViewHolder{
		
		TextView tvCity;
		TextView tvTemperature;
		TextView tvWeather;
		ImageView tvWeatherImage;
	}
	
}
