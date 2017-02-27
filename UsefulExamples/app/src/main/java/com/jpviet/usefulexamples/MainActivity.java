package com.jpviet.usefulexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] aExamples = {"Alert Dialoges",
            "Animations",
            "Audio Capture",
            "AudioManager",
            "Auto Complete",
            "Best Practices",
            "Bluetooth",
            "Camera",
            "Clipboard",
            "Custom Fonts",
            "Data Backup",
            "Developer Tools",
            "Emulator",
            "Facebook Integration",
            "Gestures",
            "Google Maps",
            "Image Effects",
            "ImageSwitcher",
            "Internal Storage",
            "JetPlayer",
            "JSON Parser",
            "Linkedin Integration",
            "Loading Spinner",
            "Localization",
            "Login Screen",
            "MediaPlayer",
            "Multitouch",
            "Navigation",
            "Network Connection",
            "NFC Guide",
            "PHP/MySQL",
            "Progress Circle",
            "ProgressBar",
            "Push Notification",
            "RenderScript",
            "RSS Reader",
            "Screen Cast",
            "SDK Manager",
            "Sensors",
            "Session Management",
            "Shared Preferences",
            "SIP Protocol",
            "Spelling Checker",
            "SQLite Database",
            "Support Library",
            "Testing",
            "Text to Speech",
            "TextureView",
            "Twitter Integration",
            "UI Design",
            "UI Patterns",
            "UI Testing",
            "WebView Layout",
            "Wi-Fi",
            "Widgets",
            "XML Parsers"
    };
    String LOG_MESSENGER = "LOG_MESSENGER";
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, aExamples);

        final ListView listView = (ListView) findViewById(R.id.list_examples);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "postition: " + position + " - itemValue: " + itemValue,
                        Toast.LENGTH_SHORT).show();
                Log.d(LOG_MESSENGER, "postition: " + position + " - itemValue: " + itemValue);
                Intent detailIntent = new Intent(context, AlertDialoges.class);
                startActivity(detailIntent);
            }
        });
    }
}
