public class Player {




    private boolean gameOver = false;
    private String playerName;
    private Coordinates coordinates = new Coordinates(0, 0);
    private int playerHealth = 100;


    public Player(String playerName) {
        this.playerName = playerName;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void move() {


    }


    public String getPlayerName() {
        return playerName;
    }

    private void playerReset() {
        playerHealth = 100;
        gameOver = false;
    }

    public void takeDamage(int damage) {
        playerHealth -= damage;
        if (playerHealth <= 0) {
            gameOver = true;
        }



    }
    public boolean isGameOver() {
        return gameOver;
    }

}
