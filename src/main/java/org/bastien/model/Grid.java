package org.bastien.model;

import org.bastien.conf.cellstates.BooleanState;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.bastien.conf.Config.CELLS_HEIGHT;
import static org.bastien.conf.Config.CELLS_WIDTH;

public class Grid {
    private final Cell<BooleanState>[][] cells;
    private CellContextProvider cellContextProvider;

    public Grid() {
        cells = new Cell[CELLS_HEIGHT][CELLS_WIDTH];

        // SETUP CONFIG
    }

    private Stream<Cell<BooleanState>> gridFlatten() {
        return Arrays.stream(this.cells).flatMap(Arrays::stream);
    }

    public void update() {
        long ms = System.currentTimeMillis();
        System.out.print("Frame update : [");

        refresh();

        ms = System.currentTimeMillis() - ms;
        System.out.println("] (" + ms + "ms).");
    }

    private void refresh() {
        gridFlatten().parallel().forEach(null);
//        a -> a.computeNextState(this.cellContextProvider.provide(a))
    }

    public Cell[][] getCells() {
        return cells;
    }
}
