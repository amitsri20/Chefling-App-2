package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amit on 10/28/2016.
 */
public class Forecast {
    @SerializedName("date")
    public String date;
    @SerializedName("day")
    public String day;
    @SerializedName("high")
    public String high;
    @SerializedName("low")
    public String low;
    @SerializedName("text")
    public String text;

    public Forecast(String date, String day, String high, String low, String text) {
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
