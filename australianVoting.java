import java.util.*;

public class australianVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        sc.nextLine(); // consume newline
        
        for (int t = 0; t < numCases; t++) {
            if (t > 0) {
                System.out.println(); // blank line between cases
            }
            
            // Read number of candidates
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            // Read candidate names
            String[] candidates = new String[n];
            for (int i = 0; i < n; i++) {
                candidates[i] = sc.nextLine();
            }
            
            // Read ballots
            List<int[]> ballots = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) break;
                
                String[] nums = line.trim().split("\\s+");
                int[] ballot = new int[n];
                for (int i = 0; i < n; i++) {
                    ballot[i] = Integer.parseInt(nums[i]) - 1; // convert to 0-based index
                }
                ballots.add(ballot);
            }
            
            // Process ballots
            boolean[] eliminated = new boolean[n];
            while (true) {
                // Count votes for current round
                int[] votes = new int[n];
                for (int[] ballot : ballots) {
                    for (int choice : ballot) {
                        if (!eliminated[choice]) {
                            votes[choice]++;
                            break;
                        }
                    }
                }
                
                // Find min and max votes
                int minVotes = Integer.MAX_VALUE;
                int maxVotes = 0;
                for (int i = 0; i < n; i++) {
                    if (!eliminated[i]) {
                        minVotes = Math.min(minVotes, votes[i]);
                        maxVotes = Math.max(maxVotes, votes[i]);
                    }
                }
                
                // Check if we have a winner
                if (maxVotes > ballots.size() / 2) {
                    for (int i = 0; i < n; i++) {
                        if (!eliminated[i] && votes[i] == maxVotes) {
                            System.out.println(candidates[i]);
                            break;
                        }
                    }
                    break;
                }
                
                // Eliminate candidates with minimum votes
                boolean allTied = true;
                for (int i = 0; i < n; i++) {
                    if (!eliminated[i] && votes[i] == minVotes) {
                        eliminated[i] = true;
                        allTied = false;
                    }
                }
                
                // If all remaining candidates are tied
                if (allTied) {
                    for (int i = 0; i < n; i++) {
                        if (!eliminated[i]) {
                            System.out.println(candidates[i]);
                        }
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}
