package mastermind.models;

import java.util.Random;

public class SecretCombination extends Combination {    

	public SecretCombination() {
        super();    
        this.autoGenerate();    
    }

    public void autoGenerate() {
        String proposal = "";        
        Color candidate;      
        do {                
            candidate = getCandidate();            
            if (isUnique(candidate, proposal)) {
                proposal = proposal + candidate.getColor();
            }                
        } while (proposal.length() != Combination.size());

        super.asignColors(proposal);
    }
    
    private Color getCandidate() {
        Random random = new Random(); 
        return Color.values()[random.nextInt(Color.values().length)];
    }

    private boolean isUnique(Color candidate, String proposal) {
        for (int i = 0; proposal.length() > 0 && i < proposal.length(); i++) {
            if (candidate.getColor() == proposal.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}