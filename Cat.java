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
    private void updateLables(){
        this.energyLabel.setText("Energy: " + this.energy);
        this.hungerLabel.setText("Hunger: " + this.hunger);
        this.happinessLabel.setText("Happiness: " + this.happiness);
    }
    public void feed() {
        System.out.println("Feeding the cat");
        this.hunger = 100;
        updateLables();
    }
    public void play(JLabel hunger) {
        System.out.println("Playing with the cat");
        this.hunger -= 5;
        this.energy -= 5;
        this.happiness += 10;
        updateLables();
    }
}
