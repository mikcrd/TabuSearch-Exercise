package gurobi.OptAlgs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final int TABU_TENURE = 3;
    public static final int MAX_ITERATIONS = 10;

    private static final int[] p = {6, 4, 8, 2, 10, 3};
    private static final int[] d = { 9, 12, 15, 8, 20, 22 };


    public static void main(String[] args)  {

        Solution instance = new Solution(p, d);

        // Identifying a feasible solution
        System.out.println("\nInitial feasible solution : ");
        FeasibleSolutionBuilder sort = new FeasibleSolutionWithDecreasingDuedate();
        sort.createSolution(instance);
        instance.printSolution();

        // Initializing the tabù list
        List<Move> tabulist = new ArrayList<Move>();

        // List that contains the best solutions found in each iteration
        List<Solution> list_best_solutions = new ArrayList<Solution>();

        for(int n_iters = 1; n_iters <= MAX_ITERATIONS; n_iters++) {
            // Since the dimension of the problem is small, I'm using the systematical search of all the neighborhood approach
            NeighborhoodSearchBuilder searchbest = new NeighborhoodSearchByBestImprovement();

            System.out.printf("\n\nITERATION N°: %d", n_iters);
            System.out.print("\nPrinting the neighborhood of solution ");
            instance.printSolution();

            List<Neighbor> neighbors = searchbest.generateNeighborhood(instance, tabulist);
            searchbest.printNeighborhood();

            System.out.println("\nThe best solution in the neighborhood is : ");
            searchbest.bestSolution(neighbors).getSolution().printSolution();

            instance = searchbest.bestSolution(neighbors).getSolution();

            // saving the best solution found in this iteration
            if(!(list_best_solutions.contains(instance))) {
                list_best_solutions.add(instance);
            }

            // Aspiration criteria:
            if(tabulist.size() == TABU_TENURE) {
                tabulist.removeFirst();
            }

            // Adding the move of the best solution found in this neighborhood in the tabù list:
            Move exclude = searchbest.bestSolution(neighbors).getMove();
            tabulist.add(exclude);
            System.out.println("Updating the tabù list: ");
            for(Move excluded_move : tabulist) {
                excluded_move.printMove();
            }

            System.out.println("\n-----------------------------------------------------------------");
        }

        System.out.println("\n\n");
        System.out.println("--------------------------------------------");
        System.out.printf("BEST SOLUTION OUT OF %d ITERATIONS", MAX_ITERATIONS);
        System.out.println();
        list_best_solutions.stream().sorted(Comparator.comparingInt(
                Solution::getObjectiveFunct)).toList().getFirst().printSolution();
        System.out.println("--------------------------------------------");

    }
}
