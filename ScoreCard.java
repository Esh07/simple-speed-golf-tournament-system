public class ScoreCard {
    private String name;
    private double time;
    private Course course;
    private int[] holeScores;

    ScoreCard(String n, Course c, double t, int[] ss) {
        this.name = n;
        this.course = c;
        this.time = t;
        this.holeScores = ss;
    }

    public String getName() {
        return name;
    }

    public double getRawTime() {
        return time;
    }

    public int[] getScore() {
        return holeScores;
    }

    public double getAdjustedTime() {
        double adjusttime = 0;
        for (double i : holeScores) {
            adjusttime += i;
        }
        adjusttime += getRawTime();
        return adjusttime;
    }

    @Override
    public String toString() {
        StringBuilder hs = new StringBuilder();
        for (int h : holeScores) {
            hs.append(" " + h);
        }

        return " " + "(" + getRawTime() + ")" + " " + hs + " "
                + "  AdjustedTime: " + getAdjustedTime();
    }
}
