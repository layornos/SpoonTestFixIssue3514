package foo;

import spoon.Launcher;
import spoon.reflect.CtModel;

public class App {
    public static void main(String[] args) {
        // https://github.com/PalladioSimulator/Palladio-Analyzer-SimuLizar
        String path = "/Users/layornos/Projects/Palladio-Analyzer-SimuLizar";
        Launcher launcher = new Launcher();
        launcher.addInputResource(path);
        launcher.getEnvironment().setNoClasspath(true);
        CtModel model = launcher.buildModel();

        model.getAllTypes().stream().unordered().forEach(type -> type.getUsedTypes(false).stream().unordered().forEach(usedType -> {
            System.out.println(usedType.getSimpleName());
        }));
    }
}