import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        List<ToDo> toDos = initializeTodos();

        for(Domino d : dominoes) {
            d.printAllField();
        }

        for(ToDo t : toDos) {
            t.printAllField();
        }
    }

    private static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }

    private static List<ToDo> initializeTodos() {
        List<ToDo> toDos = new ArrayList<>();
        ToDo thing1 = new ToDo("Get milk");
        toDos.add(thing1);
        ToDo thing2 = new ToDo("Remove the obstacles");
        toDos.add(thing2);
        ToDo thing3 = new ToDo("Stand up");
        thing3.complete();
        toDos.add(thing3);
        ToDo thing4 = new ToDo("Eat lunch");
        thing4.complete();
        toDos.add(thing4);
        return toDos;
    }
}
