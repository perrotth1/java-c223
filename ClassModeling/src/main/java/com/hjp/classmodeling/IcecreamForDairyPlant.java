package com.hjp.classmodeling;

/**
 *
 * @author Henry Perrottet
 */
public class IcecreamForDairyPlant {
    public enum productionPhases { MIXING, COOLING, READY };
    private String flavor;
    private productionPhases productionPhase;
    
    public IcecreamForDairyPlant(String _flavor){
        this.flavor = _flavor;
    }
    public void setProductionPhase( productionPhases _phase ){
        this.productionPhase = _phase;
    }
    public boolean isReadyToShip(){
        if(this.productionPhase == productionPhases.READY){
            return true;
        }
        else{
            return false;
        }   
    }
}
