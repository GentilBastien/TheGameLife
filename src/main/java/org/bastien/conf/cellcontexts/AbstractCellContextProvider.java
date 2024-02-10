package org.bastien.conf.cellcontexts;

import org.bastien.conf.cellstates.State;
import org.bastien.model.CellContextProvider;
import org.bastien.model.Grid;

public abstract class AbstractCellContextProvider<T extends State> implements CellContextProvider<T> {

    protected Grid<T> grid;

    public AbstractCellContextProvider(Grid<T> grid) {
        this.grid = grid;
    }
}
