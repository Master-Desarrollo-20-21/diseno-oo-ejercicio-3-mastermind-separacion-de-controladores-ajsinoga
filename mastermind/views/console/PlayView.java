package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.Message;

public class PlayView {

	void interact(PlayController playController) {		
		if (!playController.isCompleted()) {
			playController.saveCombination(new CombinationView(playController).read(Message.PROPOSE.getMessage()));
		}
		playController.verifyProposal();
		new ResultView(playController).showResult();													
	}	
}