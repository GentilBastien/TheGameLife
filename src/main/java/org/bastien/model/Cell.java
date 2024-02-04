package org.bastien.model;

import java.util.Collection;

public abstract class Cell {
    
    public void computeNextState(ICellContextProvider cellContextProvider) {
        Collection<Cell> context = cellContextProvider.provide(this);
        computeNextStateWithContext(context);
    }

    protected abstract void computeNextStateWithContext(Collection<Cell> context);

    protected abstract void applyNextStep();
}
