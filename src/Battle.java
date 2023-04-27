public class Battle {

    final static private int MAX = 5;

    private Monster[] monsters;
    private int n = 0;

    Battle () {
        monsters = new Monster[MAX];
    }

    void add (Monster monster) {
        if (n < MAX) {
            monsters [n] = monster;
            n++;
        }
        else {
            System.out.println("No more monsters!" );
        }
    }

    void run () {
        for (int i = 0; i < n; i++) {
            if (monsters[i] != null) {
                monsters[i].attack();
            }
        }
    }

    public void start(){
        run();
    }
}
