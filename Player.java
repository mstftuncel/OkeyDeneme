

import java.util.List;

public class Player {
   private String name;
   private Integer rowSeat;
   private List<Stone> playerStone;
   private Integer point;
   
    public Integer getRowofSeat() {
        return rowSeat;
    }

    public void setRowofSeat(Integer rowSeat) {
        this.rowSeat = rowSeat;
    }

    public Player(String name, List<Stone> playerStone, Integer rowSeat) {
        this.name = name;
        this.playerStone = playerStone;
        this.rowSeat = rowSeat;
    }

    public Player() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public List<Stone> getPlayerStone() {
        return playerStone;
    }

    public void setPlayerStone(List<Stone> playerStone) {
        this.playerStone = playerStone;
    }
}
