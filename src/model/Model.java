package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;


public class Model implements IModel
{
    private TreeSet<String> programNames;
    private static final String path = "data.txt";

    public void load()
    {
        programNames = new TreeSet<>();

        File file = new File(path);

        if (file.exists())
            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                    programNames.add(line);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public void save()
    {
        File file = new File(path);

        if (! file.exists())
            try
            {
                file.createNewFile();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (String programName : programNames)
            {
                writer.write(programName);
                writer.newLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        for (String programName : programNames)
        {
            try
            {
                Runtime.getRuntime().exec(programName);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addProgram(String programName)
    {
        programNames.add(programName);
    }

    @Override
    public void removeProgram(String programName)
    {
        programNames.remove(programName);
    }

    @Override
    public String[] getProgramNames()
    {
        return programNames.toArray(new String[0]);
    }

}
