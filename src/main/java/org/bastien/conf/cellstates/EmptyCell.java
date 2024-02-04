package org.bastien.conf.cellstates;

import org.bastien.model.Cell;

import java.awt.*;
import java.util.Collection;

public class EmptyCell extends Cell {

    @Override
    public void computeNextStateWithContext(Collection<Cell> context) {

    }

    @Override
    protected void applyNextStep() {
        this.color = Math.random() < 0.3 ? Color.GREEN : Math.random() < 0.5 ? Color.RED : Color.BLUE;
    }
}
