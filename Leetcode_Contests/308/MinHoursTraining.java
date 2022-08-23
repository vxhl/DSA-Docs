class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // In case we have all the experience required, our energy has to be atleast greater than the enrgies of everyone combined
        // only then can we consecutively beat all of them
        // So let' first calculate the total energy
        int totalHours = 0;
        int totalEnergy = 0;
        for(int i: energy){
            totalEnergy+=i;
        }
        // If our energy minus the total energy is greater than 1 we don't need any additional energy, otherwise we need the difference
        totalHours += (initialEnergy-totalEnergy)>=1? 0: (totalEnergy-initialEnergy+1);
        
        // Now we set and reset for our experience values
        for(int i: experience){
            // If our experience is the same or grater
            if(i>=initialExperience){
                // It means we need that amount of experience in additiona so train the difference +1 to surpass them
                totalHours+=(i-initialExperience+1);
                // And set the initiaExperience as the current value+1
                initialExperience = i+1;
            }
            // Finally add the current experience to the initial
            initialExperience+=i;
            
        }
        return totalHours;
        
    }
}