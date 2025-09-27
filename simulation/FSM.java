package simulation;

import java.util.ArrayList;

import simulation.State;

public class FSM {
    public State initialState;
    public ArrayList<State> states = new ArrayList<State>();
    public ArrayList<State> finalStates = new ArrayList<State>();
    public static void main(String[] args) {
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

    public void startMachine(String inputString) {
        for (int i = 0 ; i < inputString.length(); i++) {

        }
    }
}




