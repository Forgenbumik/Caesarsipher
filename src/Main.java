import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.lang.String;


public class Main {
    static Scanner scanner;
    static int shift;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            try {
                shift = scanner.nextInt() % 26;
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Введите целое число!");
                scanner.next();
            }
        }
        
        try(FileInputStream fin=new FileInputStream("getText.txt");
            FileOutputStream fos=new FileOutputStream("output.txt"))
            {
                int i;
                while((i=fin.read())!=-1){
                    if (i >= 65 && i <= 90) {
                        i += shift;
                        if (i > 90) i -= 26;
                        if (i < 65) i += 26;
                        fos.write((char)(i));
                    }
                    else if (i >= 97 && i <= 122) {
                        i += shift;
                        if (i > 122) i -= 26;
                        if (i < 97) i += 26;
                        fos.write((char)i);
                    }
                    else fos.write((char)i);
                }
            System.out.println("File has been written");
            }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}