import java.io.*;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOpractice {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File x = new File("C:\\Users\\Rayan system\\Desktop\\java\\names.txt");
        File f = new File("C:\\Users\\Rayan system\\Desktop\\java\\females.txt");
        File m = new File("C:\\Users\\Rayan system\\Desktop\\java\\males.txt");

        readFile(x);
        System.out.println("--------------");
        splitByGender(x);
        System.out.println("--------------");
        findDuplicates(f, m);
        System.out.println("--------------");
        showGreaterThan25Years(x);
    }


    private static void showGreaterThan25Years(File x) throws FileNotFoundException {
        Costumer costumer = new Costumer();
        Scanner scanner = new Scanner(x);
        String[] line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().split("[:;]");
            costumer.setName(line[1]);
            costumer.setGender(line[3]);
            costumer.setAge(line[5]);
            if (Integer.parseInt(costumer.getAge()) >= 25) {
                System.out.println(costumer);
            }
        }
    }

    private static void findDuplicates(File f, File m) throws FileNotFoundException {
        String name;
        Scanner male = new Scanner(m);
        Scanner female = new Scanner(f);
        while (male.hasNextLine()) {
            name = male.nextLine().split(" ")[0];
            female = new Scanner(f);
            while (female.hasNextLine()) {
                if (Objects.equals(name, female.nextLine().split(" ")[0])) {
                    System.out.println(name);
                }
            }
        }
    }

    private static void splitByGender(File x) throws FileNotFoundException {
        Scanner scanner = new Scanner(x);
        scanner.useDelimiter(";|\n");
        String name = "", gender, p = ":|\n";
        String age;
        Formatter male = new Formatter(
                "C:\\Users\\Rayan system\\Desktop\\java\\males.txt");
        Formatter female = new Formatter(
                "C:\\Users\\Rayan system\\Desktop\\java\\females.txt");
        while (scanner.hasNext()) {
            name = scanner.next().split(p)[1];
            gender = scanner.next().split(p)[1];
            age = scanner.next().split(p)[1];
            System.out.println(name + " " + gender + " " + age);
            if (Objects.equals(gender, "male")) {
                male.format("%s %s %s", name, gender, age);
            } else {
                female.format("%s %s %s", name, gender, age);
            }
        }
        male.close();
        female.close();
    }


    private static void readObjectCostumer() throws IOException, ClassNotFoundException {
        File file = new File(
                "C:\\Users\\Rayan system\\Desktop\\java\\names.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Costumer costumer = (Costumer) objectInputStream.readObject();
        System.out.println(costumer);
    }

    private static void writeObjectCostumer() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\Rayan system\\Desktop\\java\\IOpractice\\IOpractice\\\\ahmad.txt"));
        objectOutputStream.writeObject(new Costumer("Ahmad", "male", "27"));
    }

    private static void writeUsingFileOutPutStream() throws IOException {
        Formatter f = new Formatter("C:\\Users\\Rayan system\\Desktop\\java\\IOpractice\\IOpractice\\test.txt");
        f.close();
        File file = new File("C:\\Users\\Rayan system\\Desktop\\java\\IOpractice\\IOpractice\\test.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(123456789);
        }
    }

    private static void readFileUsingScanner() throws FileNotFoundException {
        File x = new File("C:\\Users\\Rayan system\\Desktop\\java\\ahmad.txt");
        Scanner scanner = new Scanner(x);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
        scanner.close();
    }

    private static void readingFileUsingFileReader() throws IOException {
        FileReader f = new FileReader("C:\\Users\\Rayan system\\Desktop\\java\\ahmad.txt");
        int ch;
        while (-1 != (ch = f.read())) {
            System.out.print((char) ch);
        }
    }


    private static void readFile(File x) throws FileNotFoundException {

        System.out.println(x.exists());
        System.out.println(x.length());
        System.out.println(x.getName());
        System.out.println(x.isDirectory());
        System.out.println(x.isHidden());
        System.out.println(x.getAbsolutePath());

        Scanner scanner = new Scanner(x);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }


    }
}
