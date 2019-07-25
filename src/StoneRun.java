

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class StoneRun implements StoneFace {

    private Random random = new Random();
	private Integer okeyStone;


    //Taslari olustur
    @Override
    public List<Stone> createStone() {
        int numberofStone = 13;
        List<Stone> stones = new ArrayList<Stone>();
        List<String> colors = new ArrayList<String>();
        colors.add("Sari");
        colors.add("Mavi");
        colors.add("Siyah");
        colors.add("Kirmizi");
        int counter = 0;
        for (int i = 0; i <= 4; i++) {
            for (int k = 1; k <= numberofStone; k++) {
                if (i < 1) {
                    stones.add(new Stone(counter, "Sari", k));
                    stones.add(new Stone(counter, "Sari", k));
                    counter++;
                } else if (i < 2) {
                    stones.add(new Stone(counter, "Mavi", k));
                    stones.add(new Stone(counter, "Mavi", k));
                    counter++;
                } else if (i < 3) {
                    stones.add(new Stone(counter, "Siyah", k));
                    stones.add(new Stone(counter, "Siyah", k));
                    counter++;
                } else if (i < 4) {
                    stones.add(new Stone(counter, "Kirmizi", k));
                    stones.add(new Stone(counter, "Kirmizi", k));
                    counter++;
                }
            }

        }
        stones.add(new Stone(0, "Fake-Okey", 52));
        stones.add(new Stone(0, "Fake-Okey", 52));
        return stones;
    }

    // Oyunculara taslar dagitiliyor
    @Override
    public List<Player> shareStone(List<Stone> t) {

    
        List<Stone> partOne = t.subList(0, 15);
        List<Stone> partTwo = t.subList(15, 29);
        List<Stone> partThree = t.subList(29, 43);
        List<Stone> partFour = t.subList(43, 57);

        Player playerOne = new Player("PlayerOne", partOne, 1);
        Player playerTwo = new Player("PlayerTwo", partTwo, 2);
        Player playerThree = new Player("PlayerThree", partThree, 3);
        Player playerFour = new Player("PlayerFour", partFour, 4);
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(playerOne);
        playerList.add(playerTwo);
        playerList.add(playerThree);
        playerList.add(playerFour);

        return playerList;

    }

    @Override
    public Stone findOkey(List<Stone> t) {
        Stone stoneOkey = new Stone(0, "", 0);
        okeyStone = random.nextInt(53);
      //Fake Okey geldiginde fake okey gelmeyene kadar random sayi uret
        while (okeyStone == 52) {
            okeyStone = random.nextInt(53);
        }
        for (Stone stone : t) {
            if (Objects.equals(stone.trueValue, okeyStone)) {
                if (stone.value == 13) {
                    stoneOkey.setValue(1);
                    stoneOkey.setTrueValue(stone.trueValue - 12);
                    stoneOkey.setColor(stone.getColor());
                    System.out.println(stoneOkey.getColor() + " Okey tasi geldi: " + stoneOkey.getColor() + " " + stoneOkey.getValue().toString());
                } else{
                    stoneOkey.setValue(stone.getValue() + 1);
                    stoneOkey.setTrueValue(stone.getTrueValue() + 1);
                    stoneOkey.setColor(stone.getColor());
                }
            }

        }
        System.out.println("Okey: " + stoneOkey.getColor() + " " + stoneOkey.getValue().toString());

        return stoneOkey;
    }
}
