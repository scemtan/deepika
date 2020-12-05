package com.example.deepika;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class Cardlist extends Activity {

	// XML node keys
    static final String KEY_TAG = "id_list"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_COMP = "comp";
    static final String KEY_ICON = "icon";
    
    // List items 
    ListView list;
    BinderData adapter = null;
    List<HashMap<String,String>> DataCollection;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardlist);
        
		try {
			
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse (getAssets().open("id_list.xml"));

	        DataCollection = new ArrayList<HashMap<String,String>>();
	        
	        // normalize text representation
            doc.getDocumentElement ().normalize ();
	                    
            NodeList weatherList = doc.getElementsByTagName("id_list");
            
			HashMap<String,String> map = null;
			
			for (int i = 0; i < weatherList.getLength(); i++) {
				 
				   map = new HashMap<String,String>(); 
				   
				   Node firstWeatherNode = weatherList.item(i);
				   
	                if(firstWeatherNode.getNodeType() == Node.ELEMENT_NODE){

	                    Element firstWeatherElement = (Element)firstWeatherNode;
	                    //-------
	                    NodeList idList = firstWeatherElement.getElementsByTagName(KEY_ID);
	                    Element firstIdElement = (Element)idList.item(0);
	                    NodeList textIdList = firstIdElement.getChildNodes();
	                    //--id
	                    map.put(KEY_ID, ((Node)textIdList.item(0)).getNodeValue().trim());
	                    
	                    //2.-------
	                    NodeList compList = firstWeatherElement.getElementsByTagName(KEY_COMP);
	                    Element firstCompElement = (Element)compList.item(0);
	                    NodeList textCompList = firstCompElement.getChildNodes();
	                    //--comp
	                    map.put(KEY_COMP, ((Node)textCompList.item(0)).getNodeValue().trim());
	                  
	                    //6.-------
	                    NodeList iconList = firstWeatherElement.getElementsByTagName(KEY_ICON);
	                    Element firstIconElement = (Element)iconList.item(0);
	                    NodeList textIconList = firstIconElement.getChildNodes();
	                    //--city
	                    map.put(KEY_ICON, ((Node)textIconList.item(0)).getNodeValue().trim());
	               
	                    //Add to the Arraylist
	                    DataCollection.add(map);
				}		
			}
			
	
			BinderData bindingData = new BinderData(this,DataCollection);

						
			list = (ListView) findViewById(R.id.list);

			Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

			list.setAdapter(bindingData);

			Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					Intent i = new Intent();
					i.setClass(Cardlist.this, SampleActivity.class);

					// parameters
					i.putExtra("position", String.valueOf(position + 1));
					i.putExtra("comp", DataCollection.get(position).get(KEY_COMP));
					i.putExtra("icon", DataCollection.get(position).get(KEY_ICON));

					// start the sample activity
					startActivity(i);
				}
			});

		}
		
		catch (IOException ex) {
			Log.e("Error", ex.getMessage());
		}
		catch (Exception ex) {
			Log.e("Error", "Loading Exception Company List (Cardlist.java Hatasý)");
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
