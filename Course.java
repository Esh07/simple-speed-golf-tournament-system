import java.lang.StringBuilder;

public class Course {
    private String name;
    private int[] holes;
    private int coursePar;

    Course(String n, int[] h) {
        this.name = n;
        this.holes = h;
    }

    public String getCourseName() {
        return this.name;
    }

    public int getHolePar(int h) {
        return this.coursePar;
    }

    public int getCoursePar() {
        // System.out.println(holes.length);
        for (int i = 0; i < holes.length; i++) {
            coursePar += holes[i];
            // System.out.print(coursePar + " ");
        }
        return this.coursePar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int h : holes) {
            sb.append(" " + h);
        }
        return sb + " " + "  Par: " + getCoursePar();
    }
}
