package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by amit on 10/28/2016.
 */
public class Item {
    @SerializedName("forecast")
    public ArrayList<Forecast> forecast;

    public Item(ArrayList<Forecast> forecast) {
        this.forecast = forecast;
    }

    public ArrayList<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<Forecast> forecast) {
        this.forecast = forecast;
    }
}
