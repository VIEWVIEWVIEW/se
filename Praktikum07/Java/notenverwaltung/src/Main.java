import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void printFields(Class<?> clazz) {
        System.out.println("Fields of " + clazz.getName());
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getName() + " " + field.getType() + " " + field.getModifiers());
        }
        System.out.println("==========");
    }

    public static void test() {
        // Modifiers: https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Modifier.html
        // Test Note Fields
        Note note = new Note();
        printFields(note.getClass());

        // Test Wahlpflichtmodul Fields
        Wahlpflichtmodul wahlpflichtmodul = new Wahlpflichtmodul();
        printFields(wahlpflichtmodul.getClass());

        Wahlpflichtmodul w = new Wahlpflichtmodul();
        w.Name = Wahlpflichtfaecher.EinfuehrungMachineLearning;
        System.out.println(w.Name.name);
    }
}