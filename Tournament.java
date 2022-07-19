import java.util.ArrayList;

public class Tournament {
    private Course course;
    private ScoreCard[] scores;

    int sizeOfLongCharWord = 0;
    int lengthRawTime = 0;

    Tournament(Course c, ScoreCard[] ps) {
        this.course = c;
        this.scores = ps;
    }

    public int highCharLength() {
        ArrayList<String> names = new ArrayList<String>();
        names.add(course.getCourseName());
        for (ScoreCard sc : scores) {
            names.add(sc.getName());
        }
        // System.out.println(names);

        for (String n : names) {

            if (!(n.length() < 0) || !n.equals(null)) {
                if (n.length() > sizeOfLongCharWord) {
                    sizeOfLongCharWord += n.length();
                    sizeOfLongCharWord++;
                }
            } else {
                sizeOfLongCharWord = course.getCourseName().length();
            }
        }
        return sizeOfLongCharWord;
    }

    public int lengthOftime() {
        for (ScoreCard sc : scores) {
            int lengthOfRawTime = String.valueOf(sc.getRawTime()).length();
            if (lengthOfRawTime > lengthRawTime) {
                lengthRawTime += lengthOfRawTime + 5;
            }
        }
        return lengthRawTime;
    }

    public String declareWinner() {
        String winner = "";
        double temp;
        for (int i = 0; i < scores.length - 1; i++) {
            ScoreCard[] sc = scores;
            temp = Double.valueOf(sc[i].getAdjustedTime());
            if (sc[i + 1].getAdjustedTime() < temp) {
                temp = sc[i + 1].getAdjustedTime();
                winner = sc[i + 1].getName();
            }
        }
        return "The winnder is: " + winner;
    }

    @Override
    public String toString() {

        // System.out.println(highCharLength());
        // System.out.println(lengthOftime());
        System.out.println(
                course.getCourseName() + String.format("%-" + lengthOftime() + "s", " ") + course.toString() + "\n");
        for (ScoreCard s : scores) {

            System.out.println(String.format("%-" + highCharLength() + "s", s.getName()) + s.toString());
        }
        return "";
    }

}
