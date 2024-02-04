package org.bastien.view;

import org.bastien.conf.Config;
import org.bastien.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GridViewer extends JFrame {
    private final JLabel label;
    private Cell[][] cellsModel;

    public GridViewer() {
        setTitle("Pixel Scene Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Config.SCREEN_WIDTH + 15, Config.SCREEN_HEIGHT + 38);

        label = new JLabel();
        getContentPane().add(label);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void refreshBufferedImage() {
        BufferedImage image = new BufferedImage(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        int widthChunk = image.getWidth() / Config.CELLS_WIDTH;
        int heightChunk = image.getHeight() / Config.CELLS_HEIGHT;
        for (int i = 0; i < Config.CELLS_HEIGHT; i++) {
            for (int j = 0; j < Config.CELLS_WIDTH; j++) {
                drawChunk(image, this.cellsModel[i][j].getColor(), i * widthChunk, j * heightChunk, widthChunk, heightChunk);
            }
        }
        label.setIcon(new ImageIcon(image));
    }

    private void drawChunk(BufferedImage image, Color color, int x, int y, int width, int height) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                image.setRGB(i, j, color.getRGB());
            }
        }
    }

    public void setGrid(Cell[][] cells) {
        this.cellsModel = cells;
    }
}
