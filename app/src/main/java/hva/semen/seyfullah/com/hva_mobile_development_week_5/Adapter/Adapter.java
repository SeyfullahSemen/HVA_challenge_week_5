package hva.semen.seyfullah.com.hva_mobile_development_week_5.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hva.semen.seyfullah.com.hva_mobile_development_week_5.R;
import hva.semen.seyfullah.com.hva_mobile_development_week_5.Retrofit.TriviaJson;

/*
 * Created by Seyfullah Semen on 30-10-2018.
 * Adapter to gather the information and load it into the recyclerview which will be filled with information.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<TriviaJson> values;

    public Adapter(List<TriviaJson> triviaDataset) {
        values = triviaDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        // Make a simple check to see if there is no cardviews yet in the recyclerview
        if (viewType == 0) {
            view = inflater.inflate(R.layout.row_item, parent, false);
        } else { // If there is already one, than load in the backwards view
            view = inflater.inflate(R.layout.backwards_item, parent, false);
        }
        // Last but not least return the viewholder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /*
     * Make the bindviewholder method and get the ids of the different views
     * which are placed in the layout xml.
     * */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int number = values.get(position).getNumber();
        String text = values.get(position).getText();
        holder.number.setText(String.valueOf(number));
        holder.description.setText(text);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 * 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView number;
        public TextView description;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            number = view.findViewById(R.id.number_textview);
            description = view.findViewById(R.id.text_trivia);


        }
    }
}
