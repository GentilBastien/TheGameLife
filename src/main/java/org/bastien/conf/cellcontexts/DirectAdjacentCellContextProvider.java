package org.bastien.conf.cellcontexts;

import org.bastien.model.Cell;
import org.bastien.model.CellContextProvider;

import java.util.Collection;
import java.util.Collections;

public class DirectAdjacentCellContextProvider extends CellContextProvider {

    public DirectAdjacentCellContextProvider(Cell[][] grid) {
        super(grid);
    }

    @Override
    public Collection<Cell> provide(Cell cell) {
        //TODO
        return Collections.singleton(cell);
    }
}
