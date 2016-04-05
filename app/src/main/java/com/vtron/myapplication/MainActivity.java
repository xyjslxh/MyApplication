package com.vtron.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private String[] res = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2"};
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
//        button.setOnClickListener(new View.OnClickListener() {
//        匿名内部类监听
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "button1执行了", 1).show();
//            }
//        });
//        //外部类监听
//        button.setOnClickListener(new MyOnClickListener() {
//            @Override
//            public void onClick(View view) {
//                super.onClick(view);
//                Toast.makeText(MainActivity.this, "button1被点击了", Toast.LENGTH_SHORT).show();
//            }
//        });
        //接口方式监听
        button.setOnClickListener(this);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, res);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
//        view.setAlpha(0.5f);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        imageView.setBackgroundResource(b ? R.drawable.on : R.drawable.off);
    }
}

//class MyOnClickListener implements View.OnClickListener {
//
//    @Override
//    public void onClick(View view) {
//        view.setAlpha(0.5f);
//    }
//}
