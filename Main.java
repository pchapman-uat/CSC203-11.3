import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int frameWidth = 250;
        int frameHeight = 400;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        frame.setBackground(Color.DARK_GRAY);
        JLabel title = new JLabel("Pet Simulator");
        JLabel subtitle = new JLabel("CSC203 11.3 | UAT");
        

        JPanel header = new JPanel();
        header.setSize(frameWidth, 50);
        header.add(title);
        header.add(subtitle);
        header.setVisible(true);
        frame.add(header);
        frame.setLayout(new FlowLayout());


        JPanel name = new JPanel();
        name.setSize(frameWidth, 50);
        name.setBackground(Color.GRAY);
        name.setLayout(new FlowLayout());
        JTextArea textArea = new JTextArea();
        textArea.setSize(frameWidth, 50);
        textArea.setText("Enter the cat's name");
        name.add(textArea);

        frame.add(name);
        JLabel cat = new JLabel();
        ImageIcon catIcon = new ImageIcon("assets/cat.jpg");
        Image catImage = catIcon.getImage();
        Image newCatImage = catImage.getScaledInstance(200, 200, Image.SCALE_REPLICATE);
        cat.setIcon(new ImageIcon(newCatImage));   
        frame.add(cat);

  
        JPanel stats = new JPanel();
        JLabel hunger = new JLabel("Hunger: " + 100);
        JLabel energy = new JLabel("Energy: " + 100);
        JLabel happiness = new JLabel("Happiness" + 100);
        stats.setBackground(Color.GRAY);
        Cat catObj = new Cat(hunger, energy, happiness);
        stats.add(hunger);
        stats.add(energy);
        stats.add(happiness);
        stats.setSize(frameWidth, 100);
        stats.setLayout(new FlowLayout());
        frame.add(stats);
        JButton feedButton = new JButton("Feed");
        feedButton.addActionListener(e -> catObj.feed());
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> catObj.play(hunger));
        frame.add(playButton);
        frame.add(feedButton);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> catObj.restart());
        frame.add(restartButton);
        catObj.loop();
    }
}
