package org.bastien.model;

import org.bastien.view.GridViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GridScheduler {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridViewer viewer = new GridViewer();
        viewer.setGrid(grid.getCells());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            grid.update();
            viewer.refreshBufferedImage();
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
