package org.bastien.model;

import org.bastien.conf.cellstates.State;

import java.util.function.Supplier;

@FunctionalInterface
public interface StateProvider<T extends State> extends Supplier<T> {
}
