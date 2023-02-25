package generic_search.missionaries;

import generic_search.GenericSearch;
import generic_search.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static generic_search.missionaries.MCState.MAX_NUM;

public class Missionaries {

    public static void main(String[] args) {
        MCState start = new MCState(MAX_NUM, MAX_NUM, true);
        Node<MCState> bfs = GenericSearch.dfs(start, MCState::goalTest, MCState::successors);
        if (bfs == null) {
            System.out.println("No solution found!");
        } else {
            List<MCState> path = GenericSearch.nodeToPath(bfs);
            displaySolution(path);
        }
    }

    public static void displaySolution(List<MCState> path) {
        if (path.size() == 0) {
            return;
        }
        System.out.println("Solution found for " + path.size() + " steps");
        MCState oldState = path.get(0);
        System.out.println(oldState);
        for (MCState current : path.subList(1, path.size())) {
            if (current.boat) {
                System.out.printf("%d missioners and %d cannibals moved from the east bank to the west bank.%n",
                        oldState.em - current.em,
                        oldState.ec - current.ec);
            } else {
                System.out.printf("%d missioners and %d cannibals moved from the west bank to the east bank.%n",
                        oldState.wm - current.wm,
                        oldState.wc - current.wc);
            }
            System.out.println(current);
            oldState = current;
        }
    }

}


