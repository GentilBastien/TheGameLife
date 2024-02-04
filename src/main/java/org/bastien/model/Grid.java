package org.bastien.model;

import org.bastien.conf.cellcontexts.DirectAdjacentCellContextProvider;
import org.bastien.conf.cellstates.EmptyCell;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.bastien.conf.Config.CELLS_HEIGHT;
import static org.bastien.conf.Config.CELLS_WIDTH;

public class Grid {
    private final Cell[][] cells;
    private final CellContextProvider cellContextProvider;

    public Grid() {
        cells = new Cell[CELLS_HEIGHT][CELLS_WIDTH];

        // SETUP CONFIG
        for (int i = 0; i < CELLS_HEIGHT; i++) {
            for (int j = 0; j < CELLS_WIDTH; j++) {
                cells[i][j] = new EmptyCell();
            }
        }
        this.cellContextProvider = new DirectAdjacentCellContextProvider(cells);
    }

    private Stream<Cell> gridFlatten() {
        return Arrays.stream(this.cells)
                .flatMap(Arrays::stream);
    }

    public void update() {
        long ms = System.currentTimeMillis();
        System.out.print("Frame update : [");

        refresh();

        ms = System.currentTimeMillis() - ms;
        System.out.println("(" + ms + "ms).");
    }

    private void refresh() {
        System.out.print("computing -> ");
        gridFlatten().parallel().forEach(this.cellContextProvider::provide);
        System.out.print("computed -> ");
        gridFlatten().parallel().forEach(Cell::applyNextStep);
        System.out.print("updated] ");
    }

    public Cell[][] getCells() {
        return cells;
    }
}
