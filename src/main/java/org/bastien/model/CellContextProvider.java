package org.bastien.model;

import org.bastien.conf.cellstates.State;

import java.util.Collection;

@FunctionalInterface
public interface CellContextProvider {

    Collection<? extends State> provide(State state);
}
