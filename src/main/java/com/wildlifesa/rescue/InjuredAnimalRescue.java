
package com.wildlifesa.rescue;


public class InjuredAnimalRescue extends RescueCase {
    
    private String injuryDescription;
    private double veterinaryTreatmentCost;
    private boolean surgeryRequired;
    
    
    public InjuredAnimalRescue(String rescueCaseId,String animalName,String species,String rescueLocation,String assignedRanger,int numberOfRescueDays,double dailyCareCost,String currentRescueStatus,String injuryDescription, double veterinaryTreatmentCost, boolean surgeryRequired)
    
    {
        super(rescueCaseId, animalName, species, rescueLocation, assignedRanger,numberOfRescueDays, dailyCareCost,currentRescueStatus);
        
        this.injuryDescription =injuryDescription;
        this.veterinaryTreatmentCost = veterinaryTreatmentCost;
        this.surgeryRequired = surgeryRequired;
    }
@Override
public double calculateTotalRescueCost() {
    double totalCost = getNumberOfRescueDays() * getDailyCareCost();
    
    totalCost += veterinaryTreatmentCost;
    
    if(surgeryRequired){
    totalCost += 5000;
    }
    return totalCost;
}
@Override
public String determineRescuePriority(){
    if(surgeryRequired){
        return "HIGH";
    }else if (veterinaryTreatmentCost > 5000){
        return "Medium";
    }else {
        return "Low";
    } 
}
@Override
    public String getRescueType(){
        return "INjured Animal Rescue";
    }

@Override
public void displayRescueDetails(){

    System.out.println("Rescue Case ID: "+ getRescueCaseId());
    System.out.println("Animal Name: "+ getAnimalName());
    System.out.println("Species: "+ getSpecies());
    System.out.println("Rescue Location: "+ getRescueLocation());
    System.out.println("Assigned Ranger: "+ getAssignedRanger());
    System.out.println("Number of Rescue Days: "+ getNumberOfRescueDays());
    System.out.println("Daily Care Cost: R"+ getDailyCareCost());
    System.out.println("Current Status: "+ getCurrentRescueStatus());
    System.out.println("Injury Description: "+ injuryDescription);
    System.out.println("Veterinary Treatment Cost: "+ veterinaryTreatmentCost);
    System.out.println("Surgery Required: "+ surgeryRequired);
    System.out.println("Rescue Priority: "+ determineRescuePriority());
    System.out.println("Total Rescue Cost: R"+ calculateTotalRescueCost());
    

}

    public String getInjuryDescription() {
        return injuryDescription;
    }

    public void setInjuryDescription(String injuryDescription) {
        this.injuryDescription = injuryDescription;
    }

    public double getVeterinaryTreatmentCost() {
        return veterinaryTreatmentCost;
    }

    public void setVeterinaryTreatmentCost(double veterinaryTreatmentCost) {
        this.veterinaryTreatmentCost = veterinaryTreatmentCost;
    }

    public boolean isSurgeryRequired() {
        return surgeryRequired;
    }

    public void setSurgeryRequired(boolean surgeryRequired) {
        this.surgeryRequired = surgeryRequired;
    }
}
