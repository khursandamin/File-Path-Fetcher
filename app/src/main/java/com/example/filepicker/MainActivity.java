package com.example.filepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_pathshow;
    Button btn_filepicker;
    Intent myFileIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_pathshow=(TextView)findViewById(R.id.txt_path);
        btn_filepicker=(Button) findViewById(R.id.btn_filepicker);
        btn_filepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         myFileIntent= new Intent(Intent.ACTION_GET_CONTENT);
                 myFileIntent.setType("*/*");
                    startActivityForResult(myFileIntent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    txt_pathshow.setText(path);
                }
                break;
        }
    }
}