package Soccer_App;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        HashMap<String, Integer> teamPoints = new HashMap<>();
        
        // Check if file path is provided as argument
        if (args.length > 0) {
            try {
                File inputFile = new File(args[0]);
                scanner = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                System.err.println("Error: File '" + args[0] + "' not found.");
                return;
            }
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Enter match results (one per line). Enter 'done' when finished:");
        }
        
        // Read match results
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("done") || line.isEmpty()) {
                break;
            }
            processMatch(line, teamPoints);
        }
        
        // Display rankings
        displayRankings(teamPoints);
        scanner.close();
    }
    
    private static void processMatch(String matchResult, HashMap<String, Integer> teamPoints) {
        try {
            // Split by comma to get both teams
            String[] teams = matchResult.split(",");
            if (teams.length != 2) {
                System.out.println("Invalid input format: " + matchResult);
                return;
            }
            
            // Parse team1
            String team1Data = teams[0].trim();
            if (team1Data.isEmpty() || team1Data.lastIndexOf(' ') == -1) {
                System.out.println("Invalid team1 format: " + matchResult);
                return;
            }
            String[] team1Parts = team1Data.split("\\s+");
            if (team1Parts.length < 2) {
                System.out.println("Invalid team1 format: " + matchResult);
                return;
            }
            int team1Score = Integer.parseInt(team1Parts[team1Parts.length - 1]);
            String team1Name = team1Data.substring(0, team1Data.lastIndexOf(' ')).trim();
            
            // Parse team2
            String team2Data = teams[1].trim();
            if (team2Data.isEmpty() || team2Data.lastIndexOf(' ') == -1) {
                System.out.println("Invalid team2 format: " + matchResult);
                return;
            }
            String[] team2Parts = team2Data.split("\\s+");
            if (team2Parts.length < 2) {
                System.out.println("Invalid team2 format: " + matchResult);
                return;
            }
            int team2Score = Integer.parseInt(team2Parts[team2Parts.length - 1]);
            String team2Name = team2Data.substring(0, team2Data.lastIndexOf(' ')).trim();
            
            // Calculate points
            int team1Points = 0;
            int team2Points = 0;
            
            if (team1Score > team2Score) {
                team1Points = 3;  // team1 wins
                team2Points = 0;  // team2 loses
            } else if (team1Score < team2Score) {
                team1Points = 0;  // team1 loses
                team2Points = 3;  // team2 wins
            } else {
                team1Points = 1;  // draw
                team2Points = 1;  // draw
            }
            
            // Update team points
            teamPoints.put(team1Name, teamPoints.getOrDefault(team1Name, 0) + team1Points);
            teamPoints.put(team2Name, teamPoints.getOrDefault(team2Name, 0) + team2Points);
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format: " + matchResult);
        } catch (Exception e) {
            System.out.println("Error processing match: " + matchResult);
        }
    }
    
    private static void displayRankings(HashMap<String, Integer> teamPoints) {
        // Convert to list for sorting
        ArrayList<Map.Entry<String, Integer>> teamList = new ArrayList<>(teamPoints.entrySet());
        
        // Sort by points (descending), then by name (ascending)
        teamList.sort((a, b) -> {
            int pointComparison = b.getValue().compareTo(a.getValue());
            if (pointComparison != 0) {
                return pointComparison;
            }
            return a.getKey().compareTo(b.getKey());
        });
        
        // Display rankings (dense ranking: 1, 2, 2, 3, 3)
        int currentRank = 0;
        Integer previousPoints = null;

        for (Map.Entry<String, Integer> entry : teamList) {
            String teamName = entry.getKey();
            int points = entry.getValue();
            
            // Increase rank only when points change
            if (previousPoints == null || points != previousPoints) {
                currentRank++;
            }
            
            String pointsText = (points == 1) ? "pt" : "pts";
            System.out.println(currentRank + ". " + teamName + ", " + points + " " + pointsText);
            
            previousPoints = points;
        }
    }
}
