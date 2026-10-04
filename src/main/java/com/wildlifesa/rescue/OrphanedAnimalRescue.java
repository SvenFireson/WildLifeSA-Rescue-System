
package com.wildlifesa.rescue;


public class OrphanedAnimalRescue extends RescueCase {
    
   private int estimatedAgeMonths;
   private double feedingCost;
   private boolean fosterCareRequired;
   
    public OrphanedAnimalRescue (
                                   String rescueCaseId,
                                   String animalName,
                                   String species,
                                   String rescueLocation,
                                   String assignedRanger,
                                   int numberOfRescueDays,
                                   double dailyCareCost,
                                   String currentRescueStatus,
                                   int estimatedAgeMonths,
                                   double feedingCost,
                                   boolean fosterCareRequired
                                   )
                                    {
                                     super(rescueCaseId,animalName,species,rescueLocation,assignedRanger,numberOfRescueDays,dailyCareCost,currentRescueStatus);
                                     
                                     this.estimatedAgeMonths = estimatedAgeMonths;
                                     this.feedingCost = feedingCost;
                                     this.fosterCareRequired = fosterCareRequired;
                                    }
    @Override
    public double calculateTotalRescueCost(){
    
        double totalCost = getNumberOfRescueDays() * getDailyCareCost();
        
        totalCost += feedingCost;
        if(fosterCareRequired){
        totalCost += 2500;
        
    }
     return totalCost;}
    
    @Override
    public String determineRescuePriority(){
    
        if (fosterCareRequired){
            return "HIGH";
        } else if (estimatedAgeMonths <= 6){
            return "MEDIUM";
        } else {
            return "LOW";}
    }
    
    @Override
    public void displayRescueDetails(){
    
        System.out.println("Rescue Case ID: "+ getRescueCaseId());
        System.out.println("Animal Name: "+ getAnimalName());
        System.out.println("Species: "+ getSpecies());
        System.out.println("Rescue Location: "+ getRescueLocation());
        System.out.println("Assigned Ranger: "+ getAssignedRanger());
        System.out.println("Number of Rescue Days: "+ getNumberOfRescueDays());
        System.out.println("Daily Care Cost: R "+ getDailyCareCost());
        System.out.println("Current Status: "+ getCurrentRescueStatus());
        
        System.out.println("Estimated Age (Months): "+ estimatedAgeMonths);
        System.out.println("Feeding Costs : R"+feedingCost);
        System.out.println("Foster Care Required: "+ fosterCareRequired);
        
        System.out.println("Rescue priority: "+ determineRescuePriority());
        System.out.println("Total Rescue Cost: R"+ calculateTotalRescueCost());   
        
    }
    
}
