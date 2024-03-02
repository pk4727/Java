import java.io.*;

public class fileHandling {
    public static void main(String[] args) throws IOException {
        fileCreation();
        fileWriter();
        writer();
        readerOneByOne();
        readerEntireLine();

    }

    public static void fileCreation() {
        try { // create
            File f = new File("fileHandling2.txt");
            f.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try { // write in the file
            FileWriter fw = new FileWriter("fileHandling2.txt");
            fw.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज, अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच:");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try { // reading from a file
            BufferedReader br = new BufferedReader(new FileReader("fileHandling2.txt"));
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try { // create and delete
            File fo = new File("random.txt");
            fo.createNewFile();
            if (fo.delete()) {
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileWriter() {
        try {
            FileWriter fw = new FileWriter("fileHandling.txt");
            // fw.write(19); // remove all data and write this in file
            // fw.write('P');
            // fw.write("Pradhuman", 3, 5);
            // fw.write("I am from grd.");
            char[] arr = { 'p', 'r', 'a', 'd', 'h', 'u', 'm', 'a', 'n' };
            fw.write(arr);
            fw.append('\n'); // for new line append
            fw.append('P'); // add this in file with previous data
            fw.append('\n');
            fw.append("Pradhuman", 3, 7);
            fw.append('\n');
            fw.append("Hii I am Pradhuman Kumar !");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // try {
        // BufferedWriter bw = new BufferedWriter(new FileWriter("fileHandling.txt"));
        // bw.write("Hare Krishna"); // remove all data and write this in file
        // bw.close();
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }
    }

    public static void writer() {
        try {
            OutputStream os = System.out;
            os.write(99);
            // os.write(😀); // range exceed ( U+D83D )
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            osw.write(91);
            osw.write('p');
            // os.write(😀); // range exceed ( U+D83D )
            osw.write("pk");
            osw.write("Pradhuman", 3, 5);
            char[] arr = { 'p', 'r', 'a', 'd', 'h', 'u', 'm', 'a', 'n' };
            osw.write(arr);
            osw.flush(); // print
            osw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readerOneByOne() {
        System.out.println("\n======= for read one by one char ===========");
        try {
            InputStreamReader isr = new InputStreamReader(System.in); // char input
            System.out.print("Enter some letters : ");
            int letter = isr.read(); // (ascii value) int take as input
            while (isr.ready()) {
                System.out.print(letter + " = ");
                System.out.println((char) letter); // so convert to char
                letter = isr.read();
            }
            // isr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileReader fr = new FileReader("fileHandling.txt"); // file name as parameter
            while (fr.ready()) {
                int frl = fr.read();
                System.out.println((char) frl);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readerEntireLine() {
        System.out.println("\n======= for read entire line ===========");
        try { // byte(default keyboard) to char then read char stream
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter letter : ");
            System.out.println("readline : " + br.readLine());
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedReader brf = new BufferedReader(new FileReader("fileHandling.txt"));
            while (brf.ready()) {
                System.out.println(brf.readLine());
            }
            brf.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
