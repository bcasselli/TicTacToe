package com.company;

import java.util.ArrayList;

public abstract class AI {

    public abstract int[] getMove(Board board, int turns);

    protected static ArrayList<Integer> getEmptyCells(Board board)
    {
        ArrayList<Integer> emptyCells = new ArrayList<>(9);

        for(int i = 0; i < 9; i++)
        {
            if(board.getCell(i / 3, i % 3) == CellState.BLANK)
            {
                emptyCells.add(i);
            }
        }
        return emptyCells;
    }

    protected static int[] predictWin(Board board)
    {
        int[] winner;
        int[] cells = new int[3];
        int xWin = -1, oWin = -1;

        for(int c = 0; (xWin == -1 || oWin == -1) && c < 3; c++)
        {
            for(int r = 0; r < 3; r++)
            {
                cells[r] = c * 3 + r;
            }
        }

        winner = winsNextTurn(board, cells[0], cells[1], cells[2]);
        if(winner != null)
        {
            if (winner[0] == CellState.X.ordinal())
            {
                xWin = winner[1];
            }
            else if(winner[0] == CellState.O.ordinal())
            {
                oWin = winner[1];
            }
        }
    }
}
