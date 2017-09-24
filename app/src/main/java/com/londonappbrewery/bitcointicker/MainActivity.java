package com.londonappbrewery.bitcointicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.provider.UserDictionary.Words.APP_ID;


public class MainActivity extends AppCompatActivity {

    // Constants:
    // TODO: Create the base URL
    private final String BASE_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTC";

    // Member Variables:
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = (TextView) findViewById(R.id.priceLabel);
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // TODO: Set an OnItemSelected listener on the spinner
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                RequestParams requestParams=new RequestParams();




               if(position==0){
                   String NEW_URL=BASE_URL+"AUD";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==1){
                  String NEW_URL=BASE_URL+"BRL";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==2){
                   String NEW_URL=BASE_URL+"CAD";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==3){
                   String NEW_URL=BASE_URL+"CNY";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==4){
                   String NEW_URL=BASE_URL+"EUR";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==5){
                   String NEW_URL=BASE_URL+"GBP";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==6){
                   String NEW_URL=BASE_URL+"HKD";
                   letsDoSomeNetworking(NEW_URL);
               }else if(position==7){
                   String NEW_URL=BASE_URL+"JPY";
                   letsDoSomeNetworking(NEW_URL);}
               else if(position==8){
                   String NEW_URL=BASE_URL+"PLN";
                   letsDoSomeNetworking(NEW_URL);
               }
               else if(position==9){
                   String NEW_URL=BASE_URL+"RUB";
                   letsDoSomeNetworking(NEW_URL);
               }
               else if(position==10){
                   String NEW_URL=BASE_URL+"SEK";
                   letsDoSomeNetworking(NEW_URL);
               }
               else if(position==11){
                  String NEW_URL=BASE_URL+"USD";
                   letsDoSomeNetworking(NEW_URL);
               }
               else if(position==12){
                   String NEW_URL=BASE_URL+"ZAR";
                   letsDoSomeNetworking(NEW_URL);
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Bitcoin", "Nothing selected");
            }
        });

    }

    // TODO: complete the letsDoSomeNetworking() method
    private void letsDoSomeNetworking(String url) {
        Log.i("Pritish", "letsDoSomeNetworking: "+url);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
               
                DataModel dataModel = DataModel.fromJSON(response);
                updateUI(dataModel);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {

                Log.e("ERROR", e.toString());
                Toast.makeText(MainActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void updateUI(DataModel dataModel){
        mPriceTextView.setText(dataModel.getAskprice());

    }
}
