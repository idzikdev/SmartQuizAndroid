package pl.idzikdev;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonRandomQuestion)
    Button buttonRandomQuestion;

    @OnClick(R.id.buttonRandomQuestion)
    public void randomQuestionClick() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
    }
}
