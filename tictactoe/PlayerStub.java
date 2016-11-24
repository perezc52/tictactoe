
package tictactoe;


public class PlayerStub {
    
    private String username;
    private int numOfWins;
    private int numOfLoss;
    private Double ratio;

    public PlayerStub() {
        username = null;
        numOfWins = 0;
        numOfLoss = 0;
        ratio = 0.0;
    }
    
    public PlayerStub(String username, int numOfWins, int numofLoss, Double ratio) {
        this.username = username;
        this.numOfWins = numOfWins;
        this.numOfLoss = numofLoss;
        this.ratio = ratio;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumofLoss() {
        return numOfLoss;
    }

    public void setNumofLoss(int numofLoss) {
        this.numOfLoss = numofLoss;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
    
    
}
