/*
 * @author Julio Caesar Tadena
 */


package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import simulation.FSM;


public class PlantSimulation
{

    private static Scanner scanner = new Scanner(System.in);
    private static String input = new String();
    private static double currentMilliSeconds = 0;
    private static double elapsedTime = 0;
    private static float inputF = 0.0f;
    private static String inputString = "";
    private static int stringSize = 0;  
    
    private static FSM fsm = new FSM();
    private static State state1 = new State("Q1");
    private static State state2 = new State("Q2");
    private static State state3 = new State("Q3");

    public static void main(String[] args) {

        inputStringSizeinputLoop();

        currentMilliSeconds = System.currentTimeMillis();
        gatherInputLoop();

        fsm.addState(state1);
        fsm.addState(state2);
        fsm.addState(state3);

        fsm.setInitialState(state1);
        fsm.setStateAsFinalState(state3);

        state1.addTransition("0", state1);
        state1.addTransition("1", state2);
        state2.addTransition("0", state1);
        state2.addTransition("1", state3);
        state3.addTransition("0", state3);
        state3.addTransition("1", state3);

        System.out.println("Input String: " + (inputString));
        System.out.println("Input String accepted: " + fsm.startMachine(inputString));
        
        
    }

    public static void inputStringSizeinputLoop() {
        boolean isDone = false;
        while (!isDone) {
            try {
                System.out.println("Enter input size: ");
                stringSize = Integer.parseInt(scanner.nextLine());
                isDone = true;
            }      
            catch(Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("Please enter a valid whole number ");
                }
            }
        }
    }


    public static void gatherInputLoop() {
        for (int i = 0; i < stringSize ; i++) {
            boolean isDone = false;
            System.out.println("Please enter voltage:");
            while(!isDone) {
                try{
                    inputF = Float.parseFloat(scanner.nextLine());
                    elapsedTime = (System.currentTimeMillis() - currentMilliSeconds) / 1000;
                    System.out.println("Elapsed time: " + elapsedTime);
                    currentMilliSeconds = System.currentTimeMillis();

                    if (elapsedTime > 30) {
                        inputString += 0;
                    }
                    else if (inputF > 2 || inputF < 0.25) {
                        inputString += 0;
                    }
                    else {
                        inputString += 1;
                    }
                    isDone = true;
                }
                catch(Exception e) {
                    if (e instanceof NumberFormatException) {
                        System.out.println("Please enter a valid number");
                    }
                }
            }
            evaluateInput(inputF);
        }
       
    }



    public static void evaluateInput(float inputF) {
        if (inputF > 2 || inputF < 0.25) {
            System.out.println("Input Symbol: 0");
        }
        else{
            System.out.println("Input symbol: 1");
        }
    }

}

