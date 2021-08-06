package com.example.asosexercise.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.asosexercise.R;
import com.squareup.picasso.Picasso;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RecyclerViewDetails extends AppCompatActivity {

    String iconLaunchImageUrl;
    TextView titleDetails, missionName, dateTime, rocketName, daysSinceFromTitle, daysSinceFrom,
            articleLink, wikipediaLink, youtubeLink;
    ImageView iconLaunchImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_details);

        initParams();
        getData();
        setData();

    }

    private void initParams() {
        iconLaunchImage = findViewById(R.id.details_image_view);
        titleDetails = findViewById(R.id.details_item_title);
        missionName = findViewById(R.id.mission_name);
        dateTime = findViewById(R.id.date_time_item);
        rocketName = findViewById(R.id.rocket_text);
        daysSinceFromTitle = findViewById(R.id.launch_days_title);
        daysSinceFrom = findViewById(R.id.days_since_from);
        articleLink = findViewById(R.id.article_link);
        wikipediaLink = findViewById(R.id.wikipedia_link);
        youtubeLink = findViewById(R.id.youtube_link);
    }

    private void getData() {
        if (getIntent().hasExtra("launchIcon")) {
            iconLaunchImageUrl = getIntent().getStringExtra("launchIcon");
        } else {
            titleDetails.setText(R.string.return_api_error);
        }
    }

    private void setData() {
        Picasso.with(getApplicationContext()).load(iconLaunchImageUrl).into(iconLaunchImage);
        missionName.setText(getIntent().getStringExtra("missionName"));
        dateTime.setText(getIntent().getCharSequenceExtra("dateTime"));
        rocketName.setText(getIntent().getStringExtra("rocketName"));
        daysSinceFromTitle.setText(getIntent().getStringExtra("daysSinceFromTitle"));
        daysSinceFrom.setText(getIntent().getStringExtra("daysSinceFrom"));

        articleLink.setMovementMethod(LinkMovementMethod.getInstance());
        articleLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(getIntent().getStringExtra("articleLink")));
            startActivity(browserIntent);
        });

        wikipediaLink.setMovementMethod(LinkMovementMethod.getInstance());
        wikipediaLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(getIntent().getStringExtra("wikipediaLink")));
            startActivity(browserIntent);
        });

        youtubeLink.setMovementMethod(LinkMovementMethod.getInstance());
        youtubeLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(getIntent().getStringExtra("youtubeLink")));
            startActivity(browserIntent);
        });
    }
}