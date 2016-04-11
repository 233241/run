package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import view.IView;
import model.IModel;

public class Controller implements IController
{
    private IView view;
    private IModel model;

    public Controller(IModel model, IView view)
    {
        this.view = view;
        this.model = model;

        this.model.load();
        refreshProgramNames();

        addListeners();
    }

    @Override
    public void run()
    {
        this.view.setVisible(true);
    }

    private void addListeners()
    {
        ActionListener[] actionListeners = new ActionListener[4];
        actionListeners[0] = new AddProgramNameActionListener();
        actionListeners[1] = new RemoveProgramNameActionListener();
        actionListeners[2] = new ChromeActionListener();
        actionListeners[3] = new RunActionListener();

        WindowListener closeWindowListener = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                model.save();
                System.exit(0);
            }
        };

        view.addActionListeners(actionListeners);
        view.addWindowListener(closeWindowListener);
    }

    private class AddProgramNameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String programName = view.getNewProgramName();
            if (!programName.equals(""))
                model.addProgram(programName);
            refreshProgramNames();
        }
    }

    private class RemoveProgramNameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            removeProgramName();
            refreshProgramNames();
        }

        private void removeProgramName()
        {
            String programName = view.getSelectedProgramName();
            if (programName != null)
                model.removeProgram(programName);
        }
    }

    private class ChromeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.setNewProgramName("chromium-browser ");
        }
    }

    private class RunActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            model.run();
        }
    }

    private void refreshProgramNames()
    {
        String[] programNames = model.getProgramNames();
        view.refreshProgramNames(programNames);
    }
}
