package StrategyAssignment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class JsonStrategy implements IConvertionMethod
{
    @Override
    public void convert(File file) throws FileNotFoundException {

        ArrayList<Data> dataArrayList = FileParser.parseFile(file);

        JSONArray jsonArray = new JSONArray();

        try {

            for (Data data : dataArrayList) {

                JSONObject object = new JSONObject();

                object.put("Number", data.getNumber());
                object.put("Roll", data.getRoll());
                object.put("Name", data.getName());

                jsonArray.put(object);
            }

            JSONObject obj = new JSONObject();
            obj.put("Student",jsonArray);

            String json = obj.toString();

            FileOutputStream outputStream = new FileOutputStream(new File(file.getAbsolutePath() + "_converted.json"));
            outputStream.write(json.getBytes());
            outputStream.close();

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}

