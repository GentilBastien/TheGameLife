package org.bastien.conf.cellstates;

import org.bastien.model.CellContextProvider;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class State {

    public void applyNextState(CellContextProvider contextProvider) {
        Collection<? extends State> context = contextProvider.provide(this);
        computeNextStepWithContext(context);
    }

    protected <T extends State> Collection<T> mapToType(Class<T> clazz, Collection<? extends State> context) {
        return context.stream().map(clazz::cast).collect(Collectors.toList());
    }

    protected abstract void computeNextStepWithContext(Collection<? extends State> context);
}
