package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amit on 10/28/2016.
 */
public class Channel {
    @SerializedName("item")
    public Item item;

    public Channel(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
