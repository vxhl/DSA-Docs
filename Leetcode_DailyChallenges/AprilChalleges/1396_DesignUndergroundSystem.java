package Leetcode_DailyChallenges.AprilChalleges;

import java.util.*;

class UndergroundSystem {

    // We have unique IDs so ofc use a map
    // We use the map that has id as they key and the value will be an obj
    // having id, station and time
    // How to keep track of all previous travels? 
    // We have a map called average, so the id here is the combined station names
    // basically if we have A and B as the stations then (A,B) is one key for averages
    // and we have an object containing total and count
    // total is the total travel time between the two stations
    // of customers that have travelled previously through this combination of stations
    private final String DELIMETER = ",";
    static HashMap<Integer, customer_data> customerData;
    static HashMap<String, average_parameters> averages;
    public UndergroundSystem() 
    {
        customerData = new HashMap<>();
        averages = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
            customerData.put(id, new customer_data(id, stationName, t));
    }
    
    // static String station_combination = "";
    // static int total = 0;
    // static int count = 0;
    public void checkOut(int id, String stationName, int t) 
    {
        // We store our arrivals in a arrivals variable
        customer_data customer = customerData.get(id);
        // And then we remove it from the map
        customerData.remove(id);
        int diff = t- customer.t;
        // We need a delimeter since we need a good differentiation between the different keys in our map? 
        String key = customer.stationName + DELIMETER +  stationName;
        // If this concatenated string is in our averages map 
        // then we get the average_parameters object for it to compute our average
        average_parameters Average = averages.containsKey(key) ? averages.get(key) : new average_parameters();
        // We calculate the end time - start time 
        Average.updateAverage(diff);
        // Now we calculate the average
        averages.put(key, Average);



    }
    
    public double getAverageTime(String startStation, String endStation) 
    {
        String stations = startStation + DELIMETER + endStation;
        return averages.get(stations).getAverage();
    }




}

class customer_data
{
    int id;
    String stationName;
    int t;
    public customer_data(int id, String stationName, int t)
    {
        this.id = id;
        this.stationName = stationName;
        this.t = t;
    }
}

class average_parameters
{
    public double total = 0;
    public int count_customers= 0;
    
    public void updateAverage(int diff)
    {
        ++count_customers;
        total+=diff;
    }
    public double getAverage()
    {
        return total/count_customers;
    }

}