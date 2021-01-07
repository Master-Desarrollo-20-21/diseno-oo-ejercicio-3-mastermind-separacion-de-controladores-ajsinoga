package mastermind.views;

import mastermind.models.Error;
import mastermind.utils.Console;

public class ErrorView {
    
    private static final String[] MESSAGES = { 
		"Wrong proposed combination length",
		"Wrong colors, they must be: rbygop",
	    "Wrong colors, duplicated color is not allowed" };

	private Error error;

	public ErrorView(Error error) {
		this.error = error;
	}

	public void writeln() {
		if (!error.isNull()){
			Console.getInstance().outln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}
}