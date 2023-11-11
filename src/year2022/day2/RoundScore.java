package year2022.day2;

public class RoundScore {
    Player player1;
    Player player2;

    private static final int LOSE = 0;
    private static final int DRAW = 3;
    private static final int WIN = 6;

    public RoundScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void calculateWinner() {
        if (player1.gameMove.getScore() == player2.gameMove.getScore()) {
            setDraw();
        } else if (player1.gameMove.compareTo(player2.gameMove) > 0) {
            setWinner(player1);
            setLoser(player2);
        } else {
            setWinner(player2);
            setLoser(player1);
        }
    }

    private void setDraw() {
        player1.roundScore = player1.gameMove.getScore() + DRAW;
        player2.roundScore = player2.gameMove.getScore() + DRAW;
    }

    private void setWinner(Player winningPlayer) {
        winningPlayer.roundScore = winningPlayer.gameMove.getScore() + WIN;
    }

    private void setLoser(Player losingPlayer) {
        losingPlayer.roundScore = losingPlayer.gameMove.getScore() + LOSE;
    }
}
