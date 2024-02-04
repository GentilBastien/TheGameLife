package model;

import java.util.Collection;

@FunctionalInterface
public interface ICellContextProvider {
    Collection<Cell> provide(Cell aCell);
}
