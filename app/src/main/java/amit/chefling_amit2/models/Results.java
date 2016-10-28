package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amit on 10/28/2016.
 */
public class Results {
    @SerializedName("channel")
    public Channel channel;

    public Results(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
