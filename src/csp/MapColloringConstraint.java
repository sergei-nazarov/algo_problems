package csp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapColloringConstraint extends Constraint<String, String> {
    String place1, place2;

    public MapColloringConstraint(String place1, String place2) {
        super(List.of(place1, place2));
        this.place1 = place1;
        this.place2 = place2;
    }

    @Override
    public boolean satisfied(Map<String, String> assignment) {
        if (!assignment.containsKey(place1) || !assignment.containsKey(place2)) {
            return true;
        }
        return !assignment.get(place1).equals(assignment.get(place2));
    }

    public static void main(String[] args) {
        List<String> variables = List.of("Northern Territory", "South Australia", "Queensland", "New South Wales", "Victoria", "Tasmania", "Sveta","Western Australia");
        Map<String, List<String>> domains = new HashMap<>();
        for (String variable : variables) {
            domains.put(variable, List.of("red", "green", "blue"));
        }
        CSP<String, String> csp = new CSP<>(variables, domains);
        csp.addConstraint(new MapColloringConstraint("Western Australia", "Northern Territory"));
        csp.addConstraint(new MapColloringConstraint("Western Australia", "South Australia"));
        csp.addConstraint(new MapColloringConstraint("South Australia", "Northern Territory"));
        csp.addConstraint(new MapColloringConstraint("Queensland", "Northern Territory"));

        csp.addConstraint(new MapColloringConstraint("Victoria", "South Australia"));
        csp.addConstraint(new MapColloringConstraint("Victoria", "New South Wales"));
        csp.addConstraint(new MapColloringConstraint("Victoria", "Tasmania"));


        csp.addConstraint(new MapColloringConstraint("Queensland", "South Australia"));
        csp.addConstraint(new MapColloringConstraint("Queensland", "New South Wales"));
        csp.addConstraint(new MapColloringConstraint("New South Wales", "South Australia"));
        csp.addConstraint(new MapColloringConstraint("Sveta", "South Australia"));
        csp.addConstraint(new MapColloringConstraint("New South Wales", "Sveta"));




        Map<String, String> solution = csp.backtrackingSearch();
        if (solution == null) {
            System.out.println("No solution");
        } else {
            System.out.println(solution);
        }
    }
}
