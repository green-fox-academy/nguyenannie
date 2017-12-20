import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Model {
    private static final String FILE_NAME = "favourites.txt";
    private Path path = Paths.get(FILE_NAME);

    void addAnimal(String[] animals) throws Exception{
        List<String> favouriteAnimalList = Files.readAllLines(path);
        for(String animal:animals) {
            if(!favouriteAnimalList.contains(animal)) {
                favouriteAnimalList.add(animal);
            }
        }
        Files.write(path,favouriteAnimalList);
    }
}
