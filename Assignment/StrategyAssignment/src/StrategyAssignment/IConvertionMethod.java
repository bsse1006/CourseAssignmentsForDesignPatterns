package StrategyAssignment;

import java.io.File;
import java.io.FileNotFoundException;

public interface IConvertionMethod
{
    void convert(File file) throws FileNotFoundException;
}
