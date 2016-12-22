package com.company;

import java.util.Arrays;

public class Board {
    private CellState[][] squares;
    private boolean xTurn;

    public Board(boolean xFirst)
    {
        xTurn = xFirst;
        squares = new CellState[3][3];
        clearBoard();
    }

    public Board()
    {
        this(true);
    }

    public boolean makeTurn(int column, int row)
    {
        if(column < 0 || column > 2|| row < 0 || row > 2)
        {
            return false;
        }
        if(xTurn)
        {
            squares[column][row] = CellState.X;
        }
        else
        {
            squares[column][row] = CellState.O;
        }

        xTurn = !xTurn;

        return true;
    }

    final public void clearBoard()
    {
        for (CellState[] row : squares)
        {
            Arrays.fill(row, CellState.BLANK);
        }
    }

    public CellState getCell(int column, int row)
    {
        return squares[column][row];
    }

    public CellState getCell(int[] cell)
    {
        if(cell.length != 2)
        {
            throw new IllegalArgumentException("Cells must have rows and columns");
        }
        return getCell(cell[0], cell[1]);
    }

    public CellState verifyWinner()
    {
        CellState winner = null;
        for (int r = 0; winner == null && r < 3; r++)
        {
            if (lineMatches(squares[0][r], squares[1][r], squares[2][r])){
                winner = squares[0][r];
            }
        }
        if(winner == null && lineMatches(squares[0][0], squares[1][1], squares[2][2]))
        {
            winner = squares[0][0];
        }
        if(winner == null && lineMatches(squares[0][2], squares[1][1], squares[2][0]))
        {
            winner = squares[0][2];
        }
        return winner;
    }

    public static int[] intToCell(int cellNumber)
    {
        int cell[] = { cellNumber / 3, cellNumber % 3};
        return cell;
    }

    private static boolean lineMatches(CellState cell1, CellState cell2, CellState cell3)
    {
        return (cell1.matches(cell2) && cell2.matches(cell3));
    }
}

