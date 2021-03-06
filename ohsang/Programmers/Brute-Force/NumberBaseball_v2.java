class Solution {
    public int solution(int[][] baseball) {
        int result = 0;
        boolean data[] = new boolean[1000];
        for(int i=0; i<data.length; i++) {
            String n = Integer.toString(i);
            if(n.length() < 3) {data[i] = true;}
            else if(n.charAt(0)=='0' || n.charAt(1)=='0' || n.charAt(2)=='0') {data[i] = true;}
            else if(n.charAt(0) == n.charAt(1) || n.charAt(0) == n.charAt(2) || n.charAt(1) == n.charAt(2)) {data[i] = true;}
        }
        for(int i=0; i<baseball.length; i++) {
            int answer = baseball[i][0];
            int s = baseball[i][1];
            int b = baseball[i][2];

            for(int j=123; j<=987; j++) {
                if(!data[j]) {
                    int[] sbData = judge(Integer.toString(j), Integer.toString(answer));
                    if(sbData[0] != s || sbData[1] != b) {data[j] = true;}
                }
            }
        }
        for(int i=0; i<data.length; i++) {
            if(!data[i]) {result++;}
        }
        return result;
    }
    int[] judge(String n1, String n2) {
        int s = 0;
        int b = 0;
        char[] c = n2.toCharArray();
        for(int i=0; i<3; i++) {
            if(n1.indexOf(c[i]) >= 0) {
                if(n1.charAt(i) == c[i]) {s++;}
                else {b++;}
            }
        }
        return new int[] {s, b};
    }
}