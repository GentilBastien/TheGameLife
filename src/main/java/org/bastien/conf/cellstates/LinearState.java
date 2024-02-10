package org.bastien.conf.cellstates;

import java.util.Collection;

public class LinearState extends State {

    private double life;

    public LinearState() {
        this.life = 0.0d;
    }

    @Override
    protected void computeNextStepWithContext(Collection<? extends State> context) {
        Collection<LinearState> cast = mapToType(LinearState.class, context);
        compute(cast);
    }

    private void compute(Collection<LinearState> context) {
        // TODO
        this.life = 0.0d;
    }
}
