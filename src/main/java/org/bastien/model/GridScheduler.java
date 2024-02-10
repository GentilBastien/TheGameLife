package org.bastien.model;

import org.bastien.conf.cellstates.BooleanState;
import org.bastien.view.GridViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GridScheduler {
    public static void main(String[] args) {
        GridCell<BooleanState> grid = new GridCell<>(BooleanState.class);
        GridViewer<BooleanState> viewer = new GridViewer<>(grid);

//        grid.update();
//        viewer.refreshBufferedImage();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            grid.update();
            viewer.refreshBufferedImage();
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
