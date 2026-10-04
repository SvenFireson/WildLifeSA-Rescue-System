
package com.wildlifesa.rescue;


public class EndangeredSpeciesRescue extends RescueCase {
    
    private String conservationClassification;
    private double securityCost;
    private boolean specialistTeamRequired;
    
    public EndangeredSpeciesRescue(
                                    String rescueCaseId,
                                    String animalName,
                                    String species,
                                    String rescueLocation,
                                    String assignedRanger,
                                    int numberOfRescueDays,
                                    double dailyCareCost,
                                    String currentRescueStatus,
                                    String conservationClassification,
                                    double securityCost,
                                    boolean specialistTeamRequired)
                                    {
                                        super(rescueCaseId, animalName, species, rescueLocation, assignedRanger, numberOfRescueDays, dailyCareCost, currentRescueStatus);
                                        
                                        this.conservationClassification = conservationClassification;
                                        this.securityCost = securityCost;
                                        this.specialistTeamRequired = specialistTeamRequired;
                                    }
    
    @Override
    public double calculateTotalRescueCost(){
    
        double totalCost = getNumberOfRescueDays() * getDailyCareCost();
        
        totalCost += securityCost;
        
        if(specialistTeamRequired){
            totalCost += 8000;
        }
        return totalCost;
    }
    
    @Override 
    public String determineRescuePriority(){
    
        if(specialistTeamRequired){
            return "HIGH";
        }else if (conservationClassification.equalsIgnoreCase("Endangered")){
            return "MEDIUM";
        }else{
            return "LOW";
        }
    }
    
    @Override
    public void displayRescueDetails(){
    
        System.out.println("Rescue Case ID: "+ getRescueCaseId());
        System.out.println("Animal Name: "+ getAnimalName());
        System.out.println("Species: "+ getSpecies());
        System.out.println("Rescue Location"+ getRescueLocation());
        System.out.println("Assigned Ranger: "+ getAssignedRanger());
        System.out.println("Number Of rescue Days: "+getNumberOfRescueDays());
        System.out.println("Daily Care Cost: R"+ getDailyCareCost());
        System.out.println("Current rescue Status: "+ getCurrentRescueStatus());
        
        System.out.println("Conservation Classification: "+ conservationClassification);
        System.out.println("Security Costs: R"+securityCost );
        System.out.println("Specialist Team Required: "+specialistTeamRequired );
        
        System.out.println("Rescue Priority: "+ determineRescuePriority());
        System.out.println("Total Rescue Cost: R"+calculateTotalRescueCost());
        
    
        
    }
    
}
