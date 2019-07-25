


import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class PlayerRun implements PlayerFace {

    @Override
    public Player finish(List<Player> players, Stone okeyStone) {
    	//Oyuncuda okey var mi diye bakilir
        //Taslari karistir
    	
        for (int i = 0; i < players.size(); i++) {
            List<Stone> stones = players.get(i).getPlayerStone();

          //Fake okey gercek okey olursa
            for (Stone stone : stones) {
                if (stone.color == "Fake-Okey") {
                    stone.setTrueValue(okeyStone.getTrueValue());
                }
            }

            ///Taslari gercek degerine göre ardisik sirala
            Collections.sort(stones, new Comparator<Stone>() {
                @Override
                public int compare(final Stone object1, final Stone object2) {
                    return object1.trueValue.compareTo(object2.trueValue);
                }
            });

            System.out.println(players.get(i).getName() + " Taslari" + "\n");

            players.get(i).setPoint(calculatePoint(stones, okeyStone));

        }
       
        Collections.sort(players, new Comparator<Player>() {
                @Override
                public int compare(final Player playerOne, final Player playerTwo) {
                    return playerOne.getPoint().compareTo(playerTwo.getPoint());
                }
        });
        
        return players.get(0);
    }
    
    public Integer calculatePoint(List<Stone> playerStone, Stone okeyStone){
        Integer point = 0;
        for (int i = 1; i < playerStone.size(); i++) {
            Integer sequential = 0;
            //Tas Rengi ayni ve 1 fazlasi ise
            //ardýþýk 2 lisi varsa
            if(playerStone.get(i-1).value.equals(playerStone.get(i).value - 1) && playerStone.get(i-1).color.equals(playerStone.get(i).color) && !playerStone.get(i-1).value.equals(okeyStone.value)){
                sequential++;
            }
            else{
                sequential = 0;
            }
            if(sequential.equals(1)){
                point++;
                sequential = 0;
            }
            //okeyi varsa
            if (playerStone.get(i-1).value.equals(okeyStone.value)) {
                point = point + 2;
            }
            System.out.println(playerStone.get(i).color + " " + playerStone.get(i).value + "\n");
         
          
            
        }
        System.out.println("Alinan puan:" + point);
        return point;
    }

}
