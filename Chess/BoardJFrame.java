package Chess;

import javax.swing.*;
import java.awt.*;

public class BoardJFrame extends JFrame {
    Component component;
    public BoardJFrame() {
        component = new Board();

        this.setTitle("Chess Game - BK");
        this.add(component, BorderLayout.CENTER);
        this.setLocation(200, 50);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BoardJFrame boardFrame = new BoardJFrame();
        boardFrame.setVisible(true);
    }
}
