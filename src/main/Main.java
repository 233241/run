package main;

import javax.swing.SwingUtilities;

import controller.Controller;
import controller.IController;
import view.IView;
import view.View;
import model.IModel;
import model.Model;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            IModel model = new Model();
            IView view = new View();
            IController controller = new Controller(model, view);
            controller.run();
        });
    }
}