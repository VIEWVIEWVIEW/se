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
        Note note = new Note(1.0f);
        printFields(note.getClass());

        // Test Wahlpflichtmodul Fields
        Wahlpflichtmodul wahlpflichtmodulDeepLearning = new Wahlpflichtmodul(5, 1 , Wahlpflichtfaecher.DeepLearning);
        printFields(wahlpflichtmodulDeepLearning.getClass());

        // Pflichtmodul-Fields
        Pflichtmodul pflichtmodul = new Pflichtmodul(5, 1, "Test");
        printFields(pflichtmodul.getClass());

        // Abschluss-Fields
        Abschluss abschluss = new Abschluss(1, 1);
        printFields(abschluss.getClass());


        // Test Note Methods
        try {
            note.setErgebnis(0.0f);
        } catch (IllegalArgumentException e) {
            System.out.println(e);

        }

        try {
            note.setErgebnis(6.0f);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            note.setErgebnis(1.5f);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            note.setErgebnis(1.3f);
            System.out.println(note.getErgebnis() + " erfolgreich gesetzt");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        System.out.println("==========");


        // wahlpflichtmodulDeepLearning: Multiplizitäten zu Noten
        Note tmp = new Note(1.0f);
        wahlpflichtmodulDeepLearning.noteHinzufuegen(tmp);
        wahlpflichtmodulDeepLearning.noteHinzufuegen(tmp);
        wahlpflichtmodulDeepLearning.noteHinzufuegen(tmp);
        try {
            wahlpflichtmodulDeepLearning.noteHinzufuegen(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        wahlpflichtmodulDeepLearning.letzteNoteEntfernen();
        wahlpflichtmodulDeepLearning.letzteNoteEntfernen();
        wahlpflichtmodulDeepLearning.letzteNoteEntfernen();
        try {
            wahlpflichtmodulDeepLearning.letzteNoteEntfernen();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("==========");



        // Pflichtmodul Multiplizitäten zu Noten
        Pflichtmodul softwareEngineering = new Pflichtmodul(5, 1, "Software Engineering");
        softwareEngineering.noteHinzufuegen(tmp);
        softwareEngineering.noteHinzufuegen(tmp);
        softwareEngineering.noteHinzufuegen(tmp);
        try {
            softwareEngineering.noteHinzufuegen(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        softwareEngineering.letzteNoteEntfernen();
        softwareEngineering.letzteNoteEntfernen();
        softwareEngineering.letzteNoteEntfernen();
        try {
            softwareEngineering.letzteNoteEntfernen();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("==========");

        // Abschluss
        Abschluss a = new Abschluss(5, 5);
        a.noteBachelorHinzufuegen(tmp);
        a.noteBachelorHinzufuegen(tmp);
        try {
            a.noteBachelorHinzufuegen(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        a.letzteBachelornoteEntfernen();
        a.letzteBachelornoteEntfernen();
        try {
            a.letzteBachelornoteEntfernen();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        a.noteKolloquiumHinzufuegen(tmp);
        a.noteKolloquiumHinzufuegen(tmp);
        try {
            a.noteKolloquiumHinzufuegen(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        a.letzteKolloquiumnoteEntfernen();
        a.letzteKolloquiumnoteEntfernen();
        try {
            a.letzteKolloquiumnoteEntfernen();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }



        System.out.println(wahlpflichtmodulDeepLearning.name);

        System.out.println("ENUM: "+ wahlpflichtmodulDeepLearning.name + " VALUE: " +wahlpflichtmodulDeepLearning.name.name);
    }
}