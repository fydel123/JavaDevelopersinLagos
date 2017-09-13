package com.example.fydel.javadevelopersinlagos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.fydel.javadevelopersinlagos.R;

/**
 * Created by FYDEL on 13-Sep-17.
 */

public class DeveloperDetails extends AppCompatActivity implements View.OnClickListener {
    TextView Link, Username;
    Toolbar mActionBarToolbar;
    ImageView imageView;
    Button user_share;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.user_image_header);
        Username = (TextView) findViewById(R.id.username);
        Link = (TextView) findViewById(R.id.link);
        user_share = (Button) findViewById(R.id.user_share);

        user_share.setOnClickListener(this);

        String username = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        Link.setText(link);
        Linkify.addLinks(Link, Linkify.WEB_URLS);

        Username.setText(username);
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.loading)
                .into(imageView);
        String title = getIntent().getStringExtra("login");
        setTitle(title +"'s" + " Profile");


    }

    private Intent createShareForecastIntent() {
        String username = getIntent().getExtras().getString("login");
        String html_url = getIntent().getExtras().getString("html_url");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @" + username + ", " + html_url)
                .getIntent();
        return shareIntent;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForecastIntent());
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_share:
                String username = getIntent().getExtras().getString("login");
                String html_url = getIntent().getExtras().getString("html_url");
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer @" + username + ", " + html_url);
                startActivity(i);
                break;
        }
    }

}
