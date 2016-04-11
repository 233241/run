package view;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface IView
{
    String getNewProgramName();
    void setNewProgramName(String string);
    String getSelectedProgramName();
    void refreshProgramNames(String[] programNames);

    void addActionListeners(ActionListener[] listeners);
    void addWindowListener(WindowListener windowListener);
    void setVisible(boolean b);
}
