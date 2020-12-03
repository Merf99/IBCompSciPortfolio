package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    private JButton[] buttons = new JButton[9];
    private boolean pushed = true;

    
    public Game() {
        this.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(new Game.ButtonListener());
            this.add(buttons[i]);
        }
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            buttonClicked.setEnabled(false);


            if(pushed) {
                buttonClicked.setText("X");
                buttonClicked.setBackground(Color.cyan);
                pushed = false;
            }
            else {
                buttonClicked.setText("O");
                buttonClicked.setBackground(Color.pink);
                pushed = true;
            }
        }
    }

}
 