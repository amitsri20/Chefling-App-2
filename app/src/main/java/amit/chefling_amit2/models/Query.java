package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amit on 10/28/2016.
 */
public class Query {
    @SerializedName("results")
    public Results results;

    public Query(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
