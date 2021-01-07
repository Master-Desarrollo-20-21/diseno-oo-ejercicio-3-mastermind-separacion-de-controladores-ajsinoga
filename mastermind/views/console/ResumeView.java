package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.views.Message;
import mastermind.utils.YesNoDialog;

public class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
			resumeController.resume();
		} else {
			resumeController.next();
		}
        return newGame;
	}
}