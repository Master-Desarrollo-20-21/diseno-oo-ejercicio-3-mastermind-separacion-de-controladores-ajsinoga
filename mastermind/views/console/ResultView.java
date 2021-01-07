package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.Message;
import mastermind.utils.Console;

public class ResultView {

    private PlayController playController;
    private CombinationView combinationView;
    private SecretCombinationView secretCombinationView;
    private Console console;

    public ResultView(PlayController playController) {
		this.playController = playController;
        this.combinationView = new CombinationView(playController);
        this.secretCombinationView = new SecretCombinationView(playController);
        this.console = Console.getInstance();
    }
    
	public void showNumberOfAttempts() {
        console.outln("\n" + Integer.toString(this.playController.getCurrentAttempt()) + Message.ATTEMPS.getMessage());		
	}
    
    public void showResult() {   
        this.showNumberOfAttempts();
        console.outln(this.secretCombinationView.show()); 
        for (int i = 0; i < this.playController.getCurrentAttempt(); i++) {
            console.outln(this.combinationView.show(i)  + " --> " 
                        + this.playController.numberOfBlacksAttempt(i) + " blacks and " + this.playController.numberOfWhitesAttempt(i) + " whites");
        }
        if (this.playController.isWinner()) {
			console.outln(Message.WINNER.getMessage());;
		} else if (this.playController.isCompleted()) {
			console.outln(Message.LOOSER.getMessage());
			console.outln(Message.SECRET.getMessage() + this.secretCombinationView.showDecrypted());			
		}
    }   
}