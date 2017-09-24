package com.londonappbrewery.bitcointicker;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pritish on 24/9/17.
 */

public class DataModel {
    private String askprice;
    public static DataModel fromJSON(JSONObject jsonObject) {
        DataModel dataModel = new DataModel();
        try {

            dataModel.askprice = jsonObject.getString("ask");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataModel;
    }

    public String getAskprice() {
        return askprice;
    }


}
