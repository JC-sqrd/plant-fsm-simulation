package simulation;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class State {
    //Transitions 
    public String stateName = "Q0";
    public HashMap<String, ArrayList<State>> transitions = new HashMap<String, ArrayList<State>>();

    public State() {}

    public State(String name) {
        this.stateName = name;
    }

    public boolean addTransition(String transitionString, State transitionState){
        if (transitions.containsKey(transitionString)) {
            transitions.get(transitionString).add(transitionState);
            return true;
        }
        else if (!transitions.containsKey(transitionString)) {
            ArrayList<State> stateList = new ArrayList<State>();
            stateList.add(transitionState);
            transitions.put(transitionString, stateList);
            return true;
        }
        return false;
    }

    public void printTransitions() {
        Set<String> transitionKeySet = transitions.keySet();
        for (String transitionKey : transitionKeySet) {
            System.out.println(transitions.get(transitionKey).toString());
        }
    }

    public String toString() {
        return stateName;
    }

}
