
package com.wildlifesa.rescue;
import java.util.ArrayList;

public class RescueSystem {
    private ArrayList<RescueCase> rescueCases;
    
    public RescueSystem(){
        rescueCases = new ArrayList<>();
    }
    public boolean rescueCaseExists(String rescueCaseId){
        for(RescueCase rescueCase: rescueCases){
            if(rescueCase.getRescueCaseId().equalsIgnoreCase(rescueCaseId)){
            return true;
            }
        }
        return false;
    }
    
    public RescueCase searchRescueCase(String rescueCaseID){
    
        for(RescueCase rescueCase: rescueCases){
        
            if(rescueCase.getRescueCaseId().equalsIgnoreCase(rescueCaseID)){
                return rescueCase;
            }
        }
        return null;
    }
    
    public boolean addRescueCase(RescueCase rescueCase){
        
        if(rescueCaseExists(rescueCase.getRescueCaseId())){
            return false;
    }
        rescueCases.add(rescueCase);
        return true;
    }
    
    public boolean updateRescueStatus(String rescueCaseId, String newStatus){
    
        RescueCase rescueCase = searchRescueCase(rescueCaseId);
    
        if(rescueCase == null){
            return false;
        }
        rescueCase.setCurrentRescueStatus(newStatus);
        return true;
    }
    
    public void displayAllRescueCases(){
        
        if(rescueCases.isEmpty()){
            System.out.println("No rescue cases found.");
            return;
        }
        double totalEstimatedCost = 0;
        for(RescueCase rescueCase: rescueCases){
        
            System.out.println("---------------------------");
            System.out.println("Rescue Case ID: "+ rescueCase.getRescueCaseId());
            System.out.println("Rescue Type: "+ rescueCase.getRescueType());
            System.out.println("Species: "+ rescueCase.getSpecies());
            System.out.println("Location: "+rescueCase.getRescueLocation());
            System.out.println("Assigned Ranger: "+ rescueCase.getAssignedRanger());
            System.out.println("Priority: "+rescueCase.determineRescuePriority());
            System.out.println("Status: "+rescueCase.getCurrentRescueStatus());
            System.out.println("Total Cost: R"+rescueCase.calculateTotalRescueCost());
            
            totalEstimatedCost += rescueCase.calculateTotalRescueCost();
        }
        System.out.println("=================================");
        System.out.println("Total Rescue Cases: "+ rescueCases.size());
        System.out.println("Total Estimated Cost R:" + totalEstimatedCost);
    
    }
    
}
