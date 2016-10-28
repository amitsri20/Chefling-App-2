package amit.chefling_amit2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import amit.chefling_amit2.api.ApiClient;
import amit.chefling_amit2.api.YahooApi;
import amit.chefling_amit2.models.QueryInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ForecastAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_forecast);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        getSupportActionBar().setElevation(0f);
        if(isNetworkAvailable()) {
            loadItems();
        }
        else Toast.makeText(this,"Not connected to internet",Toast.LENGTH_LONG).show();
    }
    private void loadItems() {
        YahooApi apiService =
                ApiClient.getClient().create(YahooApi.class);

        Call<QueryInfo> call = apiService.loadItems();
        call.enqueue(new Callback<QueryInfo>() {

            @Override
            public void onResponse(Call<QueryInfo> call, Response<QueryInfo> response) {
                try {

                    QueryInfo forecastData = response.body();
                    Log.d("onResponse", forecastData.getQuery().getResults().getChannel().getItem().getForecast().get(1).getDay());
                    adapter = new ForecastAdapter(forecastData.getQuery().getResults().getChannel().getItem().getForecast(), R.layout.list_item_forecast, getApplicationContext());
                    recyclerView.setAdapter(adapter);


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<QueryInfo> call, Throwable t) {

            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
