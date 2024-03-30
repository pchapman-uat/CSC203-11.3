// Import the java color class for the color of the labels.
import java.awt.Color;
// Import the flow layout class for the layout of the labels.
import java.awt.FlowLayout;
// Import the image class for the image of the cat.
import java.awt.Image;
// Import swing for the UI
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Declare the variables for the frame size
        int frameWidth = 250;
        int frameHeight = 400;
        // Create a new frame (window)
        JFrame frame = new JFrame();
        // Set the frame size and close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        // Make the frame visible
        frame.setVisible(true);
        // Create lables for the title and subtitle
        JLabel title = new JLabel("Pet Simulator");
        JLabel subtitle = new JLabel("CSC203 11.3 | UAT");
        
        // Create a panel for the header
        // This is like a div in html
        JPanel header = new JPanel();
        // Set the size of the panel
        header.setSize(frameWidth, 50);
        // Add the title and subtitle to the panel
        header.add(title);
        header.add(subtitle);
        // Add the panel to the frame
        frame.add(header);
        // Set the layout of the frame
        // Flow allows for an adaptive layout
        // This is like flex in css
        frame.setLayout(new FlowLayout());

        // Create a panel for the name
        JPanel name = new JPanel();
        // Set the size of the panel
        name.setSize(frameWidth, 50);
        // Set the background color of the panel
        name.setBackground(Color.GRAY);
        // Set the layout of the panel
        name.setLayout(new FlowLayout());
        // Create a text input area
        JTextArea textArea = new JTextArea();
        // Set the size of the text area
        textArea.setSize(frameWidth, 50);
        // Set the default text
        textArea.setText("Enter the cat's name");
        // Add the name to the frame
        name.add(textArea);

        // Add the name panel to the frame
        frame.add(name);

        // Create a label for the cat image
        JLabel cat = new JLabel();
        // Create an image icon from the file
        ImageIcon catIcon = new ImageIcon("assets/cat.jpg");
        // Get the image data from the icon
        Image catImage = catIcon.getImage();
        // Scale the image to the size of the label
        Image newCatImage = catImage.getScaledInstance(200, 200, Image.SCALE_REPLICATE);
        // Set the icon to the resied image
        cat.setIcon(new ImageIcon(newCatImage));   
        // Add the image to the frame
        frame.add(cat);

  
        // Create a panel for the stats
        JPanel stats = new JPanel();
        // Create stats labels
        JLabel hunger = new JLabel("Hunger: " + 100);
        JLabel energy = new JLabel("Energy: " + 100);
        JLabel happiness = new JLabel("Happiness" + 100);
        // Set the background color of the panel
        stats.setBackground(Color.GRAY);
        // Create a new cat object
        // Pass in the labels for the stats
        // This will be used to update the stats visualy
        Cat catObj = new Cat(hunger, energy, happiness);
        // Add the labels to the stats pannel
        stats.add(hunger);
        stats.add(energy);
        stats.add(happiness);
        // Set the size of the stats panel
        stats.setSize(frameWidth, 100);
        // Set the layout of the stats panel
        stats.setLayout(new FlowLayout());
        frame.add(stats);

        // Create buttons for Feeding, Playing, and Reseting
        // Add action listener will runt the function when the button is clicked
        JButton feedButton = new JButton("Feed");
        feedButton.addActionListener(e -> catObj.feed());
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> catObj.play(hunger));
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> catObj.restart());

        // Add the buttons to the frame
        frame.add(playButton);
        frame.add(feedButton);
        frame.add(restartButton);
        // Run the looping function for the cat
        catObj.loop();
    }
}
