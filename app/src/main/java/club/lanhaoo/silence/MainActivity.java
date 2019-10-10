package club.lanhaoo.silence;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.view.View;



import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.LocalImageInfo;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import club.lanhaoo.silence.leftpanel.AboutUsActivity;
import club.lanhaoo.silence.leftpanel.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        login
        View headerView=navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        Menu nav_menu=navigationView.getMenu();
        Switch switch_NightLight=(Switch) MenuItemCompat.getActionView(nav_menu.findItem(R.id.nav_nightLight)).findViewById(R.id.switch_Night_Light);
        switch_NightLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }else{

                }
            }
        });



//        banner


        XBanner mXBanner = (XBanner) findViewById(R.id.xbanner);
        initLocalImage();
        mXBanner.setPageTransformer(Transformer.Default);
        initBanner(mXBanner);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_want_to_go) {

            // Handle the camera action
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_AboutUs) {
            Intent intent =new Intent();
            intent.setClass(this, AboutUsActivity.class);
            startActivity(intent);
        }
        System.out.println(id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    /**
     * 初始化XBanner
     */
    private void initBanner(XBanner banner) {
        //设置广告图片点击事件
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Toast.makeText(MainActivity.this, "点击了第" + (position + 1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {

//                加载本地图片展示
                ((ImageView)view).setImageResource(((LocalImageInfo) model).getXBannerUrl());
            }
        });
    }

    /**
     * 初始化数据
     */

    /**
     * 加载本地图片
     */
    private void initLocalImage() {
        List<LocalImageInfo> data = new ArrayList<>();
        data.add(new LocalImageInfo(R.drawable.ic_launcher));
        data.add(new LocalImageInfo(R.drawable.ic_launcher_round));

        XBanner mXBanner = (XBanner) findViewById(R.id.xbanner);
        mXBanner.setBannerData(data);
        mXBanner.setAutoPlayAble(true);
    }
}

