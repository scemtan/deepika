package com.example.deepika;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SampleActivity extends Activity {
	
	String position = "1";
	String comp = "";
	String iconfile = "";
	ImageButton imgIcon;
	
	TextView tvcity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);
        
		try {
			
			//handle for the UI elements 
			//Text fields
			tvcity = (TextView) findViewById(R.id.textView);
			
			// Get position to display
	        Intent i = getIntent();
	        
	        this.position = i.getStringExtra("position");
	        this.comp = i.getStringExtra("comp");
	        this.iconfile = i.getStringExtra("icon");
	        
	        String uri = "drawable/"+ "d" + iconfile;
	        int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
		    Drawable dimgbutton = getResources().getDrawable(imageBtnResource);
		
		    
		    //text elements
		    tvcity.setText(comp);
		    
		    //thumb_image.setImageDrawable(image);
		    imgIcon.setImageDrawable(dimgbutton);
		
			
		}
		
		catch (Exception ex) {
			Log.e("Error", "Loading Exception Detail (SampleActivity Hatasý)");
		}
		
    }
	 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
