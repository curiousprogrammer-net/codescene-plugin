package org.jenkinsci.plugins.codescene.Domain;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class Improvements {
    private final List<String> is = new ArrayList<>();

    public static Improvements In(JsonObject deltaResult) {
        return new Improvements(deltaResult);
    }

    private Improvements(JsonObject deltaResult) {
        if (deltaResult.containsKey("improvements")) {
            parseTestFrom(deltaResult);
        }
    }

    private void parseTestFrom(JsonObject deltaResult) {
        final JsonArray improvements = deltaResult.getJsonArray("improvements");

        for (int i = 0; i < improvements.size(); ++i) {
            is.add(improvements.getString(i));
        }
    }

    public List<String> value() {
        return new ArrayList<>(is);
    }
}
