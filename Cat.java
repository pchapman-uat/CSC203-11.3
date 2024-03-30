// Import the color class for the color of the labels.
import java.awt.Color;
// Import the JLabel class for use in functions and variables   
import javax.swing.JLabel;

// This is the cat class that will be used to create the cat object
// Only one cat is made, however having it as a class makes things easier to manage
public class Cat {
    // Create variables for the stats of the cat
    public int hunger = 100;
    public int energy = 100;
    public int happiness = 100;

    // Create variables for the labels for the stats
    private JLabel hungerLabel;
    private JLabel energyLabel;
    private JLabel happinessLabel;

    // Create a constructor for the cat object
    // Pass in the labels for the stats
    public Cat(JLabel hunger, JLabel energy, JLabel happiness) {
        System.out.println("Creating a new cat");
        this.hungerLabel = hunger;
        this.energyLabel = energy;
        this.happinessLabel = happiness;
    }

    // Set the color of the label based on the value
    private void setColor(JLabel label, int value){
        if(value > 50){
            label.setForeground(Color.GREEN);
        }else if(value <= 50){
            label.setForeground(Color.YELLOW);
        } else{
            label.setForeground(Color.RED);
        }
    }

    // Cap the value between the max and min values
    private Integer capValue(int value, Integer max, Integer min){
        // If the max and min values are null, set them to 100 and 0 respectively
        max = max != null ? max : 100;
        min = min != null ? min : 0;
        // If the value is greater than the max, set it to the max value, otherwise if it is less than the min, set it to the min value
        if(value > max){
            value = max;
        } else if(value < min){
            value = min;
        }
        return value;
        
    }
    // Update the labels
    private void updateLables(){

        // Set the color of the labels based on the value
        this.setColor(energyLabel, energy);
        this.setColor(hungerLabel, hunger);
        this.setColor(happinessLabel, happiness);

        // Cap the values between the max and min values
        // Null is used to use the default values of 100, and 0
        this.energy = this.capValue(energy, null, null);
        this.hunger = this.capValue(hunger, null, null);
        this.happiness = this.capValue(happiness, null, null);

        // Set the text of the labels
        this.energyLabel.setText("Energy: " + this.energy);
        this.hungerLabel.setText("Hunger: " + this.hunger);
        this.happinessLabel.setText("Happiness: " + this.happiness);
    }
    // Feed the cat
    public void feed() {
        System.out.println("Feeding the cat");
        // Add 10 to the hunger and energy
        this.hunger += 10;
        this.energy += 10;
        // Update the labels
        this.updateLables();
    }
    // Play with the cat
    public void play(JLabel hunger) {
        System.out.println("Playing with the cat");
        // Subtract 5 from the hunger and 10 from the energy
        // Add 10 to the happiness
        this.hunger -= 5;
        this.energy -= 10;
        this.happiness += 10;
        // Update the labels
        this.updateLables();
    }

    // Reset the stats of the cat
    public void restart(){
        // Set all stat values to 100
        this.hunger = 100;
        this.energy = 100;
        this.happiness = 100;
        // Update the labels
        this.updateLables();
    }

    // Create a loop that will update the stats of the cat every second
    public void loop(){
        // Always run the loop
        while(true){
            // Sleep for 1 second
            // A try catch is used to catch any errors that may occur
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // After the wait has finished, subtract 1 from the hunger, energy, and happiness
            // A random number is generated to determine if the value is subtracted or not
            if(Math.random() > 0.5) this.hunger -= 1;
            if(Math.random() > 0.5) this.energy -= 1;
            if(Math.random() > 0.5) this.happiness -= 1;
            // Update the labels
            this.updateLables(); 
        }
    }
}
