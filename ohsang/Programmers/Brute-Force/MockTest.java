import java.util.*;

public class Test {

    static class Student {
        private int[] ansPattern;
        private int score;

        public Student(int[] ansPattern) {
            this.ansPattern = ansPattern;
            this.score = 0;
        }

        public int[] getAnsPattern() {
            return ansPattern;
        }

        public void addScore() {
            score++;
        }

        public int getScore() {
            return score;
        }
    }

    public static int[] solution(int[] answers) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Integer> ansList = new ArrayList<>();

        students.add(new Student(new int[]{1,2,3,4,5}));
        students.add(new Student(new int[]{2,1,2,3,2,4,2,5}));
        students.add(new Student(new int[]{3,3,1,1,2,2,4,4,5,5}));

        int max = 0;
        for(int i=0; i<students.size(); i++) {
            // grading score.
            for(int j=0; j<answers.length; j++) {
                int ansPattSize = students.get(i).getAnsPattern().length;
                int ansIndex = ((j+1)%ansPattSize == 0) ? ansPattSize-1 : (j+1)%ansPattSize-1;
                if(answers[j] == students.get(i).getAnsPattern()[ansIndex]) {
                    students.get(i).addScore();
                }
            }

            // select top scorer.
            if(students.get(i).getScore() > max) {
                max = students.get(i).getScore();
                ansList.clear();
                ansList.add(i+1);
            } else if(students.get(i).getScore() == max) {
                ansList.add(i+1);
            }
        }

        Collections.sort(ansList);
        int[] ansArray = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5}))); //1
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2}))); //123
    }
}