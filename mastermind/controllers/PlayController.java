package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class PlayController extends Controller {

	public PlayController(Game game, State state) {
        super(game, state);
    }
    
    public void saveCombination(String read) {
		this.game.saveCombination(read);
	}

	public void verifyProposal() {
		this.game.verifyProposal();
		if (isGameFinished()) {
			this.state.next();
		}
    }
    
    public int getCurrentAttempt() {
		return this.game.getCurrentAttempt();
	}

	public int numberOfBlacksAttempt(int i) {
		return this.game.numberOfBlacksAttempt(i);
	}

	public int numberOfWhitesAttempt(int i) {
		return this.game.numberOfWhitesAttempt(i);
	}

	public boolean isGameFinished() {
		if (this.isWinner()) {
			return true;
		} 
		if (this.isCompleted()) {
			return true;
		}
		return false;
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isCompleted() {
		return this.game.isCompleted();
	}  

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}
