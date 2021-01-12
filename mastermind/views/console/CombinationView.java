package mastermind.views.console;

import mastermind.models.Combination;
import mastermind.controllers.Controller;
import mastermind.models.Color;
import mastermind.models.Error;
import mastermind.views.ErrorView;
import mastermind.utils.Console;

public class CombinationView {

    private Controller controller;

    public CombinationView(Controller controller) {
        this.controller = controller;
    }

    public String read(String title) {
        String proposal;
        Error error;

        do {
            proposal = Console.getInstance().readString(title);
            if (!isValidLength(proposal.length())) {
                error = Error.WRONG_LENGTH;
            } else if (!areValidColors(proposal)) {
                error = Error.INVALID_COLORS;
            } else if (isDuplicated(proposal)) {
                error = Error.DUPLICATED;
            } else {
                error = Error.NULL;
            }
            new ErrorView(error).writeln();
        } while (!error.isNull());

        return proposal;
    }

    private boolean isValidLength(int length) {
        if (length != Combination.size()) {
            return false;
        }
        return true;
    }

    private boolean areValidColors(String proposal) {
        for (char color : proposal.toCharArray()) {
            if (Color.valueOf(color) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicated(String proposal) {
        for (int i = 0; i < Combination.size(); i++) {
            if (proposal.indexOf(proposal.charAt(i)) != i) {
                return true;
            }
        }
        return false;
    }

    public String show(int attempt) {
        return this.controller.getProposalCombination(attempt).getCombination();
    }
}