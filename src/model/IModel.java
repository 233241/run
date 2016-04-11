package model;

public interface IModel
{
    void run();

    void addProgram(String programName);
    void removeProgram(String programName);
    String[] getProgramNames();

    void load();
    void save();
}
