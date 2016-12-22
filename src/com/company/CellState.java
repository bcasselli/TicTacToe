package com.company;

enum CellState {
    BLANK, X, O;

    @Override

    public String toString()
    {
        if (this.name().equals("BLANK"))
        {
            return " ";
        }
        else
            return this.name();
    }

    public boolean matches(CellState state2)
    {
        return this == state2 && state2 != BLANK;
    }
}
