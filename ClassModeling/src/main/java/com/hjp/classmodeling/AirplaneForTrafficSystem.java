package com.hjp.classmodeling;

/**
 *
 * @author Henry Perrottet
 */
public class AirplaneForTrafficSystem {
    private double[] latitudeLongitude;
    private String origin, destination;
    
    public AirplaneForTrafficSystem(String _origin, String _destination, double[] _latLong){
        this.latitudeLongitude = _latLong;
        this.origin = _origin;
        this.destination = _destination;
    }
    
    public void reroute(String _newDestination){
        this.destination = _newDestination;
    }
    public double[] getCoords(){
        return this.latitudeLongitude;
    }
}
