package mastermind.models;

public class Combination {

    private static final int NUMBEROFCOLORS = 4;
    protected Color[] colors;

	public Combination() {
        colors = new Color[NUMBEROFCOLORS];
    }

    public static int size() {
        return NUMBEROFCOLORS;
    }

    public void asignColors(String combination) {
        for (int i = 0; i < Combination.size(); i++) {
            this.colors[i] = Color.valueOf(combination.charAt(i));
        }
    }

    public String getCombination() {
        String combination = "";
        for (int i = 0; i < Combination.size(); i++) {
            combination += colors[i].getColor();						            
        }
        return combination;
    }

    public char getColor(int position) {
        return this.colors[position].getColor();
    }
}