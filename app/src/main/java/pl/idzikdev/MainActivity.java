package pl.idzikdev;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import pl.idzikdev.model.Question;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.buttonRandomQuestion)
//    Button buttonRandomQuestion;

    //    @OnClick(R.id.buttonRandomQuestion)
//    public void randomQuestionClick() {
//
//    }
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        button1 = findViewById(R.id.buttonRandomQuestion);
    }

    public void clickButton2(View view) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.w("@@@@@@@@@@@@@@@@@@@@@@@@@ HELLO", "KITTY");
                try {
                    URL quizURL = new URL("http://54.37.138.230:8030/questionRest");
                    HttpURLConnection myConnection =
                            (HttpURLConnection) quizURL.openConnection();
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");

                        JsonReader response = new JsonReader(responseBodyReader);
//                        JSONArray json = new JSONArray(response);
//                        ArrayList<Question> list = new ArrayList<>();
                        Log.w("----",responseBody.toString());
                        Log.w("----",responseBodyReader.toString());
                        Log.w("--------",response.toString());
                        String json = "[" +
                                "{\"name\":\"foo\",\"address\":\"London\"}," +
                                "{\"name\":\"bar\",\"address\":\"Berlin\"}," +
                                "{\"name\":\"pho\",\"address\":\"Paris\"} " +
                                "]";


                        Gson gson = new Gson();
                        Type listType = new TypeToken<List<Question>>() {
                        }.getType();
                        List<Question> sample = gson.fromJson(responseBodyReader, listType);
                        Log.w("------------------",  sample.size() + "");
                        sample.forEach(a -> Log.w("----", a.toString()));//
                    } else {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void clickButton(View view) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.w("@@@@@@@@@@@@@@@@@@@@@@@@@ HELLO", "KITTY");
                try {
                    URL quizURL = new URL("http://54.37.138.230:8030/questionRest");
                    HttpURLConnection myConnection =
                            (HttpURLConnection) quizURL.openConnection();
                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        // Further processing here
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
//                            if (key.equals("organization_url")) { // Check if desired key
                            // Fetch the value as a String
                            String value = jsonReader.nextString();
                            Log.w("@@@@@@@@ KLUCZ @@@@@@", key);
                            Log.w("@@@@@@@@ VALUE @@@@@@", value);

//                            break; // Break out of the loop
//                            } else {
//                                jsonReader.skipValue(); // Skip values of other keys
//                            }
                        }
                    } else {
                        // Error handling code goes here
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
