package com.ospalh.boldotfdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Typeface;
import android.webkit.WebView;

public class BoldOTFDemo extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);

       Typeface demos_font = Typeface.createFromAsset(getAssets(), "fonts/Demos_LT.otf");
       TextView m_txt = (TextView) findViewById(R.id.demos_text);  
       TextView bm_text = (TextView) findViewById(R.id.bold_demos_text);  
       // Typeface bold_demos_font = Typeface.create(demos_font, Typeface.BOLD);
       Typeface bold_demos_font = Typeface.create(demos_font, 1);
       m_txt.setTypeface(demos_font);  
       bm_text.setTypeface(bold_demos_font);  
       WebView engine = (WebView) findViewById(R.id.web_engine);
       engine.loadUrl("file:///android_asset/demo.html");

    }
}
