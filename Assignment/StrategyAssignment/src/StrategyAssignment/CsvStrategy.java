package StrategyAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CsvStrategy implements IConvertionMethod
{
    @Override
    public void convert(File file) throws FileNotFoundException {
        ArrayList<Data> dataArrayList = FileParser.parseFile(file);

        String csv = "Name,Roll,Number\n";

        for(Data data: dataArrayList)
        {
            csv+=data.getName()+","+data.getRoll()+","+data.getNumber()+"\n";
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(new File(file.getAbsolutePath() + "_converted.csv"));
            outputStream.write(csv.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
