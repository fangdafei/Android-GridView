package com.example.xrs_fang.gridview2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //定义 GridView
    private GridView gridView;
    //定义 数据
    private List<Map<String, Object>> dataList;
    //定义 适配器
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridview);
        //初始化数据
        initData();

        String[] from={"img","text"};

        int[] to={R.id.img,R.id.text};

        adapter=new SimpleAdapter(this, dataList, R.layout.gridview_item, from, to);

        gridView.setAdapter(adapter);

        //点击item方法
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示").setMessage(dataList.get(i).get("text").toString()).create().show();

                //打印点击的item
                Log.e("tag", "onItemClick:"+i);

            }
        }) ;
    }

    //数据
    void initData(){
        //图标
        int icno[] = { R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i1, R.drawable.i2, R.drawable.i3};
        //图标下的文字
        String name[]={"时钟","信号","宝箱","苹果","相机","机子","聚会","你哈","箱子"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }

}



