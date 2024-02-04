package model;

import java.util.Collection;

public class Cell {

    public Cell() {
    }

    public void update(ICellContextProvider cellContextProvider) {
        Collection<Cell> context = cellContextProvider.provide(this);
    }
}
