package Util;

public class Jugador {
    String username;
    String gamesWon;
    String gamesPlayed;


    public Jugador(String username, String gamesWon, String gamesPlayed) {
        this.username = username;
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
    }


    public String getUsername() {
        return username;
    }


    public String getGamesWon() {
        return gamesWon;
    }


    public String getGamesPlayed() {
        return gamesPlayed;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setGamesWon(String gamesWon) {
        this.gamesWon = gamesWon;
    }


    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }


}
