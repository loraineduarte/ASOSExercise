package com.example.asosexercise.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asosexercise.Model.Launch;
import com.example.asosexercise.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Launch> launches;
    Context context;

    public RecyclerViewAdapter(Context c, List<Launch> launchArray) {
        context = c;
        launches = launchArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        int launchDays = setLaunchDays(launches.get(position).getLaunch_date_local());
        String launchDaysTitle = "";
        holder.missionName.setText(launches.get(position).getMission_name());
        holder.missionDate.setText(setDate(launches.get(position).getLaunch_date_local()));
        holder.rocketName.setText(launches.get(position).getRocket().getRocket_name());

        if (launchDays > 0) {
            launchDaysTitle = "Days since now:";
            holder.daysSinceFromLaunch.setText(R.string.days_since);
            holder.daysFromLaunch.setText(String.valueOf(launchDays));
        } else if (launchDays < 0) {
            launchDaysTitle = "Days from now:";
            holder.daysSinceFromLaunch.setText(launchDaysTitle);
            launchDays = launchDays * -1;
            holder.daysFromLaunch.setText(String.valueOf(launchDays));
        }

        Picasso.with(context)
                .load(launches.get(position).getLinks().getMission_patch_small())
                .into(holder.launchImage);

        if (launches.get(position).isLaunch_success()) {
            holder.successImage.setImageResource(R.drawable.outline_done_24);
        } else {
            holder.successImage.setImageResource(R.drawable.outline_close_24);
        }

        String finalLaunchDays = String.valueOf(launchDays);
        String finalLaunchDaysTitle = launchDaysTitle;
        holder.mainLayout.setOnClickListener(view ->
                openItemDetails(launches.get(position).getLinks().getMission_patch_small(),
                        launches.get(position).getMission_name(),
                        setDate(launches.get(position).getLaunch_date_local()),
                        launches.get(position).getRocket().getRocket_name(),
                        finalLaunchDays, finalLaunchDaysTitle,
                        launches.get(position).getLinks().getArticle_link(),
                        launches.get(position).getLinks().getWikipedia(),
                        launches.get(position).getLinks().getVideo_link()
                ));
    }

    @Override
    public int getItemCount() {
        return launches.size();
    }

    @SuppressLint("SimpleDateFormat")
    public CharSequence setDate(Date view) {
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
        String date = formatterDate.format(view);
        String time = formatterTime.format(view);
        return (date + " at " + time);
    }

    private int setLaunchDays(Date launchDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = Calendar.getInstance().getTime();
        try {
            firstDate = sdf.parse(String.valueOf(LocalDate.now()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert firstDate != null;
        long diffInMillies = Math.abs(launchDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return Math.toIntExact(diff);
    }

    private void openItemDetails(String launchImage, String missionName,
                                 CharSequence dateTime, String rocketName, String finalLaunchDays,
                                 String daysSinceFromTitle, String articleLink, String wikipediaLink,
                                 String youtubeLink) {

        Intent intent = new Intent(context, RecyclerViewDetails.class);
        intent.putExtra("launchIcon", launchImage);
        intent.putExtra("missionName", missionName);
        intent.putExtra("dateTime", dateTime);
        intent.putExtra("rocketName", rocketName);
        intent.putExtra("daysSinceFrom", finalLaunchDays);
        intent.putExtra("daysSinceFromTitle", daysSinceFromTitle);
        intent.putExtra("articleLink", articleLink);
        intent.putExtra("wikipediaLink", wikipediaLink);
        intent.putExtra("youtubeLink", youtubeLink);
        context.startActivity(intent);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView missionName;
        TextView missionDate;
        TextView rocketName;
        TextView daysFromLaunch;
        TextView daysSinceFromLaunch;
        ImageView successImage;
        ImageView launchImage;

        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            missionName = itemView.findViewById(R.id.mission_text_view);
            missionDate = itemView.findViewById(R.id.date_time_text_view);
            rocketName = itemView.findViewById(R.id.rocket_text_view);
            daysFromLaunch = itemView.findViewById(R.id.days_text_view);
            daysSinceFromLaunch = itemView.findViewById(R.id.days_since_from_text_view);
            successImage = itemView.findViewById(R.id.successImage);
            launchImage = itemView.findViewById(R.id.imageView);

            mainLayout = itemView.findViewById(R.id.recycler_view_item);
        }
    }

}
