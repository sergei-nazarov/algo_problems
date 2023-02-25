package csp;

import java.util.*;

public class SendMoreMoneyConstraint extends Constraint<Character, Integer> {

    List<Character> variables;

    public SendMoreMoneyConstraint(List<Character> variables) {
        super(variables);
        this.variables = variables;
    }

    public static void main(String[] args) {
        List<Character> variables = List.of('D', 'E', 'N','M', 'O', 'R', 'S', 'Y');
        Map<Character, List<Integer>> domain = new HashMap<>();
        for (Character c : variables) {
            domain.put(c, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
        domain.replace('M',List.of(1));
        CSP<Character, Integer> sendMoreMoneyCsp = new CSP<>(variables, domain);
        sendMoreMoneyCsp.addConstraint(new SendMoreMoneyConstraint(variables));
        Map<Character, Integer> answer = sendMoreMoneyCsp.backtrackingSearch();
        int s = answer.get('S');
        int e = answer.get('E');
        int n = answer.get('N');
        int d = answer.get('D');
        int m = answer.get('M');
        int o = answer.get('O');
        int r = answer.get('R');
        int y = answer.get('Y');
        int send = s * 1000 + e * 100 + n * 10 + d;
        int more = m * 1000 + o * 100 + r * 10 + e;
        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;
        System.out.println(answer);
        System.out.println(send + " + " + more + " = " + money);
        System.out.println(send + more == money);

    }


    @Override
    public boolean satisfied(Map<Character, Integer> assignment) {
        if (new HashSet<>(assignment.values()).size() < assignment.size()) {
            return false;
        }
        if (variables.size() == assignment.size()) {
            int s = assignment.get('S');
            int e = assignment.get('E');
            int n = assignment.get('N');
            int d = assignment.get('D');
            int m = assignment.get('M');
            int o = assignment.get('O');
            int r = assignment.get('R');
            int y = assignment.get('Y');
            int send = s * 1000 + e * 100 + n * 10 + d;
            int more = m * 1000 + o * 100 + r * 10 + e;
            int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;
            return send + more == money;
        }
        return true;
    }
}
