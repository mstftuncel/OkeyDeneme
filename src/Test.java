
import java.util.*;

public class Test {

	public static void main(String[] args) {
		StoneRun s = new StoneRun();
		PlayerRun p = new PlayerRun();
		Stone okeyStone = null;
		Player player = new Player();
		List<Stone> stones = s.createStone();
		Collections.shuffle(stones);
		okeyStone = s.findOkey(stones);
		List<Player> players = s.shareStone(stones);
		player = p.finish(players, okeyStone);

		System.out.println("Potansiyel kazanacak : " + player.getName());
		System.out.println("Alinan puan : " + player.getPoint());

	}
}
