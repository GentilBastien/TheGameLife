package org.bastien.conf.cellcontexts;

import org.bastien.conf.cellstates.State;
import org.bastien.model.Grid;

import java.util.Collection;
import java.util.Collections;

public class DirectAdjacentCellContextProvider<T extends State> extends AbstractCellContextProvider<T> {

    public DirectAdjacentCellContextProvider(Grid<T> grid) {
        super(grid);
    }

    @Override
    public Collection<T> provide(T state) {
        return Collections.singleton(state);
    }
}
