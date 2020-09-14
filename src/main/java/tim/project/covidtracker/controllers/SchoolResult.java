package tim.project.covidtracker.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchoolResult {
    public ArrayList getResult() {
        return result;
    }

    public void setResult(ArrayList result) {
        this.result = result;
    }

    ArrayList<Map<String, String>> result = new ArrayList();
}
