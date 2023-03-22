package com.example.shouldship.apiCalls;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.shouldship.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarbonEstimation {

    private static final String API_URL = "https://www.carboninterface.com/api/v1/estimates";
    private String id;
    private Transport transport;
    private double weight;
    private double distance;
    private WeightUnit weightUnit;
    private DistanceUnit distanceUnit;
    // private  "estimated_at": "2020-07-31T13:00:04.446Z",  je sais pas quoi mettre comme datatype
    private Date estimationDate;
    private double carbon_lb;
    private double carbon_kg;
    private double carbon_mt;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CarbonEstimation requestEstimation(Transport transport, float weight, float distance, WeightUnit weightUnit, DistanceUnit distanceUnit)
            throws IOException, JSONException, ParseException {
        this.transport = transport;
        this.weight = weight;
        this.distance = distance;
        this.weightUnit = weightUnit;
        this.distanceUnit = distanceUnit;

        // Create the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("type", "shipping");
        requestBody.put("weight_value", weight);
        requestBody.put("weight_unit", weightUnit.toString());
        requestBody.put("distance_value", distance);
        requestBody.put("distance_unit", distanceUnit.toString());
        requestBody.put("transport_method", transport.toString());

        // Open a connection to the API endpoint
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer N1yDYHec4afQtPK7TlxSiA");

        // Send the request body
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(requestBody.toString().getBytes());
        outputStream.flush();
        outputStream.close();

        // Read the response
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder responseStringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            responseStringBuilder.append(line);
        }
        bufferedReader.close();
        inputStream.close();

        // Parse the JSON response
        JSONObject responseJson = new JSONObject(responseStringBuilder.toString());
        JSONObject dataJson = responseJson.getJSONObject("data");
        JSONObject attributesJson = dataJson.getJSONObject("attributes");

        // Get the estimated carbon emissions value

        setEstimationDate(attributesJson.getString("estimated_at"));
        setCarbon_lb(attributesJson.getDouble("carbon_lb"));
        setCarbon_kg(attributesJson.getDouble("carbon_kg"));
        setCarbon_mt(attributesJson.getDouble("carbon_mt"));

        return this;
    }

    public CarbonEstimation() {
    }

    public CarbonEstimation findById(String id) throws IOException, JSONException, ParseException {
        // Open a connection to the API endpoint
        URL url = new URL(API_URL + "/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer N1yDYHec4afQtPK7TlxSiA");

        // Read the response
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder responseStringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            responseStringBuilder.append(line);
        }
        bufferedReader.close();
        inputStream.close();

        // Parse the JSON response
        JSONObject responseJson = new JSONObject(responseStringBuilder.toString());
        JSONObject dataJson = responseJson.getJSONObject("data");
        JSONObject attributesJson = dataJson.getJSONObject("attributes");

        // Create a new CarbonEstimation object from the JSON data
        CarbonEstimation ca = new CarbonEstimation();
        ca.setId(dataJson.getString("id"));
        ca.setTransport(Transport.valueOf(attributesJson.getString("transport_method")));
        ca.setWeight(attributesJson.getDouble("weight_value"));
        ca.setWeightUnit(WeightUnit.valueOf(attributesJson.getString("weight_unit")));
        ca.setDistance(attributesJson.getDouble("distance_value"));
        ca.setDistanceUnit(DistanceUnit.valueOf(attributesJson.getString("distance_unit")));
        ca.setEstimationDate(attributesJson.getString("estimated_at"));
        ca.setCarbon_lb(attributesJson.getDouble("carbon_lb"));
        ca.setCarbon_kg(attributesJson.getDouble("carbon_kg"));
        ca.setCarbon_mt(attributesJson.getDouble("carbon_mt"));

        return ca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }
    public Date getEstimationDate() {
        return estimationDate;
    }

    public void setEstimationDate(String estimationDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.estimationDate = format.parse(estimationDate);
    }

    public double getCarbon_lb() {
        return carbon_lb;
    }

    public void setCarbon_lb(double carbon_lb) {
        this.carbon_lb = carbon_lb;
    }

    public double getCarbon_kg() {
        return carbon_kg;
    }

    public void setCarbon_kg(double carbon_kg) {
        this.carbon_kg = carbon_kg;
    }

    public double getCarbon_mt() {
        return carbon_mt;
    }

    public void setCarbon_mt(double carbon_mt) {
        this.carbon_mt = carbon_mt;
    }
}
