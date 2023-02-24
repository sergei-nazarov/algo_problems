package Missionaries;

import labirint.GenericSearch;
import labirint.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static Missionaries.MCState.MAX_NUM;

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


class MCState {

    public static final int MAX_NUM = 5;
    final int wm; //Миссионеры с западного берега
    final int wc; //Людоеды с западного берега
    final int em; //Миссионеры с восточного берега
    final int ec; //Людоеды с восточного берега
    final boolean boat; //Лодка на западном берегу?

    public MCState(int missionaries, int cannibals, boolean boat) {
        wm = missionaries;
        wc = cannibals;
        em = MAX_NUM - wm;
        ec = MAX_NUM - wc;
        this.boat = boat;
    }

    public boolean goalTest() {
        return isLegal() && em == MAX_NUM && ec == MAX_NUM;
    }

    public static List<MCState> successors(MCState mcs) {
        List<MCState> sucs = new ArrayList<MCState>();
        if (mcs.boat) {
            if (mcs.wm > 1) {
                sucs.add(new MCState(mcs.wm - 2, mcs.wc, !mcs.boat));
            }
            if (mcs.wm > 0) {
                sucs.add(new MCState(mcs.wm - 1, mcs.wc, !mcs.boat));
            }
            if (mcs.wc > 1) {
                sucs.add(new MCState(mcs.wm, mcs.wc - 2, !mcs.boat));
            }
            if (mcs.wc > 0) {
                sucs.add(new MCState(mcs.wm, mcs.wc - 1, !mcs.boat));
            }
            if (mcs.wc > 0 && mcs.wm > 0) {
                sucs.add(new MCState(mcs.wm - 1, mcs.wc - 1, !mcs.boat));
            }
        } else {
            if (mcs.em > 1) {
                sucs.add(new MCState(mcs.wm + 2, mcs.wc, !mcs.boat));
            }
            if (mcs.em > 0) {
                sucs.add(new MCState(mcs.wm + 1, mcs.wc, !mcs.boat));
            }
            if (mcs.ec > 1) {
                sucs.add(new MCState(mcs.wm, mcs.wc + 2, !mcs.boat));
            }
            if (mcs.ec > 0) {
                sucs.add(new MCState(mcs.wm, mcs.wc + 1, !mcs.boat));
            }
            if (mcs.ec > 0 && mcs.em > 0) {
                sucs.add(new MCState(mcs.wm + 1, mcs.wc + 1, !mcs.boat));
            }
        }
        sucs.removeIf(Predicate.not(MCState::isLegal));
        return sucs;
    }


    public boolean isLegal() {
        if (wm < wc && wm > 0) {
            return false;
        }
        if (em < ec && em > 0) {
            return false;
        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MCState state = (MCState) o;

        if (wm != state.wm) return false;
        if (wc != state.wc) return false;
        if (em != state.em) return false;
        if (ec != state.ec) return false;
        return boat == state.boat;
    }

    @Override
    public int hashCode() {
        int result = wm;
        result = 31 * result + wc;
        result = 31 * result + em;
        result = 31 * result + ec;
        result = 31 * result + (boat ? 1 : 0);
        return result;
    }


    @Override
    public String toString() {
        return String.format("On the west bank there are %d missionaries and %d cannibals.%n"
                        + "On the east bank there are %d missionaries and %d cannibals.%n"
                        + "The boat is on the %s bank",
                wm, wc, em, ec, boat ? "west" : "east");
    }


}
