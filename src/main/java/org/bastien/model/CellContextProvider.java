package org.bastien.model;

import org.bastien.conf.cellstates.State;

import java.util.Collection;

@FunctionalInterface
public interface CellContextProvider<T extends State> {

    Collection<T> provide(T state);
}
