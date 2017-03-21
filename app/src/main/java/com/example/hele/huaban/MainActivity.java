package com.example.hele.huaban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter2;
    private Spinner spinner2;
    private Button btn;
    private MyView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner2 = (Spinner) findViewById(R.id.spinner1);
        btn=(Button) findViewById(R.id.btn);
        view=(MyView) findViewById(R.id.draw);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.spingarr, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(new SizeListenner());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.clear();  //调用Myview里的clear方法

            }
        });


    }
    private class SizeListenner  implements OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            String paintSize=(String) spinner2.getSelectedItem();
            Toast.makeText(MainActivity.this,"画笔粗细为"+paintSize,Toast.LENGTH_SHORT).show();
            MyView.paint.setStrokeWidth(Integer.valueOf(paintSize).intValue());
            //MyView.ps=

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
