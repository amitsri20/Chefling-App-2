package amit.chefling_amit2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import amit.chefling_amit2.models.Forecast;

/**
 * Created by amit on 10/28/2016.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private static final int VIEW_TYPE_TODAY = 0;
    private static final int VIEW_TYPE_FUTURE_DAY = 1;
    private List<Forecast> forecasts;
    private int rowLayout;
    private Context context;




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mDateView;
        public final TextView mDescriptionView;
        public final TextView mHighTempView;
        public final TextView mLowTempView;

        public ViewHolder(View view) {
            super(view);
            mDateView = (TextView) view.findViewById(R.id.list_item_date_textview);
            mDescriptionView = (TextView) view.findViewById(R.id.list_item_forecast_textview);
            mHighTempView = (TextView) view.findViewById(R.id.list_item_high_textview);
            mLowTempView = (TextView) view.findViewById(R.id.list_item_low_textview);
        }
    }

    public ForecastAdapter(List<Forecast> forecast, int rowLayout, Context context) {
        this.forecasts = forecast;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
//        return new ViewHolder(view);

        if ( parent instanceof RecyclerView ) {
            int layoutId = -1;
            switch (viewType) {
                case VIEW_TYPE_TODAY: {
                    layoutId = R.layout.list_item_forecast_today;
                    break;
                }
                case VIEW_TYPE_FUTURE_DAY: {
                    layoutId = R.layout.list_item_forecast;
                    break;
                }
            }
            View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            view.setFocusable(true);
            return new ViewHolder(view);
        } else {
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Forecast item = forecasts.get(position);
        boolean useLongToday;

        switch (getItemViewType(position)) {
            case VIEW_TYPE_TODAY:
                useLongToday = true;
                break;
            default:
                useLongToday = false;
        }
        holder.mDateView.setText(forecasts.get(position).getDate());
        holder.mDescriptionView.setText(forecasts.get(position).getText());
        holder.mHighTempView.setText(forecasts.get(position).getHigh()+ " \u2109");
        holder.mLowTempView.setText(forecasts.get(position).getLow()+ " \u2109");
    }


    @Override
    public int getItemCount() {
        return forecasts.size();
    }
    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEW_TYPE_TODAY : VIEW_TYPE_FUTURE_DAY;
    }
}
