package hva.semen.seyfullah.com.hva_mobile_development_week_5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hva.semen.seyfullah.com.hva_mobile_development_week_5.Adapter.Adapter;
import hva.semen.seyfullah.com.hva_mobile_development_week_5.Retrofit.TriviaJson;
import hva.semen.seyfullah.com.hva_mobile_development_week_5.Services.NumbersApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<TriviaJson> trivias;

    @BindView(R.id.recyclerViewTrivia)
    RecyclerView mRecyclerView;
    @BindView(R.id.addRandomTrivia)
    FloatingActionButton mAddRandomTrivia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        trivias = new ArrayList<>();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Adapter(trivias);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        mRecyclerView.addItemDecoration(itemDecor);
    }

    @OnClick(R.id.addRandomTrivia)
    public void add() {
        requestData();
    }

    private void requestData() {
        NumbersApiService service = NumbersApiService.retrofit.create(NumbersApiService.class);
        retrofit2.Call<TriviaJson> call = service.getRandomQuote();
        call.enqueue(new Callback<TriviaJson>() {
            @Override
            public void onResponse(Call<TriviaJson> call, Response<TriviaJson> response) {
                TriviaJson dayQuoteItem = response.body();
                Log.i(TAG,"Number: "+dayQuoteItem.getNumber()+"  Quote:  "+dayQuoteItem.getText());
                trivias.add(0,new TriviaJson(dayQuoteItem.getText(), dayQuoteItem.getNumber()));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TriviaJson> call, Throwable t) {
                Log.i(TAG, "Something went wrong: " + t.getMessage());
            }

        });
    }
}
