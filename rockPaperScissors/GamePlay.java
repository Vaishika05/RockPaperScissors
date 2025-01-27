package rockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private int scorePlayer = 0;
    private int scoreComp = 0;
    private Timer timer;
    private int delay = 1000;
    private String playerChoice = "";
    private String compChoice = "";
    private String resultMessage = "Press 'R', 'P', or 'S' to play!";
    private boolean play = false;

    private Image coverImage;
    private Image rockImage;
    private Image paperImage;
    private Image scissorsImage;

    Computer computer = new Computer();

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Load images (Ensure paths are correct and images are available)
        coverImage = new ImageIcon(
                "C:\\Users\\Vaishika Agrawal\\Desktop\\Java\\RockPaperScissors\\rockPaperScissors\\RPS2.png")
                .getImage();
        rockImage = new ImageIcon(
                "C:\\Users\\Vaishika Agrawal\\Desktop\\Java\\RockPaperScissors\\rockPaperScissors\\resources\\rock.jpg")
                .getImage();
        paperImage = new ImageIcon(
                "C:\\Users\\Vaishika Agrawal\\Desktop\\Java\\RockPaperScissors\\rockPaperScissors\\resources\\paper.jpeg")
                .getImage();
        scissorsImage = new ImageIcon(
                "C:\\Users\\Vaishika Agrawal\\Desktop\\Java\\RockPaperScissors\\rockPaperScissors\\resources\\Scissors.jpeg")
                .getImage();

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        // Background
        g.setColor(Color.PINK);
        g.fillRect(1, 1, 692, 592);

        if (!play) {
            // Draw cover image
            g.drawImage(coverImage, 0, 0, 692, 592, this);
        } else {
            // Scores
            g.setColor(Color.WHITE);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Player: " + scorePlayer, 30, 30);
            g.drawString("Computer: " + scoreComp, 520, 30);

            // Instructions
            g.setColor(Color.YELLOW);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press 'S' for Scissors", 70, 80);
            g.drawString("Press 'R' for Rock", 70, 110);
            g.drawString("Press 'P' for Paper", 70, 140);

            // Game Status
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Computer chose: " + compChoice, 70, 200);
            g.drawString(resultMessage, 70, 250);

            // Show player's choice image
            if (playerChoice.equals("Rock")) {
                g.drawImage(rockImage, 150, 300, 100, 100, this);
            } else if (playerChoice.equals("Paper")) {
                g.drawImage(paperImage, 150, 300, 100, 100, this);
            } else if (playerChoice.equals("Scissors")) {
                g.drawImage(scissorsImage, 150, 300, 100, 100, this);
            }

            // Show computer's choice image
            if (compChoice.equals("Rock")) {
                g.drawImage(rockImage, 400, 300, 100, 100, this);
            } else if (compChoice.equals("Paper")) {
                g.drawImage(paperImage, 400, 300, 100, 100, this);
            } else if (compChoice.equals("Scissors")) {
                g.drawImage(scissorsImage, 400, 300, 100, 100, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play && !playerChoice.isEmpty()) {
            // Computer's random choice
            compChoice = computer.selectRandomImage();

            // Compare choices and determine the result
            if (playerChoice.equals(compChoice)) {
                resultMessage = "It's a draw!";
            } else if ((playerChoice.equals("Rock") && compChoice.equals("Scissors")) ||
                    (playerChoice.equals("Paper") && compChoice.equals("Rock")) ||
                    (playerChoice.equals("Scissors") && compChoice.equals("Paper"))) {
                resultMessage = "You win!";
                scorePlayer++;
            } else {
                resultMessage = "You lose!";
                scoreComp++;
            }

        }
        repaint(); // Update the UI
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!play) {
            play = true; // Start the game on first key press
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerChoice = "Scissors";
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            playerChoice = "Rock";
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            playerChoice = "Paper";
        }
        repaint(); // Show immediate feedback
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
