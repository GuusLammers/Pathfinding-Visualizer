import View.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller {

    Model model;
    View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.addAllActionListeners();
    }

    private void addAllActionListeners() {
        this.view.getNavigationPanel().addStartButtonListener(new StartButtonListener());
        this.view.getNavigationPanel().addClearButtonListener(new ClearButtonListener());
        this.view.getNavigationPanel().addResetButtonListener(new ResetButtonListener());
    }

    class StartButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String algorithm = view.getNavigationPanel().getSelectedAlgorithm();
            System.out.println("Start " + algorithm);
        }

    }

    class ClearButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Clear");
        }

    }

    class ResetButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Reset");
        }

    }

}
