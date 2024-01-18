package Week3Inlab;

import java.util.ArrayList;
import java.util.List;

// Product interface
interface StudentRegister {
    void displayAll();
    void delete(String studentName);
    void displayPreviousAndNext(String studentName);
    void add(String studentName);
}

// Concrete product
class ClassRegister implements StudentRegister {
    private List<String> studentNames = new ArrayList<>();
    @Override
    public void displayAll() {
        System.out.println("Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
        System.out.println();
    }

    @Override
    public void delete(String studentName) {
        studentNames.remove(studentName);
        System.out.println(studentName + " has been removed from the register.\n");
    }

    @Override
    public void displayPreviousAndNext(String studentName) {
        int index = studentNames.indexOf(studentName);
        if (index >= 0) {
            System.out.println("Previous student: " + (index > 0 ? studentNames.get(index - 1) : "None"));
            System.out.println("Next student: " + (index < studentNames.size() - 1 ? studentNames.get(index + 1) : "None"));
        } else {
            System.out.println("Student not found in the register.\n");
        }
    }

    @Override
    public void add(String studentName) {
        studentNames.add(studentName);
        System.out.println(studentName + " has been added to the register.\n");
    }
}

// Factory
class RegisterFactory {
    public static StudentRegister createStudentRegister() {
        return new ClassRegister();
    }
}

 class Students {
    public static void main(String[] args) {
        StudentRegister register = RegisterFactory.createStudentRegister();

        // Adding initial student names
        register.add("Ajay");
        register.add("Bala");
        register.add("Cathey");
        register.add("Chella");
        register.add("Dolly");
        register.add("Ellan");
        register.add("Francis");
        register.add("Stella");

        // Display all student names
        register.displayAll();

        // Delete "Chella" from the register
        register.delete("Chella");
        register.displayAll();

        // Display previous and next names for "Dolly"
        register.displayPreviousAndNext("Dolly");

        // Add "Zara" into the register
        register.add("Zara");
        register.displayAll();
    }
}
