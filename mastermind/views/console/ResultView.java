package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.Message;
import mastermind.utils.Console;

public class ResultView {

    private PlayController playController;
    private CombinationView combinationView;
    private SecretCombinationView secretCombinationView;    

    public ResultView(PlayController playController) {
		this.playController = playController;
        this.combinationView = new CombinationView(playController);
        this.secretCombinationView = new SecretCombinationView(playController);        
    }
    
	public void showNumberOfAttempts() {
        Console.getInstance().outln("\n" + Integer.toString(this.playController.getCurrentAttempt()) + Message.ATTEMPS.getMessage());		
	}
    
    public void showResult() {   
        this.showNumberOfAttempts();
        Console.getInstance().outln(this.secretCombinationView.show()); 
        for (int i = 0; i < this.playController.getCurrentAttempt(); i++) {
            Console.getInstance().outln(this.combinationView.show(i)  + " --> " 
                        + this.playController.numberOfBlacksAttempt(i) + " blacks and " + this.playController.numberOfWhitesAttempt(i) + " whites");
        }
        if (this.playController.isWinner()) {
			Console.getInstance().outln(Message.WINNER.getMessage());;
		} else if (this.playController.isCompleted()) {
			Console.getInstance().outln(Message.LOOSER.getMessage());
			Console.getInstance().outln(Message.SECRET.getMessage() + this.secretCombinationView.showDecrypted());			
		}
    }   
}