package com.hjp.galleryillumination;

/**
 *
 * @author Henry Perrottet
 */
public class GalleryIllumination {
    
    public static void main(String args[]){
        String[] floorPlan = {"O.........",
                              "###.OO....",
                              ".....#...O",
                              ".O........"};
        int darkCells = countDarkCells(floorPlan, 4, 10);
            
        System.out.println("\nNumber of unlit cells in floor plan: " + darkCells);
        
        floorPlan = new String[] {"O"};
        darkCells = countDarkCells(floorPlan, 1, 1);
        System.out.println("\nNumber of unlit cells in floor plan: " + darkCells);
    }
    
    public static int countDarkCells(String[] floorPlan, int R, int C){
        //cast light
        for(int row = 0; row < R; row++){
            for(int col = 0; col < C; col++){
                if(floorPlan[row].charAt(col) == 'O'){
                    floorPlan = castLight(floorPlan, row, col, R, C);
                }
            }
        }
        System.out.println("\n\n Illuminated floor plan: \n");
        for(int i = 0; i < R; i++){
            System.out.println(floorPlan[i]);
        }
        int darkCells = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(floorPlan[i].charAt(j) == '.'){
                    darkCells++;
                }
            }
        }
        return darkCells;
    }
    
    public static String[] castLight(String[] floorPlan, int lampR, int lampC, int R, int C){
        int n = lampR, s = lampR;
        int e = lampC, w = lampC;
        boolean nDone = false, sDone = false , eDone = false , wDone = false;
        String[] newFloor = new String[C];
        
        //find the extent that the light will shine in each direction N E S W
        while(true){
            if(n > 0 && floorPlan[n-1].charAt(lampC) != '#' ){ n--; }
            else{ nDone = true; }
            if(s < R-1 && floorPlan[s+1].charAt(lampC) != '#' ){ s++; }           
            else{ sDone = true; }
            if(e < C-1 && floorPlan[lampR].charAt(e+1) != '#' ){ e++; }
            else{ eDone = true; }
            if(w > 0 && floorPlan[lampR].charAt(w-1) != '#') { w--; }
            else{ wDone = true; }
            
            if(nDone && sDone && eDone && wDone){ break; }
        }
                
        //go through the floor and cast light
        for(int rI = 0; rI < R; rI++){
            if(rI == lampR){
                String newRow = "";
                for(int cI = 0; cI < C; cI++){
                    if(cI >= w && cI <= e && floorPlan[lampR].charAt(cI) != 'O'){
                        newRow += "*";
                    }
                    else{
                        newRow += floorPlan[lampR].charAt(cI);
                    }
                }
                newFloor[rI] = newRow;
            }
            else{
                if(rI >= n && rI <= s){
                    newFloor[rI] = floorPlan[rI].substring(0,lampC)+ "*" + floorPlan[rI].substring(lampC+1);
                }
                else{
                    newFloor[rI] = floorPlan[rI];
                }
            }
        }
        
        return newFloor;
    }
}

