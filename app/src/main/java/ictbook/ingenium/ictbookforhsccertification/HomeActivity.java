package ictbook.ingenium.ictbookforhsccertification;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.List;

import ictbook.ingenium.ictbookforhsccertification.Fragments.ContentFragment;
import ictbook.ingenium.ictbookforhsccertification.Fragments.InfoFragment;
import ictbook.ingenium.ictbookforhsccertification.Fragments.QuizFragment;
import ictbook.ingenium.ictbookforhsccertification.Fragments.VideoFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    int ii=0;
    int Identifier;
    private boolean exit =false;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                final PackageManager pm = getPackageManager();
                final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
                ResolveInfo best = null;
                for (final ResolveInfo info : matches)
                    if (info.activityInfo.packageName.endsWith(".gm") ||
                            info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
                if (best != null) {
                    intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

                    String[] TO = {"ingeniumbd4@gmail.com"};
                    String[] CC = {"info.ict@gmail.com"};
                    intent.setData(Uri.parse("mailto:"));
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, TO);
                    intent.putExtra(Intent.EXTRA_CC, CC);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "About ICT Book For HSC Certification");
                    intent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                    startActivity(intent);
                }
                else {

                    Intent intent1 = new Intent(Intent.ACTION_SEND);
                    String[] TO = {"ingeniumbd4@gmail.com"};
                    String[] CC = {"info.ict@gmail.com"};
                    intent1.setData(Uri.parse("mailto:"));
                    intent1.setType("text/plain");
                    intent1.putExtra(Intent.EXTRA_EMAIL, TO);
                    intent1.putExtra(Intent.EXTRA_CC, CC);
                    intent1.putExtra(Intent.EXTRA_SUBJECT, "About ICT Book For HSC Certification");
                    intent1.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                    startActivity(intent1);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new InfoFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
     /*
            if (exit==true) {
                finish(); // finish activity
            } else {

                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);

                }
                */
                super.onBackPressed();

            }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        FragmentManager fm = getFragmentManager();
        if (id == R.id.action_about) {
            fm.beginTransaction().replace(R.id.content_frame, new InfoFragment()).commit();
            return true;
        } else if (id == R.id.action_exit) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Exit Application?");
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        FragmentManager fm = getFragmentManager();

        fragmentTransaction = fm.beginTransaction();

        // ContentFragment contentFragment = (ContentFragment) fm.findFragmentById(R.id.content_fragment);

        ContentFragment contentFragment = new ContentFragment();
        int id = item.getItemId();

        if (id == R.id.nav_cptOne) {

            Identifier = 1;
            contentFragment.putIdentifier(Identifier);

            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chapterone");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_CptTwo) {
            Identifier = 2;
            contentFragment.putIdentifier(Identifier);
            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chaptertwo");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cptThree) {
            Identifier = 3;
            contentFragment.putIdentifier(Identifier);
            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chapterthree");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cptFour) {
            Identifier = 4;
            contentFragment.putIdentifier(Identifier);
            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chapterfour");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cptFive) {
            Identifier = 5;
            contentFragment.putIdentifier(Identifier);
            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chapterfive");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cptSix) {
            Identifier = 6;
            contentFragment.putIdentifier(Identifier);
            fragmentTransaction.replace(R.id.content_frame, contentFragment);
            fragmentTransaction.addToBackStack("chaptersix");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_quiz) {
            fragmentTransaction.replace(R.id.content_frame, new QuizFragment());
            fragmentTransaction.addToBackStack("quiz");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_video) {
            fragmentTransaction.replace(R.id.content_frame, new VideoFragment());
            fragmentTransaction.addToBackStack("video");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Join with ICT Book For HSC Certification app, is an amazing app for ICT education of HSC!- https://goo.gl/Eg0Sgb");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else if (id == R.id.nav_send) {


            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            final PackageManager pm = getPackageManager();
            final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
            ResolveInfo best = null;
            for (final ResolveInfo info : matches)
                if (info.activityInfo.packageName.endsWith(".gm") ||
                        info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
            if (best != null)
            {
                intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

                String[] TO = {"ingeniumbd4@gmail.com"};
                String[] CC = {"info.ict@gmail.com"};
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_SUBJECT, "About ICT Book For HSC Certification");
                intent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(intent);
            }
            else {
                Intent intent1 = new Intent(Intent.ACTION_SEND);

                String[] TO = {"ingeniumbd4@gmail.com"};
                String[] CC = {"info.ict@gmail.com"};
                intent1.setData(Uri.parse("mailto:"));
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_EMAIL, TO);
                intent1.putExtra(Intent.EXTRA_CC, CC);
                intent1.putExtra(Intent.EXTRA_SUBJECT, "About ICT Book For HSC Certification");
                intent1.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(intent1);
            }



        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


}
