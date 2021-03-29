import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    JTextArea textArea;
    JTextField textMassage;

    public Window() {
        setTitle("Чат");
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel(); //Верх
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());

        JPanel bottonPanel = new JPanel(); // Низ
        add(bottonPanel, BorderLayout.SOUTH);
        bottonPanel.setPreferredSize(new Dimension(1, 40));
        bottonPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Отправить");
        bottonPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textArea.setEditable(false);
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);

        textMassage = new JTextField();
        bottonPanel.add(textMassage, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!textMassage.getText().isEmpty()) {
                    addText();

                }
            }
        });

        textMassage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!textMassage.getText().isEmpty()) {
                    addText();
                }
            }
        });
        setVisible(true);

    }
    void addText() {
       textArea.append(textMassage.getText()+"\n");
       textMassage.setText(null);
       textMassage.grabFocus();
    }
}
