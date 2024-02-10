package org.bastien.conf.cellstates;

import java.awt.*;
import java.util.Collection;

public class BooleanState extends State {

    private boolean life;

    public BooleanState() {
        this.life = false;
    }

    @Override
    protected void computeNextStepWithContext(Collection<? extends State> context) {
        Collection<BooleanState> cast = mapToType(BooleanState.class, context);
        compute(cast);
    }

    private void compute(Collection<BooleanState> context) {
        // TODO
        this.life = Math.random() < 0.2;
        this.color = this.life ? Color.BLACK : Color.WHITE;
    }
}
