package org.bastien.model;

import java.util.Collection;

public abstract class CellContextProvider {
    protected final Cell[][] grid;

    public CellContextProvider(Cell[][] grid) {
        this.grid = grid;
    }

    public abstract Collection<Cell> provide(Cell cell);
}
