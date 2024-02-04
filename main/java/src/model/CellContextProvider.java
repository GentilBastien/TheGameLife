package model;

import java.util.Collection;
import java.util.Collections;

public class CellContextProvider {
    private final Cell[][] grid;

    public CellContextProvider(Cell[][] grid) {
        this.grid = grid;
    }

    public Collection<Cell> provide(Cell cell) {
        //TODO: abstract method
        return Collections.singleton(cell);
    }
}
