package Catan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class CatanBoard extends JFrame{

    // window dimensions
    private int frameWidth = 800, frameHeight = 800;

    // tile images
    private ImageIcon brick = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Brick.png");
    private ImageIcon sheep = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Sheep.png");
    private ImageIcon desert = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Desert.png");
    private ImageIcon wheat = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Wheat.png");
    private ImageIcon wood = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Wood.png");
    private ImageIcon ore = new ImageIcon("/Users/bikramkohli/IdeaProjects/GameProjects/src/Catan/Ore.png");

    // generating pseudo-random order of tiles
    // two same tiles will never be left/right of each other
    public static ArrayList<String> randArray() {
        ArrayList<String> randTiles = new ArrayList();
        for(int i = 0; i < 19; i++) {
            String tile;
            if (i < 4) tile = "Wood";
            else if (i < 8) tile = "Sheep";
            else if (i < 12) tile = "Wheat";
            else if (i < 15) tile = "Brick";
            else if (i < 18) tile = "Ore";
            else tile = "Desert";
            randTiles.add(tile);
        }

        Collections.shuffle(randTiles);

        boolean checker = false;
        boolean a = false;
        while (!checker) {
            for (int j = 0; j < randTiles.size() - 1; j++) {
                if (randTiles.get(j) == randTiles.get(j + 1)) {
                    Collections.shuffle(randTiles);
                    break;
                }
                if (j == 17) a = true;
            }
            if (a == true) checker = true;
            else checker = false;
        }
        return randTiles;
    }

    // constructor setting up window
    public CatanBoard() {
        setBounds(300, 100, frameWidth, frameHeight);
        setVisible(true);
    }

    // displaying all tiles
    public void paint(Graphics g) {
        ArrayList<String> randomOrder = randArray();
        int row = 1;
        int y = 175;
        int count = 0;
        for(int i = 0; i < randomOrder.size(); i++) {
            count++;
            ImageIcon tile;
            if (randomOrder.get(i) == "Sheep") tile = sheep;
            else if (randomOrder.get(i) == "Wheat") tile = wheat;
            else if (randomOrder.get(i) == "Brick") tile = brick;
            else if (randomOrder.get(i) == "Ore") tile = ore;
            else if (randomOrder.get(i) == "Wood") tile = wood;
            else tile = desert;

            if (row == 1) {
                int x = 146 + 100 * count;
                g.drawImage(tile.getImage(), x, y, null);
                if (count == 3) {
                    row++;
                    y += 85;
                }
            }

            else if (row == 2) {
                int x = 96 + 100 * (count - 3);
                g.drawImage(tile.getImage(), x, y, null);
                if (count == 7) {
                    row++;
                    y += 85;
                }
            }

            else if (row == 3) {
                int x = 46 + 100 * (count - 7);
                g.drawImage(tile.getImage(), x, y, null);
                if (count == 12) {
                    row++;
                    y += 85;
                }
            }

            else if (row == 4) {
                int x = 96 + 100 * (count - 12);
                g.drawImage(tile.getImage(), x, y, null);
                if (count == 16) {
                    row++;
                    y+= 85;
                }
            }

            else {
                int x = 146 + 100 * (count - 16);
                g.drawImage(tile.getImage(), x, y, null);
            }
        }
    }

    public static void main(String[] args) {
        new CatanBoard();

    }
}