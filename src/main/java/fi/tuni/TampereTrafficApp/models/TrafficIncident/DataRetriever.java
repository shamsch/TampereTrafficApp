package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Class for retrieving data from the traffic incident API.
 * 
 * 
 * @author Joel
 */
public class DataRetriever {
    
     // OkHttpClient object
    private OkHttpClient client = new OkHttpClient();
    
     // Constructor accepting OkHttpClient for testing
    public DataRetriever(OkHttpClient client) {
        this.client = client;
    }

    // Default constructor
    public DataRetriever() {
        this.client = new OkHttpClient();
    }
    
    // Hard coded request object
    private final Request request = new Request.Builder().url("https://traffic-incidents.tampere.fi/api/v1").build();
    
    // Returns the traffic incident object, containing a list of different incidents
    public SituationReport getResponse() {
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                
                // Get the response as a string
                String json = response.body().string();
                
                // Convert the response to a JsonObject
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                
                Gson gson = new Gson();
                
                return gson.fromJson(jsonObject, SituationReport.class);
                
            } else {
                System.out.println("Request failed: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return null;
    }
}
