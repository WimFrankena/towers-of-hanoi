package org.acme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TOH{
    static void towerOfHanoi(int n, char beginningRod, char finalRod, char helperRod)
    {
        if (n == 1)
        {
            System.out.println("Move disk from rod " + beginningRod + " to rod " + finalRod);
            return;
        }
        towerOfHanoi(n - 1, beginningRod, helperRod, finalRod);
        System.out.println("Move disk " + n + " from rod " + beginningRod + " to rod " + finalRod);
        towerOfHanoi(n - 1, helperRod, beginningRod, finalRod);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader inputReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("How many disks would you like to play with?");
        System.out.println("    The input has to be a number between 3 and 5");

        try {
            int n = Integer.parseInt(inputReader.readLine());
            if (n >= 3 && n <= 5) {
                towerOfHanoi(n, 'A', 'C', 'B');
                System.out.println("Victory!");
            } else {
                System.out.println("The amount of rings has to be a number between 3 and 5.");
                System.out.println("Exiting the game.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Exited with the following error: " + e);
        }
    }
}