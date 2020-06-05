package de.dynamic.programming.pot.gold;

/**
 N Töpfe mit jeweils einer bestimmten Anzahl von Goldmünzen sind in einer Reihe angeordnet.
 Sie spielen ein Spiel gegen einen anderen Spieler. Sie wählen abwechselnd einen Goldtopf aus.
 Sie können an beiden Enden der Reihe einen Topf auswählen, den Topf abnehmen und die Goldstücke
 behalten. Der Spieler mit den meisten Goldmünzen am Ende der Reihe gewinnt. Entwickeln Sie eine
 Strategie für dieses Spiel.
 */
public class NPotGold {

    static class Pair {
        int first, second;
        int pick = 0;

        public String toString() {
            // return first + " " + second + " " + pick;
            return "  " + pick;
        }
    }

    public Pair[][] findMoves(int pots[]) {

        Pair[][] moves = new Pair[pots.length][pots.length];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                moves[i][j] = new Pair();
            }
        }

        for (int i = 0; i < pots.length; i++) {
            moves[i][i].first = pots[i];
            //to track the sequence of moves
            moves[i][i].pick = i;
        }

        for (int l = 2; l <= pots.length; l++) {
            for (int i = 0; i <= pots.length - l; i++) {
                int j = i + l - 1;
                if (pots[i] + moves[i + 1][j].second > moves[i][j - 1].second + pots[j]) {
                    moves[i][j].first = pots[i] + moves[i + 1][j].second;
                    moves[i][j].second = moves[i + 1][j].first;
                    moves[i][j].pick = i;
                } else {
                    moves[i][j].first = pots[j] + moves[i][j - 1].second;
                    moves[i][j].second = moves[i][j - 1].first;
                    moves[i][j].pick = j;
                }
            }
        }

        return moves;
    }

    //prints the sequence of values and indexes
    public void printSequence(int pots[], Pair moves[][]) {
        int i = 0;
        int j = pots.length - 1;
        int step;
        for (int k = 0; k < pots.length; k++) {
            step = moves[i][j].pick;
            //this is the value of pick and its index
            System.out.print("value: " + pots[step] + " " + "index: " + step + " ");
            if (step <= i) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
    }

    public static void main(String args[]) {
        NPotGold npg = new NPotGold();
        int pots[] = {3, 1, 5, 6, 2, 9, 3};
        Pair[][] moves = npg.findMoves(pots);
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                System.out.print(moves[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("The moves by first player and second player:");
        npg.printSequence(pots, moves);
    }
}