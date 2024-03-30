import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        JLabel label = new JLabel("Pet Simulator");
        JLabel label3 = new JLabel("CSC203 11.3 | UAT");
        
        frame.add(label);
        frame.add(label3);
        frame.setLayout(new FlowLayout());

        JLabel cat = new JLabel();
        ImageIcon catIcon = new ImageIcon("assets/cat.jpg");
        Image catImage = catIcon.getImage();
        Image newCatImage = catImage.getScaledInstance(200, 200, Image.SCALE_REPLICATE);
        cat.setIcon(new ImageIcon(newCatImage));   
        frame.add(cat);

  
       
        JLabel hunger = new JLabel("Hunger: " + 100);
        JLabel energy = new JLabel("Energy: " + 100);
        JLabel happiness = new JLabel("Happiness" + 100);
        Cat catObj = new Cat(hunger, energy, happiness);
        frame.add(hunger);
        frame.add(energy);
        frame.add(happiness);
        JButton feedButton = new JButton("Feed");
        feedButton.addActionListener(e -> catObj.feed());
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> catObj.play(hunger));
        frame.add(playButton);
        frame.add(feedButton);
    }
}
