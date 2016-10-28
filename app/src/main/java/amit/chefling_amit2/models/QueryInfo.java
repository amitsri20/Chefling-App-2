package amit.chefling_amit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amit on 10/28/2016.
 */

public class QueryInfo {
    @SerializedName("query")
    public Query query;

    public QueryInfo(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
