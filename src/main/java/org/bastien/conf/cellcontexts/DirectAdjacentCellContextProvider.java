package org.bastien.conf.cellcontexts;

import org.bastien.conf.cellstates.State;
import org.bastien.model.CellContextProvider;

import java.util.Collection;

public class DirectAdjacentCellContextProvider implements CellContextProvider {

    @Override
    public Collection<? extends State> provide(State state) {
        return null;
    }
}
