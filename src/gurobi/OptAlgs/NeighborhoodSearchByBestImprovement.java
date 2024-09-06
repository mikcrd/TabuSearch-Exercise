package gurobi.OptAlgs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NeighborhoodSearchByBestImprovement extends NeighborhoodSearchBuilder {

    public NeighborhoodSearchByBestImprovement() {
        super();
    }

    /* Does a complete search through all the neighborhood
    * */
    public List<Neighbor> generateNeighborhood(Solution solution, List<Move> tabuList)  {

        for(int i = 0; i < solution.getSolution().size(); i++) {
            for(int j = i+1; j < solution.getSolution().size(); j++) {
                Move move = new Move(i, j);
                if(!(tabuList.contains(move) || tabuList.contains(move.reversedMove()))) {
                    Solution newsol = move.applyMove(solution);
                    getNeighborhood().add(new Neighbor(move, newsol));
                }
            }
        }

        return getNeighborhood();
    }


}
