package com.example.myapplication2.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private TextView getInput;
    private UserBusiness userHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userHelper = new UserBusiness(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void searchButton_Click(View view) {
        getInput = (TextView)findViewById(R.id.getInput);
        Intent intent = new Intent(this,sActivity.class);
        intent.putExtra("input",getInput.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userHelper.closeDb();
    }

    public void btnAdd_Click(View view)
    {
        userHelper.addUser(new String[]{"fengshaohua","33048219","0"});
    }
    public void btnDel_Click(View view)
    {
        userHelper.delUser("1");
    }
    public void btnList_Click(View view)
    {
        List<HouseContract.User> userList = userHelper.getUserList();
        ArrayList<Map<String,String>> list = new ArrayList<Map<String, String>>();
        for(HouseContract.User user :userList){
            HashMap<String,String> temp = new HashMap<String, String>();
            temp.put("name",user.getUsername());
            temp.put("identify",user.getIdentify());
            list.add(temp);
        }

    }
}
