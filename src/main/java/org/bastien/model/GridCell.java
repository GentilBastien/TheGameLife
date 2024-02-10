package org.bastien.model;

import org.bastien.conf.Config;
import org.bastien.conf.cellcontexts.DirectAdjacentCellContextProvider;
import org.bastien.conf.cellstates.State;

import java.util.ArrayList;
import java.util.List;

public class GridCell<T extends State> {
    private final Grid<T> grid;
    private final CellContextProvider<T> cellContextProvider;

    public GridCell(Class<T> clazz) {
        grid = new Grid<T>(Config.CELLS_WIDTH, Config.CELLS_HEIGHT, buildInitialGrid(() -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception ignored) {
                return null;
            }
        }));
        cellContextProvider = new DirectAdjacentCellContextProvider<>(grid);
    }

    public void update() {
        long ms = System.currentTimeMillis();
        refresh();
        ms = System.currentTimeMillis() - ms;
        System.out.println("Frame update (" + ms + "ms).");
    }

    private void refresh() {
        List<? extends State> list = grid.getValues();
        list.stream().parallel().forEach(state -> state.applyNextState(cellContextProvider));
    }

    private List<T> buildInitialGrid(StateProvider<T> stateProvider) {
        List<T> list = new ArrayList<>(Config.CELLS_WIDTH * Config.CELLS_HEIGHT);
        for (int i = 0; i < Config.CELLS_WIDTH * Config.CELLS_HEIGHT; i++) {
            list.add(stateProvider.get());
        }
        return list;
    }

    public Grid<T> getGrid() {
        return grid;
    }
}
