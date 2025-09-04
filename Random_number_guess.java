package Random_number_Guess_Game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Random_number_guess {
    JFrame frame;
    int targetNumber;

    public Random_number_guess() {
        frame = new JFrame("Number Guessing Game");
        frame.setSize(450, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        // 🎨 Styling
        Color bgColor = new Color(230, 240, 255); // Light pastel blue
        Color fontColor = new Color(30, 30, 60);  // Deep navy
        Color buttonColor = new Color(70, 130, 180); // Steel blue
        Color resetColor = new Color(100, 149, 237); // Cornflower blue
        Color exitColor = new Color(220, 20, 60);    // Crimson

        Font font = new Font("Segoe UI", Font.BOLD, 18);

        frame.getContentPane().setBackground(bgColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 60, 20, 60);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // 🔤 Instruction Label
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        instructionLabel.setFont(font);
        instructionLabel.setForeground(fontColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(instructionLabel, gbc);

        // 🔢 Input Field
        JTextField guessField = new JTextField();
        guessField.setFont(font);
        guessField.setForeground(fontColor);
        guessField.setBackground(Color.WHITE);
        guessField.setPreferredSize(new Dimension(300, 60));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(guessField, gbc);

        // ✅ Submit Button
        JButton guessButton = new JButton("Submit Guess");
        guessButton.setFont(font);
        guessButton.setForeground(Color.WHITE);
        guessButton.setBackground(buttonColor);
        guessButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        frame.add(guessButton, gbc);

        // 🔁 Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(font);
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(resetColor);
        resetButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(resetButton, gbc);

        // 💬 Feedback Label
        JLabel feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(font);
        feedbackLabel.setForeground(fontColor);
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(feedbackLabel, gbc);

        // ❌ Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(font);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(exitColor);
        exitButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(exitButton, gbc);

        // 🎲 Generate Random Number
        Random rand = new Random();
        targetNumber = rand.nextInt(100) + 1;

        // 🎯 Guess Logic
        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(guessField.getText());
                if (guess < 1 || guess > 100) {
                    feedbackLabel.setText("Please enter a number between 1 and 100.");
                } else if (guess < targetNumber) {
                    feedbackLabel.setText("Too low! Try again.");
                } else if (guess > targetNumber) {
                    feedbackLabel.setText("Too high! Try again.");
                } else {
                    feedbackLabel.setText("🎉 Correct! You guessed the number.");
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Invalid input. Please enter a number.");
            }
        });

        // 🔄 Reset Logic
        resetButton.addActionListener(e -> {
            guessField.setText("");
            feedbackLabel.setText(" ");
            targetNumber = rand.nextInt(100) + 1;
        });

        // ❌ Exit Logic
        exitButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Random_number_guess();
    }
}
