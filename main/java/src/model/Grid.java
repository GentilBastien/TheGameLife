package model;

import java.util.Arrays;

import static conf.Config.HEIGHT;
import static conf.Config.WIDTH;

public class Grid {
    private final Cell[][] grid;
    private final CellContextProvider cellContextProvider;

    public Grid() {
        this.grid = new Cell[HEIGHT][WIDTH];
        for (Cell[] cells : this.grid) {
            Arrays.fill(cells, new Cell());
        }
        this.cellContextProvider = new CellContextProvider(grid);
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.update();
    }

    public void update() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                this.grid[i][j].update(this.cellContextProvider::provide);
            }
        }
    }
}
