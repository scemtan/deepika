package com.example.deepika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Testpage extends Activity {
	

	private ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testpage);
		image1 =(ImageView)findViewById(R.id.imageButton1);
		image1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Testpage.this, Aldi_talk.class));
		}
		});
    }
}

/*

TextView
                    android:id="@+id/textView1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
        			android:layout_alignParentTop="true"
        			android:layout_centerHorizontal="true"
                    android:text="A"
                    android:background="#0381CD"
                    android:textColor="#ffffff"
                    android:gravity="center_horizontal"
                    android:textSize="20dp" />
                    
                    
                    
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:src="@drawable/blauworld" />

*/