package org.bastien.model;

import org.bastien.conf.cellcontexts.DirectAdjacentCellContextProvider;
import org.bastien.conf.cellstates.EmptyCell;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.bastien.conf.Config.HEIGHT;
import static org.bastien.conf.Config.WIDTH;

public class Grid {
    private final Cell[][] grid;
    private final CellContextProvider cellContextProvider;

    public Grid() {
        grid = new Cell[HEIGHT][WIDTH];

        // SETUP CONFIG
        for (Cell[] cells : grid) {
            Arrays.fill(cells, new EmptyCell());
        }
        this.cellContextProvider = new DirectAdjacentCellContextProvider(grid);
    }

    private Stream<Cell> gridFlatten() {
        return Arrays.stream(this.grid)
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
}
