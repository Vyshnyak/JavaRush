package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;
    int score = 0;
    int maxTile = 2;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles[0].length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value ||
                    gameTiles[i][j].value == gameTiles[i + 1][j].value ||
                    gameTiles[i][j + 1].value == gameTiles[i + 1][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            Tile randomEmptyTile = emptyTiles.get((int) (Math.random() * emptyTiles.size()));
            randomEmptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            int ind = i;
            while (ind > 0 && tiles[ind - 1].isEmpty() && !tiles[ind].isEmpty()) {
                tiles[ind - 1].value = tiles[ind].value;
                tiles[ind].value = 0;
                isChanged = true;
                ind--;
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            Tile prevTile = tiles[i - 1];
            Tile currentTile = tiles[i];
            if (!prevTile.isEmpty() && prevTile.value == currentTile.value) {
                prevTile.value += currentTile.value;
                currentTile.value = 0;
                isChanged = true;
                score += prevTile.value;
                if (prevTile.value > maxTile) {
                    maxTile = prevTile.value;
                }
            }
        }
        if (isChanged) {
            compressTiles(tiles);
        }
        return isChanged;
    }

    public boolean hasBoardChanged() {
        Tile[][] previousState = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].value != previousState[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    private void saveState(Tile[][] tiles) {
        previousStates.push(getDeepCopy(gameTiles));
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private Tile[][] getDeepCopy(Tile[][] tiles) {
        Tile[][] copy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                copy[i][j] = new Tile(tiles[i][j].value);
            }
        }
        return copy;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (Tile[] row : gameTiles) {
            if (compressTiles(row) | mergeTiles(row)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.poll().getMove().move();
    }

    public void randomMove() {
        int move = ((int) (Math.random() * 100)) % 4;
        switch (move) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    private void rotate() {
        Tile[][] tmpGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tmpGameTiles.length; i++) {
            for (int j = 0; j < tmpGameTiles.length; j++) {
                tmpGameTiles[i][j] = gameTiles[gameTiles.length - 1 - j][i];
            }
        }
        gameTiles = tmpGameTiles;
    }
}
