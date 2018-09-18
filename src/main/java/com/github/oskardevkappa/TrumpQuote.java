package com.github.oskardevkappa;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author oskar
 * github.com/oskardevkappa/
 * <p>
 * 17.09.2018
 */

public class TrumpQuote {

    private final String
            base_url = "https://api.whatdoestrumpthink.com/api/v1/quotes/",
            random_url = "random/",
            personalized_url = "personalized?q=";

    public TrumpQuote()
    {

    }

    public Quote getRandomQuote() throws IOException
    {
        Request request = new Request.Builder().url(base_url + random_url).build();

        Response response = new OkHttpClient().newCall(request).execute();
        JSONObject object = new JSONObject(response.body().string());

        String message = object.getString("message");

        JSONArray jsonArray = object.getJSONObject("nlp_attributes").getJSONArray("quote_structure").getJSONArray(0);

        String[] structure = new String[jsonArray.length()];

        for (int i = 0; i < structure.length; i++)
        {
            structure[i] = jsonArray.optString(i);
        }
        return new Quote(message, structure, null, QuoteType.RANDOM);

    }

    public Quote getPersonalizedQuote(final String name) throws IOException
    {
        Request request = new Request.Builder().url(base_url + personalized_url + name).build();

        Response response = new OkHttpClient().newCall(request).execute();

        JSONObject object = new JSONObject(response.body().string());

        String message = object.getString("message");


        JSONArray jsonArray = object.getJSONObject("nlp_attributes").getJSONArray("quote_structure").getJSONArray(0);

        String[] structure = new String[jsonArray.length()];

        for (int i = 0; i < structure.length; i++)
        {
            structure[i] = jsonArray.optString(i);
        }

        return new Quote(message, structure, name, QuoteType.PERSONALIZED);
    }

    public class Quote
    {
        private final String message, structure[], nickname;
        private final QuoteType type;

        public Quote(String message, String[] structure, String nickname, QuoteType type)
        {
            this.message = message;
            this.structure = structure;
            this.nickname = nickname;
            this.type = type;
        }

        public String getMessage()
        {
            return message;
        }

        public String[] getStructure()
        {
            return structure;
        }

        public String getNickname()
        {
            return nickname;
        }

        public QuoteType getType()
        {
            return type;
        }

        public boolean isRandom()
        {
            return this.type == QuoteType.RANDOM;
        }

        public boolean isPersonalized()
        {
            return this.type == QuoteType.PERSONALIZED;
        }

        public boolean hasNickname()
        {
            return nickname != null;
        }
    }

    public enum QuoteType
    {
        RANDOM(),
        PERSONALIZED;

        QuoteType()
        {

        }
    }
}
