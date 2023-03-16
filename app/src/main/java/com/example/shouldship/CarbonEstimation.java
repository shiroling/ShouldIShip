package com.example.shouldship;

public class CarbonEstimation {
    private String id;
    private Transport transport;
    private double weight;
    private double distance;
    private WeightUnit weightUnit;
    private DistanceUnit distanceUnit;
    private String estimationDate;

    // private  "estimated_at": "2020-07-31T13:00:04.446Z",  je sais pas quoi mettre comme datatype
    private double carbonG;
    private double carbon_lb;
    private double carbon_kg;
    private double carbon_mt;

    public CarbonEstimation requestEstimation(Transport transport, float weight, float distance, WeightUnit weightUnit, DistanceUnit distanceUnit) {
        this.transport = transport;
        this.weight = weight;
        this.distance = distance;
        this.weightUnit = weightUnit;
        this.distanceUnit = distanceUnit;



        // Manque l'appel à l'api

        // Remplissage en fonction du retour

        return this;
    }

    public CarbonEstimation() {
    }

    public CarbonEstimation getEtimationFromId(String id) {
        CarbonEstimation ca = new CarbonEstimation();

        // Manque l'appel à l'api
        // GET https://www.carboninterface.com/api/v1/estimates/<ID>

        // Remplissage en fonction du retour

        return ca;
    }


}
