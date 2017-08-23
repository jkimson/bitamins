package bitamins.bmwaresd.apps.bitamins;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String urls,JSON_STRING,json_string;
    List<Drawable> drawables = new ArrayList<>();
    JSONObject jsonObject;
    JSONArray jsonArray;
    double protein;
    String name,percent,volume,symbol;
    TextView t1a;
    RelativeLayout rope,water;
    LinearLayout water2;

    TextView versioning;
    ContactAdapter contactAdapter;
    long Delay = 10000;
    Animation slide_down,slide_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      MobileAds.initialize(getApplicationContext(), "ca-app-pub-9316863024404957/8793268026");
        //ca-app-pub-9316863024404957/8793268026
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                water.setVisibility(View.VISIBLE);


                int hasPermission = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (hasPermission == PackageManager.PERMISSION_GRANTED) {
                    water.setVisibility(View.VISIBLE);

                    final RelativeLayout rl = (RelativeLayout)findViewById(R.id.content_main);
                    rl.post(new Runnable() {
                        @Override
                        public void run() {
                            Bitmap pic = takescreenshot(rl);
                            try{
                                if( pic != null)
                                {
                                    savescreenshot(pic);
                                }
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });

                    final Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/jpg/png");
                    final File photoFile = new File(Environment.getExternalStorageDirectory()+File.separator+"player.png");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
                    startActivity(Intent.createChooser(shareIntent, "Share image using"));

                }
                else
                {
                    if (shouldAskPermissions()) {
                        askPermissions();
                    }
                }
            }
        });

        String versionName = "";
        versioning = (TextView)findViewById(R.id.version);
        versionName = String.valueOf(Build.VERSION.RELEASE);
        versioning.setText(versionName);
        try {
            String bom = versioning.getText().toString();
            protein = Double.parseDouble(bom);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(protein <5)
        {
            Button hidee = (Button)findViewById(R.id.button30);

            LinearLayout water3 = (LinearLayout)findViewById(R.id.watermark2);
            water3.setVisibility(View.VISIBLE);
            Button mainj = (Button)findViewById(R.id.button20j);
            Button maina = (Button)findViewById(R.id.button20a);
            Button mains = (Button)findViewById(R.id.button20s);
            Button maind = (Button)findViewById(R.id.button20d);
            Button mainf = (Button)findViewById(R.id.button20f);
            Button mainb = (Button)findViewById(R.id.button20);
            mainb.setTextColor(Color.BLACK);
            mainj.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            maina.setBackground(getResources().getDrawable(R.drawable.redselector));
            mains.setBackground(getResources().getDrawable(R.drawable.blueselector));
            maind.setBackground(getResources().getDrawable(R.drawable.greenselector));
            mainf.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            //--------------------------------
            Button dob1 = (Button)findViewById(R.id.dobutton1);
            Button dob2 = (Button)findViewById(R.id.dobutton2);
            Button dob3 = (Button)findViewById(R.id.dobutton3);
            Button dob4 = (Button)findViewById(R.id.dobutton4);
            Button dob5 = (Button)findViewById(R.id.dobutton5);
            Button dob6 = (Button)findViewById(R.id.dobutton6);
            Button dob7 = (Button)findViewById(R.id.dobutton7);
            Button dob8 = (Button)findViewById(R.id.dobutton8);
            Button dob9 = (Button)findViewById(R.id.dobutton9);
            Button dob10 = (Button)findViewById(R.id.dobutton10);
            Button dob11 = (Button)findViewById(R.id.dobutton11);
            Button dob12 = (Button)findViewById(R.id.dobutton12);
            Button dob13 = (Button)findViewById(R.id.dobutton13);
            Button dob14 = (Button)findViewById(R.id.dobutton14);
            Button dob15 = (Button)findViewById(R.id.dobutton15);
            Button dob16 = (Button)findViewById(R.id.dobutton16);
            Button dob17 = (Button)findViewById(R.id.dobutton17);
            Button dob18 = (Button)findViewById(R.id.dobutton18);
            Button dob19 = (Button)findViewById(R.id.dobutton19);
            Button dob20 = (Button)findViewById(R.id.dobutton20);
            Button dob21 = (Button)findViewById(R.id.dobutton21);
            Button dob22 = (Button)findViewById(R.id.dobutton22);
            Button dob23 = (Button)findViewById(R.id.dobutton23);
            Button dob24 = (Button)findViewById(R.id.dobutton24);
            Button dob25 = (Button)findViewById(R.id.dobutton25);
            Button dob26 = (Button)findViewById(R.id.dobutton26);
            Button dob27 = (Button)findViewById(R.id.dobutton27);
            Button dob28 = (Button)findViewById(R.id.dobutton28);
            Button dob29 = (Button)findViewById(R.id.dobutton29);
            Button dob30 = (Button)findViewById(R.id.dobutton30);
            Button dob31 = (Button)findViewById(R.id.dobutton31);
            Button dob32 = (Button)findViewById(R.id.dobutton32);
            Button dob33 = (Button)findViewById(R.id.dobutton33);
            Button dob34 = (Button)findViewById(R.id.dobutton34);
            Button dob35 = (Button)findViewById(R.id.dobutton35);
            Button dob36 = (Button)findViewById(R.id.dobutton36);
            Button dob37 = (Button)findViewById(R.id.dobutton37);
            Button dob38 = (Button)findViewById(R.id.dobutton38);
            Button dob39 = (Button)findViewById(R.id.dobutton39);
            Button dob40 = (Button)findViewById(R.id.dobutton40);
            Button dob41 = (Button)findViewById(R.id.dobutton41);
            Button dob42 = (Button)findViewById(R.id.dobutton42);
            Button dob43 = (Button)findViewById(R.id.dobutton43);
            Button dob44 = (Button)findViewById(R.id.dobutton44);
            Button dob45 = (Button)findViewById(R.id.dobutton45);
            Button dob46 = (Button)findViewById(R.id.dobutton46);
            Button dob47 = (Button)findViewById(R.id.dobutton47);
            Button dob48 = (Button)findViewById(R.id.dobutton48);
            Button dob49 = (Button)findViewById(R.id.dobutton49);
            Button dob50 = (Button)findViewById(R.id.dobutton50);
            Button dob51 = (Button)findViewById(R.id.dobutton51);
            Button dob52 = (Button)findViewById(R.id.dobutton52);
            Button dob53 = (Button)findViewById(R.id.dobutton53);
            Button dob54 = (Button)findViewById(R.id.dobutton54);
            Button dob55 = (Button)findViewById(R.id.dobutton55);
            Button dob56 = (Button)findViewById(R.id.dobutton56);
            Button dob57 = (Button)findViewById(R.id.dobutton57);
            Button dob58 = (Button)findViewById(R.id.dobutton58);
            Button dob59 = (Button)findViewById(R.id.dobutton59);
            Button dob60 = (Button)findViewById(R.id.dobutton60);
            Button dob61 = (Button)findViewById(R.id.dobutton61);
            Button dob62 = (Button)findViewById(R.id.dobutton62);
            Button dob63 = (Button)findViewById(R.id.dobutton63);
            Button dob64 = (Button)findViewById(R.id.dobutton64);
            Button dob65 = (Button)findViewById(R.id.dobutton65);
            Button dob66 = (Button)findViewById(R.id.dobutton66);
            Button dob67 = (Button)findViewById(R.id.dobutton67);
            Button dob68 = (Button)findViewById(R.id.dobutton68);
            Button dob69 = (Button)findViewById(R.id.button20all);
            //---------------------------
            Button angry1 = (Button)findViewById(R.id.angryb1);
            Button angry2 = (Button)findViewById(R.id.angryb2);
            Button angry3 = (Button)findViewById(R.id.angryb3);
            Button angry4 = (Button)findViewById(R.id.angryb4);
            Button angry5 = (Button)findViewById(R.id.angryb5);
            Button angry6 = (Button)findViewById(R.id.angryb6);
            angry1.setBackground(getResources().getDrawable(R.drawable.redselector));
            angry2.setBackground(getResources().getDrawable(R.drawable.redselector));
            angry3.setBackground(getResources().getDrawable(R.drawable.redselector));
            angry4.setBackground(getResources().getDrawable(R.drawable.redselector));
            angry5.setBackground(getResources().getDrawable(R.drawable.redselector));
            angry6.setBackground(getResources().getDrawable(R.drawable.redselector));
            //---------------------------
            Button joy1 = (Button)findViewById(R.id.joyb1);
            Button joy2 = (Button)findViewById(R.id.joyb2);
            Button joy3 = (Button)findViewById(R.id.joyb3);
            Button joy4 = (Button)findViewById(R.id.joyb4);
            Button joy5 = (Button)findViewById(R.id.joyb5);
            Button joy6 = (Button)findViewById(R.id.joyb6);
            Button joy7 = (Button)findViewById(R.id.joyb7);
            Button joy8 = (Button)findViewById(R.id.joyb8);
            Button joy9 = (Button)findViewById(R.id.joyb9);
            Button joy10 = (Button)findViewById(R.id.joyb10);
            Button joy11 = (Button)findViewById(R.id.joyb11);
            Button joy12 = (Button)findViewById(R.id.joyb12);
            Button joy13 = (Button)findViewById(R.id.joyb13);

            Button joy15 = (Button)findViewById(R.id.joyb15);
            Button joy16 = (Button)findViewById(R.id.joyb16);
            Button joy17 = (Button)findViewById(R.id.joyb17);
            Button joy18 = (Button)findViewById(R.id.joyb18);
            Button joy19 = (Button)findViewById(R.id.joyb19);
            Button joy20 = (Button)findViewById(R.id.joyb20);
            Button joy21 = (Button)findViewById(R.id.joyb21);
            Button joy22 = (Button)findViewById(R.id.joyb22);
            Button joy23 = (Button)findViewById(R.id.joyb23);
            Button joy24 = (Button)findViewById(R.id.joyb24);
            Button joy25 = (Button)findViewById(R.id.joyb25);
            Button joy26 = (Button)findViewById(R.id.joyb26);

            Button joy28 = (Button)findViewById(R.id.joyb28);
            Button joy29 = (Button)findViewById(R.id.joyb29);
            joy1.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy2.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy3.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy4.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy5.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy6.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy7.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy8.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy9.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy10.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy11.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy12.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy13.setBackground(getResources().getDrawable(R.drawable.yellowselector));

            joy15.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy16.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy17.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy18.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy19.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy20.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy21.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy22.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy23.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy24.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy25.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy26.setBackground(getResources().getDrawable(R.drawable.yellowselector));

            joy28.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            joy29.setBackground(getResources().getDrawable(R.drawable.yellowselector));
            //---------------------------
            Button sad1 = (Button)findViewById(R.id.sadb1);
            Button sad2 = (Button)findViewById(R.id.sadb2);
            Button sad3 = (Button)findViewById(R.id.sadb3);
            Button sad4 = (Button)findViewById(R.id.sadb4);
            Button sad5 = (Button)findViewById(R.id.sadb5);
            Button sad6 = (Button)findViewById(R.id.sadb6);
            Button sad7 = (Button)findViewById(R.id.sadb7);
            Button sad8 = (Button)findViewById(R.id.sadb8);
            Button sad9 = (Button)findViewById(R.id.sadb9);
            Button sad10 = (Button)findViewById(R.id.sadb10);
            sad1.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad2.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad3.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad4.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad5.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad6.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad7.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad8.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad9.setBackground(getResources().getDrawable(R.drawable.blueselector));
            sad10.setBackground(getResources().getDrawable(R.drawable.blueselector));
            //---------------------------
            Button disgust1 = (Button)findViewById(R.id.disgustb1);
            Button disgust2 = (Button)findViewById(R.id.disgustb2);
            Button disgust3 = (Button)findViewById(R.id.disgustb3);
            Button disgust4 = (Button)findViewById(R.id.disgustb4);
            Button disgust5 = (Button)findViewById(R.id.disgustb5);
            Button disgust6 = (Button)findViewById(R.id.disgustb6);
            disgust1.setBackground(getResources().getDrawable(R.drawable.greenselector));
            disgust2.setBackground(getResources().getDrawable(R.drawable.greenselector));
            disgust3.setBackground(getResources().getDrawable(R.drawable.greenselector));
            disgust4.setBackground(getResources().getDrawable(R.drawable.greenselector));
            disgust5.setBackground(getResources().getDrawable(R.drawable.greenselector));
            disgust6.setBackground(getResources().getDrawable(R.drawable.greenselector));
            //---------------------------
            Button fear1 = (Button)findViewById(R.id.fearb1);
            Button fear2 = (Button)findViewById(R.id.fearb2);
            Button fear3 = (Button)findViewById(R.id.fearb3);
            Button fear4 = (Button)findViewById(R.id.fearb4);
            Button fear5 = (Button)findViewById(R.id.fearb5);
            Button fear6 = (Button)findViewById(R.id.fearb6);
            Button fear7 = (Button)findViewById(R.id.fearb7);
            fear1.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear2.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear3.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear4.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear5.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear6.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            fear7.setBackground(getResources().getDrawable(R.drawable.purpleselector));
            //---------------------------
            dob1.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob2.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob3.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob4.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob5.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob6.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob7.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob8.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob9.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob10.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob11.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob12.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob13.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob14.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob15.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob16.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob17.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob18.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob19.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob20.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob21.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob22.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob23.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob24.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob25.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob26.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob27.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob28.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob29.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob30.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob31.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob32.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob33.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob34.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob35.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob36.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob37.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob38.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob39.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob40.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob41.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob42.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob43.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob44.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob45.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob46.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob47.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob48.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob49.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob50.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob51.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob52.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob53.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob54.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob55.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob56.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob57.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob58.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob58.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob59.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob60.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob61.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob62.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob63.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob64.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob65.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob66.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob67.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob68.setBackground(getResources().getDrawable(R.drawable.buttonselector));
            dob69.setBackground(getResources().getDrawable(R.drawable.hideselector));
            hidee.setBackground(getResources().getDrawable(R.drawable.buttonselector));
        }
        else
        {

        }

        rope = (RelativeLayout)findViewById(R.id.ifeel);
        water = (RelativeLayout)findViewById(R.id.watermark);
        water2 = (LinearLayout)findViewById(R.id.watermark2);

        slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        //  randomimage();
        urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses";
        new bg1().execute();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        System.exit(0);
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
            water.setVisibility(View.VISIBLE);

            final RelativeLayout rl = (RelativeLayout)findViewById(R.id.content_main);
            rl.post(new Runnable() {
                @Override
                public void run() {
                    Bitmap pic = takescreenshot(rl);
                    try{
                        if( pic != null)
                        {
                            savescreenshot(pic);
                        }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

            final Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/jpg/png");
            final File photoFile = new File(Environment.getExternalStorageDirectory()+File.separator+"player.png");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
            startActivity(Intent.createChooser(shareIntent, "Share image using"));
            water.setVisibility(View.GONE);


        }

        return super.onOptionsItemSelected(item);
    }



    public void random(View v)
    {
        alphas();
        randomimage();
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
        rl.setVisibility(View.VISIBLE);
        LinearLayout ll = (LinearLayout)findViewById(R.id.items);
        ll.setVisibility(View.INVISIBLE);
        Random r1 = new Random();
        int i11 = r1.nextInt(21 - 1) + 1;
        //substring(0,str.length()-1);
        if(i11 == 1) {
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses/";
        }
        else if(i11 == 2){
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/";
        }
        else if(i11 == 3){
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses";
        }
        else if(i11 == 4){
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses";
        }
        else if(i11 == 5){
            urls = "http://www.robertbatac.com/bitamins/verses/api/bitamins/getverses";
        }
        else if(i11 == 6){
            urls = "http://www.robertbatac.com/bitamins/verses/api/bitamins/getverses/";
        }
        else if(i11 == 7){
            urls = "http://robertbatac.com/bitamins/verses/api/bitamins/getverses";
        }
        else if(i11 == 8){
            urls = "http://robertbatac.com/bitamins/verses/api/bitamins/getverses/";
        }
        else if(i11 == 9){
            urls = "http://robertbatac.com/bitamins/verses/api/bitamins/getverses///";
        }
        else if(i11 == 10){
            urls = "http://robertbatac.com/bitamins/verses/api/bitamins/getverses//";
        }
        else if(i11 == 11){
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses//";
        }
        else if(i11 == 12){
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses///";
        }
        else if(i11 == 13){
            urls = "http://www.robertbatac.com/bitamins/verses/api/bitamins/getverses///";
        }
        else if(i11 == 14){
            urls = "http://www.robertbatac.com/bitamins/verses/api/bitamins/getverses//";
        }
        else if(i11 == 15){
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses//";
        }
        else if(i11 == 16){
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses///";
        }
        else{
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses///";
        }

        new bg1().execute();
    }
    public void joyemotion(View v)
    {
        alphas(); randomimage();
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        rl.setVisibility(View.VISIBLE);
        LinearLayout ll = (LinearLayout)findViewById(R.id.items);
        ll.setVisibility(View.INVISIBLE);
        String caps="/";
       // urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses//"+caps.substring(0, 3);
        Random r = new Random();
        int i1 = r.nextInt(24 - 1) + 1;
        if (i1 == 1)
        {
            caps = getty.getText().toString();
        }
        else if (i1 == 2)
        {
            caps = getty.getText().toString().toLowerCase();
        }
        else if (i1 == 2)
        {
            caps = getty.getText().toString().toLowerCase();
        }
        else if (i1 == 3)
        {
            caps = getty.getText().toString().toLowerCase()+"/";
        }
        else if (i1 == 4)
        {
            caps = getty.getText().toString().toUpperCase()+"/";
        }
        else if (i1 == 5)
        {
            caps = "/"+getty.getText().toString().toLowerCase()+"/";
        }
        else if (i1 == 6)
        {
            caps = "/"+getty.getText().toString().toUpperCase()+"/";
        }
        else if (i1 == 7)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1);
        }
        else if (i1 == 8)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2);
        }
        else if (i1 == 9)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3);
        }
        else if (i1 == 10)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1) +"/";
        }
        else if (i1 == 11)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2)+"/";
        }
        else if (i1 == 12)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3)+"/";
        }
        else if (i1 == 13)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1) +"/";
        }
        else if (i1 == 14)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2)+"/";
        }
        else if (i1 == 15)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3)+"/";
        }
        else if (i1 == 16)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,1);
        }
        else if (i1 == 17)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,2);
        }
        else if (i1 == 18)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,3);
        }
        else if (i1 == 19)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,1) + "/";
        }
        else if (i1 == 20)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,2) + "/";
        }
        else if (i1 == 21)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,3) + "/";
        } else if (i1 == 22)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,1) + "/";
        }
        else if (i1 == 23)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,2) + "/";
        }
        else if (i1 == 24)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,3) + "/";
        }
        Random r1 = new Random();
        int i11 = r1.nextInt(3 - 1) + 1;
        //substring(0,str.length()-1);
        if(i11 == 1) {
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses/" + caps;
        }
        else{
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/" + caps;
        }
        new bg1().execute();
    }


    public void allemotion(View v)
    {
        alphas(); randomimage();
        final Button bom = (Button)findViewById(R.id.button30);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                bom.setVisibility(View.GONE);
            }
        });
        bom.startAnimation(slide_down);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        rl.setVisibility(View.VISIBLE);
        LinearLayout ll = (LinearLayout)findViewById(R.id.items);
        ll.setVisibility(View.INVISIBLE);
        String caps="/";
        Random r = new Random();
        int i1 = r.nextInt(24 - 1) + 1;
        if (i1 == 1)
        {
            caps = getty.getText().toString();
        }
        else if (i1 == 2)
        {
            caps = getty.getText().toString().toLowerCase();
        }
        else if (i1 == 2)
        {
            caps = getty.getText().toString().toLowerCase();
        }
        else if (i1 == 3)
        {
            caps = getty.getText().toString().toLowerCase()+"/";
        }
        else if (i1 == 4)
        {
            caps = getty.getText().toString().toUpperCase()+"/";
        }
        else if (i1 == 5)
        {
            caps = "/"+getty.getText().toString().toLowerCase()+"/";
        }
        else if (i1 == 6)
        {
            caps = "/"+getty.getText().toString().toUpperCase()+"/";
        }
        else if (i1 == 7)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1);
        }
        else if (i1 == 8)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2);
        }
        else if (i1 == 9)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3);
        }
        else if (i1 == 10)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1) +"/";
        }
        else if (i1 == 11)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2)+"/";
        }
        else if (i1 == 12)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3)+"/";
        }
        else if (i1 == 13)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-1) +"/";
        }
        else if (i1 == 14)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-2)+"/";
        }
        else if (i1 == 15)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,getty.getText().toString().length()-3)+"/";
        }
        else if (i1 == 16)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,1);
        }
        else if (i1 == 17)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,2);
        }
        else if (i1 == 18)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,3);
        }
        else if (i1 == 19)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,1) + "/";
        }
        else if (i1 == 20)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,2) + "/";
        }
        else if (i1 == 21)
        {
            caps = getty.getText().toString().toLowerCase().substring(0,3) + "/";
        } else if (i1 == 22)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,1) + "/";
        }
        else if (i1 == 23)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,2) + "/";
        }
        else if (i1 == 24)
        {
            caps = "/"+getty.getText().toString().toLowerCase().substring(0,3) + "/";
        }
        Random r1 = new Random();
        int i11 = r1.nextInt(3 - 1) + 1;
        //substring(0,str.length()-1);
        if(i11 == 1) {
            urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses/" + caps;
        }
        else{
            urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/" + caps;
        }
        new bg1().execute();
    }
    public void alphas()
    {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.content_main);
        rl.startAnimation(fadeIn);
    }
    public void randomimage()
    {
       /* drawables.add(ContextCompat.getDrawable(this, R.drawable.img1));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img2));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img3));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img4));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img5));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img6));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img7));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img8));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img9));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img10));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img11));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img12));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img13));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img14));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img15));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img16));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img17));
        drawables.add(ContextCompat.getDrawable(this, R.drawable.img18));
        ;
        Random r = new Random();
        int i1 = r.nextInt(18 - 1) + 1;
        RelativeLayout layout1 = (RelativeLayout)findViewById(R.id.content_main);
        layout1.setBackground(drawables.get(i1));*/

        Random r = new Random();
        int i1 = r.nextInt(18 - 1) + 1;
        RelativeLayout layout1 = (RelativeLayout)findViewById(R.id.content_main);
        if(i1 == 1)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img1));
        }
        else if(i1 == 2)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img2));
        }
        else if(i1 == 3)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img3));
        }
        else if(i1 == 4)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img4));
        }
        else if(i1 ==5)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img5));
        }
        else if(i1 == 6)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img6));
        }
        else if(i1 == 7)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img7));
        }
        else if(i1 == 8)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img8));
        }
        else if(i1 == 9)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img9));
        }
        else if(i1 == 10)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img10));
        }
        else if(i1 == 11)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img11));
        }
        else if(i1 == 12)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img12));
        }
        else if(i1 == 13)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img13));
        }
        else if(i1 ==14)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img14));
        }
        else if(i1 == 15)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img15));
        }
        else if(i1 == 16)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img16));
        }
        else if(i1 == 17)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img17));
        }
        else if(i1 == 18)
        {
            layout1.setBackground( getResources().getDrawable(R.drawable.img18));
        }

    }
    public void emotionshow(View v)
    {
        final Button bom = (Button)findViewById(R.id.button30);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                bom.setVisibility(View.GONE);
            }
        });
        bom.startAnimation(slide_down);
        final ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        svj.setVisibility(View.GONE);
        svall.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        sva.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        hs.setVisibility(View.VISIBLE);
        hs.startAnimation(slide_up);


        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final Button b2e = (Button)findViewById(R.id.button20all);
        b1.setText("Get Another Bitamins");
        b2.setText("Get Another Bitamins");
        b2a.setText("Get Another Bitamins");
        b2b.setText("Get Another Bitamins");
        b2c.setText("Get Another Bitamins");
        b2d.setText("Get Another Bitamins");
        b2e.setText("Get Another Bitamins");
        b2.setVisibility(View.GONE);
        b2a.setVisibility(View.GONE);
        b2b.setVisibility(View.GONE);
        b2c.setVisibility(View.GONE);
        b2d.setVisibility(View.GONE);
        b2e.setVisibility(View.GONE);
        b1.setVisibility(View.VISIBLE);
    }

    public void backss(View v)
    {
        final Button bom = (Button)findViewById(R.id.button30);
        final ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mayo = (LinearLayout)findViewById(R.id.mainbutton);

        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                bom.setVisibility(View.GONE);
                svj.setVisibility(View.GONE);
                svall.setVisibility(View.GONE);
                svs.setVisibility(View.GONE);
                sva.setVisibility(View.GONE);
                svf.setVisibility(View.GONE);
                svd.setVisibility(View.GONE);
                HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
                hs.setVisibility(View.GONE);
                mayo.startAnimation(slide_up);
                mayo.setVisibility(View.VISIBLE);
            }
        });
        svall.startAnimation(slide_down);
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final Button b2e = (Button)findViewById(R.id.button20all);
        b1.setText("Get Another Bitamins");
        b2.setText("Get Another Bitamins");
        b2a.setText("Get Another Bitamins");
        b2b.setText("Get Another Bitamins");
        b2c.setText("Get Another Bitamins");
        b2d.setText("Get Another Bitamins");
        b2e.setText("Get Another Bitamins");
    }
    public void feelings(View v)
    {
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);

        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                hs.setVisibility(View.GONE);
            }
        });
        hs.startAnimation(slide_down);



    }
    public void aboutsis(View v)
    {
        final Button bom = (Button)findViewById(R.id.button30);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
        rl.setVisibility(View.GONE);
        svj.setVisibility(View.GONE);
        hs.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        sva.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);

        svall.setVisibility(View.VISIBLE);
        svall.startAnimation(slide_up);

        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final Button b2e = (Button)findViewById(R.id.button20all);
        b1.setText("Get Another Bitamins");
        b2.setText("Get Another Bitamins");
        b2a.setText("Get Another Bitamins");
        b2b.setText("Get Another Bitamins");
        b2c.setText("Get Another Bitamins");
        b2d.setText("Get Another Bitamins");
        b2e.setText("Get Another Bitamins");

    }
    public void joylists(View v)
    {Button bom = (Button)findViewById(R.id.button30);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);
        hs.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        sva.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);


        svj.setVisibility(View.VISIBLE);
        svj.startAnimation(slide_up);

    }
    public void sadlists(View v)
    {Button bom = (Button)findViewById(R.id.button30);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);

        hs.setVisibility(View.GONE);
        svj.setVisibility(View.GONE);
        sva.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);

        svs.setVisibility(View.VISIBLE);
        svs.startAnimation(slide_up);
    }
    public void angrylists(View v)
    {Button bom = (Button)findViewById(R.id.button30);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);

        hs.setVisibility(View.GONE);
        svj.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);

        sva.setVisibility(View.VISIBLE);
        sva.startAnimation(slide_up);


    }
    public void fearlists(View v)
    {Button bom = (Button)findViewById(R.id.button30);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);

        hs.setVisibility(View.GONE);
        svj.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        sva.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);

        svf.setVisibility(View.VISIBLE);
        svf.startAnimation(slide_up);
    }
    public void disgustlists(View v)
    {Button bom = (Button)findViewById(R.id.button30);
        bom.startAnimation(slide_up);
        bom.setVisibility(View.VISIBLE);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);

        hs.setVisibility(View.GONE);
        svj.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);
        mains.setVisibility(View.GONE);

        svd.setVisibility(View.VISIBLE);
        svd.startAnimation(slide_up);
    }


    public void odisgustlists(View v)
    {
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final  ScrollView svs = (ScrollView)findViewById(R.id.sadlist);
        final  ScrollView sva = (ScrollView)findViewById(R.id.angrylist);
        final  ScrollView svf = (ScrollView)findViewById(R.id.fearlist);
        final  ScrollView svd = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout mains = (LinearLayout)findViewById(R.id.mainbutton);

        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        svall.setVisibility(View.GONE);


        svj.setVisibility(View.GONE);
        svs.setVisibility(View.GONE);
        svf.setVisibility(View.GONE);
        svd.setVisibility(View.GONE);

        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b2a.setVisibility(View.GONE);
        b2b.setVisibility(View.GONE);
        b2c.setVisibility(View.GONE);
        b2d.setVisibility(View.VISIBLE);
        hs.startAnimation(slide_down);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                hs.setVisibility(View.GONE);
            }
        });

        Random r = new Random();
        int i1 = r.nextInt(12 - 1) + 1;
        if(i1 == 1)
        {
            urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/angry";
        }
        else if(i1 == 2)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/godlessness";}
        else if(i1 == 3)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/jealous";}
        else if(i1 == 4)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/bitter";}
        else if(i1 == 5)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/emotional";}
        else if(i1 == 6)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/bad";}
        else if(i1 == 7)
        {urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Angry"; }
        else if(i1 == 8)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Godlessness";}
        else if(i1 == 9)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Jealous";}
        else if(i1 == 10)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Bitter";}
        else if(i1 == 11)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Emotional";}
        else if(i1 == 12)
        { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Bad";}
        new bg1().execute();

    }

    class bg1 extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
            try {


                String json_url=urls;
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            t1a = (TextView)findViewById(R.id.txt1);
            t1a.setText(result);
            json_string = result;
            if(!(t1a.getText().toString().equals("")))
            {
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.VISIBLE);
                rl.setVisibility(View.GONE);
                try {
                    jsonObject = new JSONObject(result);
                    jsonArray = jsonObject.getJSONArray("Verses");
                    for(int i=0; i < jsonArray.length(); i++) {
                        JSONObject JO = jsonArray.getJSONObject(i);
                        name = JO.getString("verses_id");
                        percent = JO.getString("verses");
                        volume = JO.getString("author");
                        symbol = JO.getString("keyword");


                    }

                    TextView t1 = (TextView)findViewById(R.id.verse);
                    TextView t2 = (TextView)findViewById(R.id.author);
                    TextView t3 = (TextView)findViewById(R.id.keyword);
                    t1.setText(percent);
                    t2.setText("-"+volume);
                    t3.setText(symbol);


                } catch (JSONException e) {
                    Log.e("JSONException", "Error: " + e.toString());
                }


            }
            else
            {
                Toast.makeText(getBaseContext(), "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void emotionj1(View v)
    {

        alphas(); randomimage();
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.joylist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);

        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                svj.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b2a.setVisibility(View.GONE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.GONE);
                b2.setVisibility(View.VISIBLE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                TextView getty = (TextView)findViewById(R.id.emotioncatcher);
                urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
                // urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Empowered";
                b2.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
                Button bom = (Button)findViewById(R.id.button30);
                bom.setVisibility(View.GONE);
                new bg1().execute();
            }
        });
        svj.startAnimation(slide_down);

    }

    public void emotionj2(View v)
    {
        alphas(); randomimage();
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.sadlist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);

        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2a.setVisibility(View.VISIBLE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.GONE);
                svj.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                Button bom = (Button)findViewById(R.id.button30);
                bom.setVisibility(View.GONE);

            }
        });
        svj.startAnimation(slide_down);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
        b2a.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
        new bg1().execute();
    }

    public void emotionj3(View v)
    {
        alphas(); randomimage();
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.angrylist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView pop = (HorizontalScrollView)findViewById(R.id.emotionlist);

        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2a.setVisibility(View.GONE);
                b2b.setVisibility(View.VISIBLE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.GONE);
                svj.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                Button bom = (Button)findViewById(R.id.button30);
                bom.setVisibility(View.GONE);
                /*Random r = new Random();
                int i1 = r.nextInt(12 - 1) + 1;
                if(i1 == 1)
                {
                    urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/angry";
                }
                else if(i1 == 2)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/godlessness";}
                else if(i1 == 3)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/jealous";}
                else if(i1 == 4)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/bitter";}
                else if(i1 == 5)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/emotional";}
                else if(i1 == 6)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/bad";}
                else if(i1 == 7)
                {urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Angry"; }
                else if(i1 == 8)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Godlessness";}
                else if(i1 == 9)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Jealous";}
                else if(i1 == 10)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Bitter";}
                else if(i1 == 11)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Emotional";}
                else if(i1 == 12)
                { urls="http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/Bad";}
                new bg1().execute();*/


            }
        });
        svj.startAnimation(slide_down);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
        b2b.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
        new bg1().execute();

    }

    public void emotionj4(View v)
    {
        alphas(); randomimage();
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.fearlist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);

        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2a.setVisibility(View.GONE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.VISIBLE);
                b2d.setVisibility(View.GONE);
                svj.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                Button bom = (Button)findViewById(R.id.button30);
                bom.setVisibility(View.GONE);

            }
        });
        svj.startAnimation(slide_down);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
        b2c.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
        new bg1().execute();
    }
    public void emotionj5(View v)
    {
        alphas(); randomimage();
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);

        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2a.setVisibility(View.GONE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.VISIBLE);
                svj.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                Button bom = (Button)findViewById(R.id.button30);
                bom.setVisibility(View.GONE);
            }
        });
        svj.startAnimation(slide_down);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
        b2d.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
        new bg1().execute();
    }



    public void emotionj6(View v)
    {
        alphas(); randomimage();
        final Button bom = (Button)findViewById(R.id.button30);
        final  RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final ScrollView svj = (ScrollView)findViewById(R.id.disgustlist);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);
        final  ScrollView svall = (ScrollView)findViewById(R.id.abouts);
        LinearLayout llol = (LinearLayout)findViewById(R.id.items);
        llol.setVisibility(View.INVISIBLE);
        final Button b2all = (Button)findViewById(R.id.button20all);
        TextView texts = (TextView)findViewById(R.id.emotioncatcher);
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String message = button.getText().toString();
        texts.setText(message);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                svall.setVisibility(View.GONE);
                b2all.setVisibility(View.VISIBLE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                rl.setVisibility(View.VISIBLE);
               b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2a.setVisibility(View.GONE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.GONE);

                svj.setVisibility(View.GONE);
                bom.setVisibility(View.GONE);
            }
        });
        svall.startAnimation(slide_down);
        TextView getty = (TextView)findViewById(R.id.emotioncatcher);
        urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/"+getty.getText().toString().toLowerCase();
        b2all.setText("Get Another Bitamins ("+ getty.getText().toString().toLowerCase().toLowerCase() +")");
        new bg1().execute();
    }
    public String getAndroidVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release +")";
    }
    public void nulls(View v)
    {

        final Button bom = (Button)findViewById(R.id.button30);
        final Button b1 = (Button)findViewById(R.id.button20);
        final Button b2 = (Button)findViewById(R.id.button20j);
        final Button b2a = (Button)findViewById(R.id.button20s);
        final Button b2b = (Button)findViewById(R.id.button20a);
        final Button b2c = (Button)findViewById(R.id.button20f);
        final Button b2d = (Button)findViewById(R.id.button20d);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.mainbutton);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.emotionlist);

        slide_down.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Button b2doom = (Button)findViewById(R.id.button20all);
                b2doom.setVisibility(View.GONE);
                hs.setVisibility(View.GONE);
                bom.setVisibility(View.GONE);
                b1.setVisibility(View.VISIBLE);
                b2a.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b2b.setVisibility(View.GONE);
                b2c.setVisibility(View.GONE);
                b2d.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                RelativeLayout rl = (RelativeLayout)findViewById(R.id.loading);
                LinearLayout ll = (LinearLayout)findViewById(R.id.items);
                ll.setVisibility(View.INVISIBLE);
                rl.setVisibility(View.VISIBLE);
                Random r1 = new Random();
                int i11 = r1.nextInt(10 - 1) + 1;
                //substring(0,str.length()-1);
                if(i11 == 1) {
                    urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses/";
                }
                else if(i11 == 2){
                    urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses/";
                }
                else if(i11 == 3){
                    urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses";
                }
                else if(i11 == 4){
                    urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses";
                }
                else if(i11 == 5){
                    urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses//";
                }
                else if(i11 == 6){
                    urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses//";
                }
                else if(i11 == 7){
                    urls = "http://www.bitamins.bmwaresd.com/verses/api/bitamins/getverses///";
                }
                else if(i11 == 8){
                    urls = "http://bitamins.bmwaresd.com/verses/api/bitamins/getverses///";
                }

                new bg1().execute();

            }
        });
        hs.startAnimation(slide_down);

    }

    public void screenshot(View view)
    {
        water.setVisibility(View.VISIBLE);

        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.content_main);
        rl.post(new Runnable() {
            @Override
            public void run() {
                Bitmap pic = takescreenshot(rl);
                try{
                    if( pic != null)
                    {
                        savescreenshot(pic);
                    }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg/png");
        final File photoFile = new File(Environment.getExternalStorageDirectory()+File.separator+"player.png");
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
        startActivity(Intent.createChooser(shareIntent, "Share image using"));

    }
    private Bitmap takescreenshot(View v)
    {
        Bitmap screenshot= null;
        try{

            int width = v.getMeasuredWidth();
            int height = v.getMeasuredHeight();
            screenshot = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(screenshot);
            v.draw(c);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return screenshot;

    }

    private void savescreenshot(Bitmap bm)
    {
        ByteArrayOutputStream bao = null;
        File file = null;
        try{
            bao = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 40, bao);

            file = new File(Environment.getExternalStorageDirectory()+File.separator+"player.png");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bao.toByteArray());
            fos.close();

            water.setVisibility(View.GONE);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }



    private void shareScreen() {
        try {
            File cacheDir = new File(
                    android.os.Environment.getExternalStorageDirectory(),
                    "devdeeds");

            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }


            String path = new File(
                    android.os.Environment.getExternalStorageDirectory(),
                    "devdeeds") + "/screenshot.jpg";

            Utils.savePic(Utils.takeScreenShot(this), path);

            Toast.makeText(getApplicationContext(), "Screenshot Saved", Toast.LENGTH_SHORT).show();


        } catch (NullPointerException ignored) {
            ignored.printStackTrace();
        }
    }





}
