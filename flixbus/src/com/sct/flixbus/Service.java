package com.sct.flixbus;

import java.util.HashMap;
import org.apache.http.client.HttpClient;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.fasterxml.jackson.databind.ObjectMapper;

    public class Service extends Activity {
    	
    	public static final String INTEGRATION_EMAIL    = "DEV_TEST_STAGING@mail.com";
        public static final String INTEGRATION_PASSWORD = "DEV_TEST_STAGING";
        public static final String INTEGRATION_TOKEN    = "DEV_TEST_TOKEN_STAGING";
        public static final String INTEGRATION_SERVER   = "https://api-dev.flixbus.com";
        
        public static final int STATION_ID_BERLIN   = 88;
        public static final int STATION_ID_MUNICH   = 94;

        private WebView webView;

        public void onCreate(Bundle savedInstanceState) {
        	final int HTTP_STATUS_OK = 200;

            String apiToken   = INTEGRATION_TOKEN;
            String server     = INTEGRATION_SERVER;
           
}
}
    
    /*
    HttpClient client = HttpClient.newHttpClient();

    ObjectMapper mapper = new ObjectMapper();

    //
    // Authenticates a user and returns a session token
    // which is required on subsequent requests.
    //
    // https://developer.flix.tech/#post_partner_authenticate
    //


    public static AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {
        Map<Object, Object> data = new HashMap<>();
        data.put("email"   , request.getEmail());
        data.put("password", request.getPassword());

        String json = httpPostRequest("/public/v1/partner/authenticate.json", data, new HashMap<>());

        AuthenticationResponse response = mapper.readValue(json, AuthenticationResponse.class);
        return response;
    }
    */