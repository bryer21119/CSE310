import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//create a class that extends JFrame and implements ActionListener
public class FlashCardApp<string> extends JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JLabel frontLabel;
    private JLabel backLabel;
    private JButton flipButton;
    private String[] questions = {"What is the capital of France?", "What is the tallest mountain on Earth?"};
    private String[] answers = {"Paris", "Mount Everest"};
    private int currentIndex = 0;
//create a constructor that sets the title of the JFrame
    public FlashCardApp() {
        setTitle("Flash Card App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
//create a panel that will hold the cards
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
//create a label that will display the question
        frontLabel = new JLabel(questions[currentIndex]);
        frontLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frontLabel.setVerticalAlignment(SwingConstants.CENTER);
        frontLabel.setOpaque(true);
        frontLabel.setBackground(Color.WHITE);
        frontLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//create a label that will display the correct answer

        backLabel = new JLabel(answers[currentIndex]);
        backLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backLabel.setVerticalAlignment(SwingConstants.CENTER);
        backLabel.setOpaque(true);
        backLabel.setBackground(Color.WHITE);
        backLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//create a button that will flip the card
        flipButton = new JButton("Flip");
        flipButton.setFont(new Font("Arial", Font.PLAIN, 20));
        flipButton.setFocusable(true);
//create a button that will flip the card
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });
//create a panel that will hold the cards
        cardPanel.add(frontLabel, "front");
        cardPanel.add(backLabel, "back");
        
//create a panel that will hold the cards
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(cardPanel, BorderLayout.CENTER);
        panel.add(flipButton, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
//create a method that allows the user to flip the card
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @SuppressWarnings("rawtypes")
            @Override
            public void run() {
                new FlashCardApp();
            }
        });
    }
}
