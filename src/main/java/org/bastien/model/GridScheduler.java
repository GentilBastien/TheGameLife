package org.bastien.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GridScheduler {
    public static void main(String[] args) {
        Grid grid = new Grid();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
//        service.schedule(grid::update, 1000, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(grid::update, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
