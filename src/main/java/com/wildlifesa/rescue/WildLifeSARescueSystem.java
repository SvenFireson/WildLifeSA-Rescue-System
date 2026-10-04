

package com.wildlifesa.rescue;

import java.util.Scanner;
public class WildLifeSARescueSystem {

    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       RescueSystem system = new RescueSystem();
       
       int choice;
       
       do{ System.out.println("\n=== Wildlife SA Rescue System ===");
           System.out.println("1. Create Rescue Case");
           System.out.println("2. Search Rescue Case");
           System.out.println("3. Update Rescue Status");
           System.out.println("4. Display All rescue Cases");
           System.out.println("5. Exit");
           System.out.println("Enter your choice: ");
           
           if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            scanner.nextLine();
           }else{
               System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine();
                choice = 0;}
           
           switch(choice){
               case 1:
                   createRescueCase(scanner, system);
                   break;
                   
               case 2:
                   searchRescueCase(scanner, system);
                   break;
                   
               case 3:
                   updateRescueStatus(scanner, system);
                   break;
                   
               case 4:
                   system.displayAllRescueCases();
                   break;
                
               case 5:
                   System.out.println("Exiting WildLife SA Rescue System.");
                   break;
                   
               default:
                   System.out.println("Invalid menu selection");
                           
           }
       
       } while (choice!=5);
       scanner.close();
    } 
    public static void createRescueCase(Scanner scanner, RescueSystem system){
    
        System.out.println("\nSelect Rescue Type: ");
        System.out.println("1. Injured Animal Rescue.");
        System.out.println("2. Orphaned Animal Rescue.");
        System.out.println("3. Endangered Species Rescue.");
        System.out.println("Enter rescue type: ");
        
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter Rescue Case ID: ");
        String rescueCaseId = scanner.nextLine();
        
        if(rescueCaseId.isBlank()){
            System.out.println("Rescue Case ID cannot be blank");
        return;}
        
        if(system.rescueCaseExists(rescueCaseId)){
            System.out.println("Rescue Case ID already exists.");
        return; 
        }
         System.out.print("Enter Animal Name: ");
         String animalName = scanner.nextLine();
         
         if(animalName.isBlank()){
             System.out.println("Animal name cannot be blank.");
         return;}
         
         System.out.println("Enter Species: ");
         String species = scanner.nextLine();
         
         if(species.isBlank()){
            System.out.println("Species cannot be blank.");
         return;}

         
         System.out.println("Enter Rescue Location");
         String rescueLocation = scanner.nextLine();
         
         if(rescueLocation.isBlank()){
            System.out.println("Rescue Location cannot be blank.");
         return;}
         
         System.out.println("Enter Assigned Ranger: ");
         String assignedRanger = scanner.nextLine();
         
         if(assignedRanger.isBlank()){
             System.out.println("Assigned Ranger cannot be blank.");
         return;}
         
         System.out.println("Enter number of Rescue Days; ");
         
         if(!scanner.hasNextInt()){
             System.out.println("Invalid input. Rescue days must be a number.");
            scanner.nextLine();
         return;}
         
         int numberOfRescueDays = scanner.nextInt();
         
         if (numberOfRescueDays <= 0) {
             System.out.println("Number of  rescue days must be greater than 0.");
            scanner.nextLine();
            return;}
           
         
         System.out.println("Enter Daily Care Cost: R");
         
         if(!scanner.hasNextDouble()){
             System.out.println("Invalid input. Daily care cost must be a number.");
            scanner.nextLine();
         return;
         }
         
         double dailyCareCost = scanner.nextDouble();
         scanner.nextLine();
         
         if(dailyCareCost <= 0 ){
             System.out.println("Daily care cost must be greater than 0.");
         return;}
         
         String currentRescueStatus = "Pending";
         
         switch(type){
    
        case 1:
        System.out.println("Enter Injury Description: ");
        String injuryDescription = scanner.nextLine();
    
        System.out.print("Enter Veterinary Treatment Cost: R");
        double veterinaryTreatmentCost = scanner.nextDouble();
    
        System.out.println("Is Surgery Required? (true/false): ");
        boolean surgeryRequired = scanner.nextBoolean();
        scanner.nextLine();
        
        InjuredAnimalRescue injuredRescue = new InjuredAnimalRescue(
            rescueCaseId,
            animalName,
            species,
            rescueLocation,
            assignedRanger,
            numberOfRescueDays,
            dailyCareCost,
            currentRescueStatus,
            injuryDescription,
            veterinaryTreatmentCost,
            surgeryRequired
        );
        
        if(system.addRescueCase(injuredRescue)){
            System.out.println("Injured Animal Rescue case created successfully.");
       }else{
            System.out.println("Unable to create rescue case.");
        }
        break;
    
        case 2: 
            System.out.println("Enter Estimated Age (Months): ");
            int estimatedAgeMonths = scanner.nextInt();
            
            System.out.println("Enter Feeding Cost: R");
            double feedingCost = scanner.nextDouble();
            
            System.out.println("Is Foster Care Required? (true/false): ");
            boolean fosterCareRequired = scanner.nextBoolean();
            scanner.nextLine();
            
            OrphanedAnimalRescue orphanedRescue = new OrphanedAnimalRescue(
                rescueCaseId,
                animalName,
                species,
                rescueLocation,
                assignedRanger,
                numberOfRescueDays,
                dailyCareCost,
                currentRescueStatus,
                estimatedAgeMonths,
                feedingCost,
                fosterCareRequired
            );
            if(system.addRescueCase(orphanedRescue)){
                System.out.println("Orphaned Animal Rescue case successfully.");
            }else{
                System.out.println("Unable to create rescue case.");
            }
            break;
            
        case 3 :
            System.out.println("Enter Conservation Classification: ");
            String conservationClassification = scanner.nextLine();
            
            System.out.println("Enter Security Cost: R");
            double securityCost = scanner.nextDouble();
            
            System.out.println("Is a Specialist Team Required ? (true/false):");
            boolean specialistTeamRequired = scanner.nextBoolean();
            scanner.nextLine();
            
            EndangeredSpeciesRescue endangeredRescue = new EndangeredSpeciesRescue(
                    rescueCaseId,
                    animalName,
                    species,
                    rescueLocation,
                    assignedRanger,
                    numberOfRescueDays,
                    dailyCareCost,
                    currentRescueStatus,
                    conservationClassification,
                    securityCost,
                    specialistTeamRequired
            );
            if(system.addRescueCase(endangeredRescue)){
                System.out.println("Endangered Species Rescue case created Successfully.");
            }else {
                    System.out.println("Unable ot create rescue case");
            }
            break;
            
        default: System.out.println("Invalid rescue type.");
        break;
            
    }
    
    
    
    
            

}
    public static void searchRescueCase(Scanner scanner, RescueSystem system){
    
        System.out.println("Enter Rescue Case ID to search: ");
        String rescueCaseId = scanner.nextLine();
    
        RescueCase rescueCase = system.searchRescueCase(rescueCaseId);
    
        if(rescueCase== null){
            System.out.println("Rescue case not found.");
        }else{
            System.out.println("\nRescue Case Found:");
            rescueCase.displayRescueDetails();
        }
    }
    public static void updateRescueStatus(Scanner scanner, RescueSystem system){
    
        System.out.println("Enter Rescue Case ID;");
        String rescueCaseId = scanner.nextLine();
    
        RescueCase rescueCase = system.searchRescueCase(rescueCaseId);
    
        if(rescueCase == null){
            System.out.println("Rescue case not Found.");
            return;
    }
        System.out.println("Current Status: "+ rescueCase.getCurrentRescueStatus());
        System.out.println("Enter New Status: ");
        String newStatus = scanner.nextLine();
        
        if(system.updateRescueStatus(rescueCaseId, newStatus)){
            System.out.println("Rescue status updated successfully.");
        }else{
            System.out.println("Unable to update rescue status.");}
    }
    
    
          
}
