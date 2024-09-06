package gurobi.OptAlgs;

import java.util.Comparator;

public class FeasibleSolutionWithDecreasingDuedate implements FeasibleSolutionBuilder{

    /* First do the jobs which are due earlier
    *  This method sorts the jobs in not decreasing order of due date
    * */
    @Override
    public void createSolution(Solution sol) {
        sol.getSolution().sort(Comparator.comparing(Job::getDueDate));

    }
}
