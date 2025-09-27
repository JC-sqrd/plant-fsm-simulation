package simulation;

import java.util.ArrayList;
import java.util.Arrays;

import simulation.State;

public class FSM {
    public State initialState;
    public ArrayList<State> states = new ArrayList<State>();
    public ArrayList<State> finalStates = new ArrayList<State>();
    public static void main(String[] args) {
    }

    public boolean startMachine(String inputString) {
        ArrayList<State> currentStates = new ArrayList<State>(Arrays.asList(initialState));

        for (int i = 0 ; i < inputString.length(); i++) {
            ArrayList<State> nextStates = new ArrayList<>();
            String input = String.valueOf(inputString.charAt(i));
            for (State state : currentStates) {
                System.out.println("State "+ state + " transitions:");
                state.printTransitions();
                if (state.transitions.containsKey(input)) {
                    nextStates.addAll(state.transitions.get(input));
                }     
            }
            currentStates = nextStates;
            System.out.println("Iteration: " + i + " input: " + input + " Current states: " + currentStates.toString());
        }
        
        for (State state : currentStates) {
            if (finalStates.contains(state)) {
                return true;
            }
        }
        return false;
    }

    public void setInitialState(State state) {
        initialState = state;
    }

    public void setStateAsFinalState(State state) {
        if (!states.contains(state)) {
            states.add(state);
            finalStates.add(state);
        }
        else {
            finalStates.add(state);
        }
    }

    public void unsetStateAsFinalState(State state) {
        if (finalStates.contains(state)) {
            finalStates.remove(state);
        }
    }

    public boolean isStateFinal(State state) {
        if (finalStates.contains(state)) {
            return true;
        }
        return false;
    }

    public void addState(State state) {
        states.add(state);
    }

    public void removeState(State state) {
        if (states.contains(state)) states.remove(state);
    }
}




