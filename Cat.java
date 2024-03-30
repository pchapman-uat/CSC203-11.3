import java.awt.Color;
import javax.swing.JLabel;

public class Cat {
    public int hunger = 100;
    public int energy = 100;
    public int happiness = 100;

    private JLabel hungerLabel;
    private JLabel energyLabel;
    private JLabel happinessLabel;

    public Cat(JLabel hunger, JLabel energy, JLabel happiness) {
        System.out.println("Creating a new cat");
        this.hungerLabel = hunger;
        this.energyLabel = energy;
        this.happinessLabel = happiness;
    }

    private void setColor(JLabel label, int value){
        if(value > 50){
            label.setForeground(Color.GREEN);
        }else if(value <= 50){
            label.setForeground(Color.YELLOW);
        } else{
            label.setForeground(Color.RED);
        }
    }

    private Integer capValue(int value, Integer max, Integer min){
        max = max != null ? max : 100;
        min = min != null ? min : 0;
        if(value > max){
            value = max;
        } else if(value < min){
            value = min;
        }
        return value;
        
    }
    private void updateLables(){

        this.setColor(energyLabel, energy);
        this.setColor(hungerLabel, hunger);
        this.setColor(happinessLabel, happiness);

        this.energy = this.capValue(energy, null, null);
        this.hunger = this.capValue(hunger, null, null);
        this.happiness = this.capValue(happiness, null, null);

        this.energyLabel.setText("Energy: " + this.energy);
        this.hungerLabel.setText("Hunger: " + this.hunger);
        this.happinessLabel.setText("Happiness: " + this.happiness);
    }
    public void feed() {
        System.out.println("Feeding the cat");
        this.hunger += 10;
        this.energy += 10;
        this.updateLables();
    }
    public void play(JLabel hunger) {
        System.out.println("Playing with the cat");
        this.hunger -= 5;
        this.energy -= 5;
        this.happiness += 10;
        this.updateLables();
    }

    public void loop(){
        while(true){
            try {
                Thread.sleep(1000);

                if(Math.random() > 0.5) this.hunger -= 1;
                if(Math.random() > 0.5) this.energy -= 1;
                if(Math.random() > 0.5) this.happiness -= 1;
                this.updateLables();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
