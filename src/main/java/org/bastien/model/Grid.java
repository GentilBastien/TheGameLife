package org.bastien.model;

import java.util.Iterator;
import java.util.List;

public class Grid<T> implements Iterable<Grid.Cell<T>> {
    private final int size;
    private final List<T> values;
    private Cell<T> entry;

    public Grid(int width, int height, List<T> values) {
        size = width * height;
        this.values = values;
        buildGrid(width, height, values);
    }

    private void buildGrid(int width, int height, List<T> values) {
        Iterator<T> iterator = values.iterator();
        Cell<T> cursor = null, cursorLine = null;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                T value = iterator.next();
                Cell<T> cell = new Cell<>(value);
                if (i == 0 && j == 0) {
                    entry = cell;
                } else if (j == 0) {
                    addNewLine(cursorLine, cell);
                    cursorLine = cell;
                } else {
                    addToRight(cursor, cell);
                }
                cursor = cell;
            }
        }
    }

    private void addToRight(Cell<T> previous, Cell<T> cell) {
        previous.right = cell;
        cell.left = previous;
        if (previous.top != null) {
            final Cell<T> topRightCell = previous.top.right;
            if (topRightCell != null) {
                topRightCell.bottom = cell;
                cell.top = topRightCell;
            }
        }
    }

    private void addNewLine(Cell<T> top, Cell<T> cell) {
        if (top != null) {
            top.bottom = cell;
            cell.top = top;
        }
    }

    public Cell<T> getEntry() {
        return entry;
    }

    public List<T> getValues() {
        return values;
    }

    public Cell<T> find(T value) {
        for (Cell<T> cell : this) {
            if (cell.value == value) {
                return cell;
            }
        }
        return null;
    }

    @Override
    public Iterator<Cell<T>> iterator() {
        return new CellIterator();
    }

    public static class Cell<T> {
        private final T value;
        private Cell<T> top, bottom, left, right;

        public Cell(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public List<T> getDirectAdjacent() {
            return List.of(top.value, bottom.value, left.value, right.value);
        }

        public List<T> getAdjacent() {
            return List.of(top.value, bottom.value, left.value, right.value, top.left.value, top.right.value, bottom.left.value, bottom.right.value);
        }
    }

    class CellIterator implements Iterator<Cell<T>> {
        private Cell<T> cursor = entry, cursorLine = entry;

        @Override
        public boolean hasNext() {
            return cursor.right != null || cursorLine.bottom != null;
        }

        @Override
        public Cell<T> next() {
            if (cursor.right != null) {
                cursor = cursor.right;
            } else {
                cursor = cursorLine.bottom;
                cursorLine = cursor;
            }
            return cursor;
        }
    }
}
