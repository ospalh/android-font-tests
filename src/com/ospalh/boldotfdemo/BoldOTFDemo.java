package com.ospalh.boldotfdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Typeface;
import android.webkit.WebView;
import android.content.res.AssetManager;
import java.io.IOException; 
import java.io.InputStream; 

public class BoldOTFDemo extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);

       Typeface pfennig_otf_font = Typeface.createFromAsset(getAssets(), "fonts/Pfennig.otf");
       Typeface bold_pfennig_otf_font = Typeface.create(pfennig_otf_font, Typeface.BOLD);
       Typeface pfennig_ttf_font = Typeface.createFromAsset(getAssets(), "fonts/Pfennig.ttf");
       Typeface bold_pfennig_ttf_font = Typeface.create(pfennig_ttf_font, Typeface.BOLD);

       TextView pf_o_txt = (TextView) findViewById(R.id.pfennig_otf_text);  
       TextView b_pf_o_txt = (TextView) findViewById(R.id.bold_pfennig_otf_text);  
       TextView pf_t_txt = (TextView) findViewById(R.id.pfennig_ttf_text);  
       TextView b_pf_t_txt = (TextView) findViewById(R.id.bold_pfennig_ttf_text);  

       pf_o_txt.setTypeface(pfennig_otf_font);  
       b_pf_o_txt.setTypeface(bold_pfennig_otf_font);  
       pf_t_txt.setTypeface(pfennig_ttf_font);  
       b_pf_t_txt.setTypeface(bold_pfennig_ttf_font);  

       WebView engine = (WebView) findViewById(R.id.web_engine);

        engine.loadUrl("file:///android_asset/demo.html");
       WebView card = (WebView) findViewById(R.id.card);
       card.loadUrl("file:///android_asset/card_demo.html");
       WebView base_engine = (WebView) findViewById(R.id.base_engine);
       String base_content = new String();

 // To load text file
       AssetManager assetManager = getAssets();
       InputStream input;  
       try {  
          input = assetManager.open("demo.html");  
              
          int size = input.available();  
          byte[] buffer = new byte[size];  
          input.read(buffer);  
          input.close();  
  
          // byte buffer into a string  
          base_content = new String(buffer);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }

       base_engine.loadDataWithBaseURL("file:///android_asset/", base_content, "text/html", "utf-8", null);

    }
}
