package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class ResumeController extends Controller{

	public ResumeController(Game game, State state) {
        super(game, state);
	}

	public void resume() {
		this.game.reset();
		this.state.reset();
	}    

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}
