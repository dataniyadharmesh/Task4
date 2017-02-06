package com.dharmesh.task4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class json_example extends AppCompatActivity {


    private static final String TAG = "task" ;
    String jsonString = "{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_example);



        json_example();



    }
    public  void json_example() {



        try {
            JSONObject rootObject = new JSONObject(jsonString);
            JSONObject GlossaryObject = rootObject.getJSONObject("glossary");

            String title = GlossaryObject.getString("title");
            Log.d(TAG,"Title : " +title);



          JSONObject GlossDivObject = GlossaryObject.getJSONObject("GlossDiv");
            String titlegloss = GlossDivObject.getString("title");
            Log.d(TAG, "Title :" + titlegloss);


            JSONObject GlossListObject = GlossDivObject.getJSONObject("GlossList");
            JSONObject GlossEntryObject = GlossListObject.getJSONObject("GlossEntry");


            String id = GlossEntryObject.getString("ID");
            Log.d(TAG, "ID :" + id);


            String sort = GlossEntryObject.getString("SortAs");
            Log.d(TAG, "SortAs :" + sort);



            String gloss_term = GlossEntryObject.getString("GlossTerm");
            Log.d(TAG, "Gloss_term :" + gloss_term);



            String acronym = GlossEntryObject.getString("Acronym");
            Log.d(TAG, "Acronym :" + acronym);


            String abbrev = GlossEntryObject.getString("Abbrev");
            Log.d(TAG, "Abbrev :" + abbrev);

            JSONObject GlossDef = GlossEntryObject.getJSONObject("GlossDef");
            String para = GlossDef.getString("para");
            Log.d(TAG, "para :"+para);

            JSONArray GlossSeeAlso =GlossDef.getJSONArray("GlossSeeAlso");
            for (int i = 0; i <GlossSeeAlso.length() ; i++) {
                String data = GlossSeeAlso.getString(i);
                Log.d(TAG, "glossSeeAlso : " +data);

            }
            String glossSee = GlossEntryObject.getString("GlossSee");
            Log.d(TAG, "glossSee : " + glossSee);




        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }
