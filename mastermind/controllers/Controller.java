package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.State;

public abstract class Controller {

	protected Game game;
	protected State state;

    Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}
	
	public void next() {
		this.state.next();
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

	public Combination getProposalCombination(int attempt) {
		return this.game.getProposalCombination(attempt);
	}

	public Combination RevealSecretCombination() {
		return this.game.RevealSecretCombination();
	}
}
