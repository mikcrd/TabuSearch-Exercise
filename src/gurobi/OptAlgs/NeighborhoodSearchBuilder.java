package gurobi.OptAlgs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class NeighborhoodSearchBuilder {

    private List<Neighbor> neighborhood;

    public NeighborhoodSearchBuilder() {
        this.neighborhood = new ArrayList<Neighbor>();
    }

    public List<Neighbor> getNeighborhood() {
        return neighborhood;
    }

    public abstract List<Neighbor> generateNeighborhood(Solution solution, List<Move> tabuList);

    /* Returns the best neighbor y in the neighborhood generated starting from solution x
    * */
    public Neighbor bestSolution(List<Neighbor> neighborhood) {
        List<Neighbor> sortedNeigh = neighborhood.stream().sorted(Comparator.comparingInt(neighbor ->
                neighbor.getSolution().getObjectiveFunct())).toList();
        return sortedNeigh.getFirst();
    }


    public void printNeighborhood() {
        for (Neighbor neigh : neighborhood) {
            neigh.printNeighbor();
        }
    }

}
