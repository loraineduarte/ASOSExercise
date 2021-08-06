package com.example.asosexercise;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.asosexercise.Api.Methods;
import com.example.asosexercise.Api.RetrofitClient;
import com.example.asosexercise.Model.CompanyModel;
import com.example.asosexercise.Model.Launch;
import com.example.asosexercise.RecyclerView.RecyclerViewAdapter;
import com.example.asosexercise.databinding.ActivityScrollingBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.leakcanary.LeakCanary;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("NullableProblems")
@RequiresApi(api = Build.VERSION_CODES.O)
public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;
    Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);

    List<Launch> launchesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.filterButton.setOnClickListener(view -> loadFilterDialog());

        loadCompanyInfo();
        loadLaunchesInfo();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(getApplication());
    }

    private void loadFilterDialog() {
        final Dialog dialog = new Dialog(ScrollingActivity.this);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.layout_filter);

        final TextInputEditText yearFilter = dialog.findViewById(R.id.year_input_text);
        final RadioButton yearRadioButton = dialog.findViewById(R.id.filter_year);
        final RadioButton successfulRadioButton = dialog.findViewById(R.id.filter_successfull);
        final RadioButton ascRadioButton = dialog.findViewById(R.id.order_asc);
        final RadioButton descRadioButton = dialog.findViewById(R.id.order_desc);
        TextView applyButton = dialog.findViewById(R.id.positive_button);
        TextView cancelButton = dialog.findViewById(R.id.negative_button);

        applyButton.setOnClickListener(view -> {
            boolean ascButton = ascRadioButton.isChecked();
            boolean descButton = descRadioButton.isChecked();
            boolean yearButton = yearRadioButton.isChecked();
            String yearInputText = Objects.requireNonNull(yearFilter.getText()).toString();
            if (yearButton && yearInputText.equals("")) {
                yearInputText = String.valueOf(2018);
            }
            boolean successButton = successfulRadioButton.isChecked();

            populateFilterInfo(ascButton, descButton, yearButton, yearInputText, successButton);

            dialog.dismiss();
        });

        cancelButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
    }

    private void loadCompanyInfo() {

        Call<CompanyModel> call = methods.getAllData();
        call.enqueue(new Callback<CompanyModel>() {
            @Override
            public void onResponse(Call<CompanyModel> call, Response<CompanyModel> response) {

                assert response.body() != null;
                String companyText = response.body().getName() + " was founded by " + response.body().getFounder() +
                        " in " + response.body().getFounded() + ". It has now " + response.body().getEmployees() +
                        " employees, " + response.body().getLaunch_sites() + " launch sites, and is valued at USD " +
                        response.body().getValuation();

                binding.companyText.setText(companyText);
            }

            @Override
            public void onFailure(Call<CompanyModel> call, Throwable t) {
                Log.e("ErrorOnCallApi", "Error on return api data");
            }
        });
    }

    private void loadLaunchesInfo() {

        Call<List<Launch>> call = methods.getAllLaunches();
        call.enqueue(new Callback<java.util.List<com.example.asosexercise.Model.Launch>>() {

            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                loadRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                Log.e("ERRO NA API", "onFailure: ", t);
                Toast.makeText(getApplicationContext(), "DEU ERRO", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadRecyclerView(List<Launch> body) {
        launchesList = body;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, launchesList);
        binding.launchesRecyclerView.setAdapter(adapter);
        binding.launchesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateFilterInfo(boolean ascButton, boolean descButton, boolean yearButton, String yearInputText, boolean successButton) {
        Log.i("ASCButton", String.valueOf(ascButton));
        Log.i("YearInputTextButton", String.valueOf(yearInputText));

        if (yearButton) {
            if (ascButton) {
                callYearFilter(yearInputText, "asc");
            } else if (descButton) {
                callYearFilter(yearInputText, "desc");
            } else {
                callYearFilter(yearInputText, "");
            }
        } else if (successButton) {
            if (ascButton) {
                callSuccessFilter(successButton, "asc");
            } else if (descButton) {
                callSuccessFilter(successButton, "desc");
            } else {
                callSuccessFilter(successButton, "");
            }
        }
    }

    private void callSuccessFilter(boolean successButton, String asc) {
        Call<List<Launch>> call = methods.getFilterLaunchesBySuccess(successButton, asc);
        call.enqueue(new Callback<java.util.List<com.example.asosexercise.Model.Launch>>() {

            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                loadRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                Log.e("ERRO NA API", "onFailure: ", t);
                Toast.makeText(getApplicationContext(), "DEU ERRO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callYearFilter(String yearInputText, String asc) {
        Call<List<Launch>> call = methods.getFilterLaunchesByYear(Integer.parseInt(yearInputText), asc);
        call.enqueue(new Callback<java.util.List<com.example.asosexercise.Model.Launch>>() {

            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                loadRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                Log.e("ERRO NA API", "onFailure: ", t);
                Toast.makeText(getApplicationContext(), "DEU ERRO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}