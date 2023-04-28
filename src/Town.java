import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Town {

    class Trader {
        int money = 1000;
        List<Item> inventory = new LinkedList<Item> ();

        void buyItem () {}
        void sellItem () {}
    }

    class Inn {
        void sleep() {}
    }

    class Temple {
        void restoreHealth() {}
    }

    public static void main(String[] args) {

    }

    public static void enterTown () {
        System.out.println ("You are enter into Great Town." +
                "You can visit local shops and offices." +
                "Choose your goal.");
        Scanner scanner = new Scanner ( System.in );
        String choose="";

    }


}
