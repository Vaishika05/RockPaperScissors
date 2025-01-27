
package rockPaperScissors;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game initializing...");

        // Creating JFrame object
        JFrame obj = new JFrame();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Rock Paper Scissors");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding GamePlay panel
        GamePlay gamePlay = new GamePlay();
        obj.add(gamePlay);

        // Setting visibility
        obj.setVisible(true);
        System.out.println("Game window displayed...");
    }
}
