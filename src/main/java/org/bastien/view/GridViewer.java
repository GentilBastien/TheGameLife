package org.bastien.view;

import org.bastien.conf.Config;
import org.bastien.conf.cellstates.State;
import org.bastien.model.GridCell;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class GridViewer<T extends State> extends JFrame {
    private final BufferedImage image;
    private final JLabel label;
    private final GridCell<T> gridCell;

    public GridViewer(GridCell<T> gridCell) {
        this.gridCell = gridCell;
        image = new BufferedImage(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);


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
        int widthChunk = image.getWidth() / Config.CELLS_WIDTH;
        int heightChunk = image.getHeight() / Config.CELLS_HEIGHT;

        Iterator<T> iterator = gridCell.getGrid().getValues().iterator();
        int startX = 0, startY = 0, index = 0;
        while (index < Config.CELLS_WIDTH * Config.CELLS_HEIGHT) {
            if (startX >= Config.SCREEN_WIDTH) {
                startX = 0;
                startY += heightChunk;
            }
            T state = iterator.next();
            drawChunk(image, state.color, startX, startY, widthChunk, heightChunk);
            startX += widthChunk;
            index = index + 1;
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
}
