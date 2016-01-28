package com.ziyidai.www.textswitcherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private TextSwitcher ts_textswitchers;
    private Button btn_swithcer;
    int i = 1;
    ArrayList<String> titleList = new ArrayList();
    private TextView tv_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
         tv_top = (TextView) findViewById(R.id.tv_top);
        Log.e("hahahahahahaha","原本文字大小为:"+tv_top.getTextSize());
        ts_textswitchers = (TextSwitcher)findViewById(R.id.ts_textswitchers);
        btn_swithcer = (Button)findViewById(R.id.btn_swithcer);
        ts_textswitchers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,titleList.get(i),Toast.LENGTH_SHORT).show();
            }
        });
        btn_swithcer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              i++;
                if(i==4){
                    i= 0;
                }
                ts_textswitchers.setText(titleList.get(i));
            }
        });
        ts_textswitchers.setInAnimation(MainActivity.this, R.anim.slide_in_counter);
        ts_textswitchers.setOutAnimation(MainActivity.this, R.anim.slide_out_counter);
        ts_textswitchers.setFactory(this);
    }

    private void initData() {
        for (int i = 0;i<=5;i++){
titleList.add("这是第"+i+"个标题");
        }
    }

    @Override
    public View makeView() {
        TextView tv_des = new TextView(this);
        tv_des.setTextSize(UIUtils.sp2px(MainActivity.this,24)/2);
        Log.e("重新赋值的大小",""+tv_des.getTextSize());
        tv_des.setText(titleList.get(i));
        return  tv_des;
    }
}
