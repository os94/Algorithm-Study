import java.util.*;

public class Test {

    public static int solution(String begin, String target, String[] words) {
        String[] nodes = new String[words.length+1];
        boolean[][] edge = new boolean[words.length+1][words.length+1];
        boolean[] visited = new boolean[words.length+1];
        Queue<Integer> queue = new LinkedList<>();
        int wordLength = begin.length();
        int dest = 0;
        int distance = 0;

        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // init nodes[]
        nodes[0] = begin;
        for(int i=0; i<words.length; i++) {
            nodes[i+1] = words[i];
            if(words[i].equals(target)) {
                dest = i+1;
            }
        }

        // connect edge
        for(int i=0; i<nodes.length-1; i++) {
            for(int j=i+1; j<nodes.length; j++) {
                int diff = 0;
                for(int k=0; k<wordLength; k++) {
                    if(nodes[i].charAt(k) != nodes[j].charAt(k)) {
                        diff++;
                    }
                }
                if(diff == 1) {
                    edge[i][j] = true;
                    edge[j][i] = true;
                }
            }
        }

        // bfs
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i=0; i<qSize; i++) {
                int curr = queue.remove();
                if(curr==dest) {
                    return distance;
                }
                for(int next=1; next<=words.length; next++) {
                    if(visited[next] || (!edge[curr][next])) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
            distance++;
        }

        return 0;
    }

    public static void main(String args[]) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); //4
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"})); //0
    }
}