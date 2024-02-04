package org.bastien.conf.cellstates;

import org.bastien.model.Cell;

import java.util.Collection;

public class EmptyCell extends Cell {

    @Override
    public void computeNextStateWithContext(Collection<Cell> context) {

    }

    @Override
    protected void applyNextStep() {

    }
}
