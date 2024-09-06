package gurobi.OptAlgs;

import java.util.Collections;
import java.util.Objects;


public class Move {

    private int a;
    private int b;

    public Move(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getFirstElement() {
        return a;
    }

    public void setFirstElement(int a) {
        this.a = a;
    }

    public int getSecondElement() {
        return b;
    }

    public void setSecondElement(int b) {
        this.b = b;
    }

    /* Swaps the job at index a with the job at index b, and the reverse
    * */
    public Solution applyMove(Solution sol)  {
        // because I don't want to overwrite the solution in the parameters I'm using the constructor with the clone() method
        Solution newsol = new Solution(sol.getSolution());
        Collections.swap(newsol.getSolution(), a, b);
        return newsol;
    }

    public Move reversedMove() {
        return new Move(getSecondElement(), getFirstElement());
    }

    public void printMove() {
        System.out.printf("Move : (%d, %d)   ", getFirstElement()+1, getSecondElement()+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        if(b == move.a && a == move.b) return true; // move(a,b) è uguale a move(b,a)
        return a == move.a && b == move.b;

    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
