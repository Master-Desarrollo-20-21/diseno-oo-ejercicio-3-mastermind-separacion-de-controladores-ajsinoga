package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.models.Combination;

public class SecretCombinationView {

    private Controller controller;

    public SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    public String show() {
        String encryptedCombination = "";
        for (int i = 0; i < Combination.size(); i++) {
            encryptedCombination += "*";						            
        }
        return encryptedCombination;
    }

    public String showDecrypted() {        
        return this.controller.RevealSecretCombination().getCombination();
    }
}