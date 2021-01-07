package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.Console;
import mastermind.views.Message;

class StartView {

    void interact(StartController startController) {
        Console.getInstance().outln(Message.TITLE.getMessage());  
        startController.initialize();                          
        Console.getInstance().outln(new SecretCombinationView(startController).show());
    }    
}
