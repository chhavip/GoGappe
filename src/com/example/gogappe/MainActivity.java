package com.example.gogappe;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    ActionBar actionbar;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    customDrawerAdapter adapter;
    ArrayList<drawerItem> dataList = new ArrayList<drawerItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = getSupportActionBar();

        // Initializing

        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // Add Drawer Item to dataList
        dataList.add(new drawerItem("Home", R.drawable.logo));
        dataList.add(new drawerItem("Recommended places", R.drawable.logo));
        dataList.add(new drawerItem("Cuisines", R.drawable.logo));
        dataList.add(new drawerItem("About Us", R.drawable.logo));
        //dataList.add(new drawerItem("Cuisines", R.drawable.logo));
        dataList.add(new drawerItem("Contact Us", R.drawable.logo));
        dataList.add(new drawerItem("Developers", R.drawable.logo));

        adapter = new customDrawerAdapter(this, R.layout.drawer_item,dataList);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        actionbar.setIcon(R.drawable.logo);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                actionbar.setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                actionbar.setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            SelectItem(0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    public void SelectItem(int possition) {

        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (possition) {
            case 0:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 1:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 2:
                fragment = new Cuisines();
              //  args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 3:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 4:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 5:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;
            case 6:
                fragment = new fragmentOne();
                args.putString(fragmentOne.ITEM_NAME, dataList.get(possition).getItemName());
                //args.putInt(fragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition).getImgResID());
                break;

            default:
                break;
        }

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        actionbar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            SelectItem(position);

        }
    }
}


