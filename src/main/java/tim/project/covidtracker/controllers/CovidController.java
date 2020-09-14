package tim.project.covidtracker.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
public class CovidController {
    @CrossOrigin
    @GetMapping("/covid-positive")
    public CovidStatsOutput covidPositive(@RequestParam(defaultValue = "ca") String states){
            
            String url = "https://api.covidtracking.com/v1/states/" + states + "/current.json";
            RestTemplate restTemplate = new RestTemplate();
            CovidStats result = restTemplate.getForObject(url, CovidStats.class);
            CovidStatsOutput output = new CovidStatsOutput();
            output.positive = result.positive;
            output.negative = result.negative;
            output.testPositiveRate = (double) result.positive / result.total;
            return output;

    }
    @CrossOrigin
    @GetMapping("/school-covid")
    public CovidStatsOutput schoolCovid(@RequestParam(defaultValue = "UW") String schoolName){
//        taking in a school name and return the location of the school with the state abbreviation
        CovidStatsOutput covidOutput = new CovidStatsOutput();
        try {
            String url = "https://nearbycolleges.info/api/alias?q=" + schoolName + "&limit=3&autocomplete";
            RestTemplate restTemplate = new RestTemplate();
            SchoolResult result = restTemplate.getForObject(url, SchoolResult.class);

            String stateFullName = ((LinkedHashMap<String, String>) result.getResult().get(0)).get("state");
            String stateAbbreviation = stateMap().get(stateFullName);
//        taking in the school abbreviation and return the covid positive rate of the state
            String covidUrl = "https://api.covidtracking.com/v1/states/" + stateAbbreviation + "/current.json";
            CovidStats covidResult = restTemplate.getForObject(covidUrl, CovidStats.class);
            covidOutput.positive = covidResult.positive;
            covidOutput.negative = covidResult.negative;
            covidOutput.testPositiveRate = (double) covidResult.positive / covidResult.total;
            covidOutput.state = stateFullName;
            covidOutput.schoolName = ((LinkedHashMap<String, String>) result.getResult().get(0)).get("name");
        }
        catch (IndexOutOfBoundsException e){
            covidOutput.positive = 0;
            covidOutput.negative = 0;
            covidOutput.testPositiveRate = 0;
            covidOutput.state = "N/A";
            covidOutput.schoolName = "School cannot be found";
        }
        return covidOutput;
    }

    public HashMap<String,String> stateMap(){
        HashMap<String, String> statesName = new HashMap();
        statesName.put("Alaska", "ak");
        statesName.put("Illinois","il");
        statesName.put("Michigan","ml");
        statesName.put("New York","ny");
        statesName.put("Washington","wa");
        return statesName;
    }



}



