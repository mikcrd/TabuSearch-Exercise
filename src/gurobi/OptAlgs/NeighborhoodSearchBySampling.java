package gurobi.OptAlgs;

import java.util.List;
import java.util.Random;

public class NeighborhoodSearchBySampling extends NeighborhoodSearchBuilder {

    private static final int SAMPLING_NUM = 5; // how many samples we want to take from the neighborhood

    public NeighborhoodSearchBySampling() {
        super();
    }

    /* Samples n neighbors at random, where n = SAMPLING_NUM
    * */
    @Override
    public List<Neighbor> generateNeighborhood(Solution solution, List<Move> tabuList)  {
        int count = 0;
        while(count <= SAMPLING_NUM) {
            Random rand = new Random();
            int rand1 = rand.nextInt(6);
            int rand2 = rand.nextInt(6);

            if(! (rand1 == rand2)) {
                Move move = new Move(rand1, rand2);

                if(! tabuList.contains(move)) {
                    Solution newsol = move.applyMove(solution);
                    Neighbor newneigh = new Neighbor(move, newsol);

                    if(! (getNeighborhood().contains(newneigh))) {
                        getNeighborhood().add(newneigh);
                        count += 1;
                    }
                }
            }
        }

        return getNeighborhood();
    }
}
