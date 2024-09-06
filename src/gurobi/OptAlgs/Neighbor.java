package gurobi.OptAlgs;

import java.util.Objects;

public class Neighbor {

    private Move move;
    private Solution solution;

    /* After applying a move, we want to memorize the new solution found and the move that we used to reach the solution
    * */
    public Neighbor(Move move, Solution solution) {
        this.move = move;
        this.solution = solution;
    }

    public Move getMove() {
        return move;
    }

    public Solution getSolution() {
        return solution;
    }

    public void printNeighbor() {
        move.printMove();
        System.out.print("  |  ");
        solution.printSolution();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbor neighbor = (Neighbor) o;
        return Objects.equals(move, neighbor.move) && Objects.equals(solution, neighbor.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(move, solution);
    }
}
