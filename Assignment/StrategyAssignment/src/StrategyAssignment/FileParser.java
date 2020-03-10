package StrategyAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser
{
    static ArrayList<Data> arrayList = new ArrayList<>();

    public static ArrayList<Data> parseFile (File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(",");
            String name, roll, number;

            name = lineScanner.next();
            roll = lineScanner.next();
            number = lineScanner.next();

            Data data = new Data (name,roll,number);

            arrayList.add(data);
        }

        return arrayList;
    }
}
