package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame implements IView
{
    private JTextField textFieldTypeTheProgramName;
    private JButton buttonAddProgram, buttonRemoveProgram, buttonChromium, buttonRun;
    private JComboBox<String> comboBoxChooseProgram;

    public View()
    {
        setTitle("Run");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();
        createLayout();

        pack();
    }

    private void initComponents()
    {
        textFieldTypeTheProgramName = new JTextField();
        textFieldTypeTheProgramName.setPreferredSize(new Dimension(500, 25));

        buttonAddProgram = new JButton("ADD");
        buttonRemoveProgram = new JButton("REMOVE");

        comboBoxChooseProgram = new JComboBox<>();
        comboBoxChooseProgram.setPreferredSize(new Dimension(1000, 25));

        buttonChromium = new JButton("Chromium");
        buttonRun = new JButton("RUN ALL");
    }

    private void createLayout()
    {
        // set main layout
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        // set program layout
        JPanel pane1 = new JPanel();
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.X_AXIS));
        // set run layout
        JPanel pane2 = new JPanel();
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.X_AXIS));
        // add to program layout
        pane1.add(textFieldTypeTheProgramName);
        pane1.add(buttonAddProgram);
        pane1.add(buttonRemoveProgram);
        pane1.add(comboBoxChooseProgram);
        // add to other layout
        pane2.add(buttonChromium);
        pane2.add(buttonRun);
        // add to main layout
        contentPane.add(pane1);
        contentPane.add(pane2);
    }

    public String getNewProgramName()
    {
        return textFieldTypeTheProgramName.getText();
    }

    public void setNewProgramName(String newProgramName)
    {
        textFieldTypeTheProgramName.setText(newProgramName);
    }

    @Override
    public String getSelectedProgramName()
    {
        return (String) comboBoxChooseProgram.getSelectedItem();
    }

    @Override
    public void refreshProgramNames(String[] programNames)
    {
        comboBoxChooseProgram.removeAllItems();
        for (String programName : programNames)
            comboBoxChooseProgram.addItem(programName);
    }

    public void addActionListeners(ActionListener[] listeners)
    {
        buttonAddProgram.addActionListener(listeners[0]);
        buttonRemoveProgram.addActionListener(listeners[1]);
        buttonChromium.addActionListener(listeners[2]);
        buttonRun.addActionListener(listeners[3]);
    }

    @Override
    public void setVisible(boolean b)
    {
        super.setVisible(b);
    }
}






