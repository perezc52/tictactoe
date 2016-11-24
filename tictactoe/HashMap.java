/*
 * Constructor: takes all the userName, Player objects
 * Allows a display of all the player history with HashMap<Player, username>
 * verify if the user is a registered player
 *
 */
package tictactoe;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author usha
 * @param <K>
 */
public class HashMap< Player ,String> {


    
    String username;
    ArrayList <Player> playerList;
    //Object registerPlayer;
    Player player;
    
HashMap map = new HashMap(player, username);  
Set set = map.entrySet();
Iterator i= set.iterator();

HashMap(Player player,String username){
player.getClass();
username = (String) player;

}  

   
/*if new user, add to the player arraylist*/
void addToArrayList(Player player){
playerList.add(player);
map.put(player, username);
}

/*check if loged in user exsist, if not return false*/
public boolean isEmpty (Player player){
i.equals(player);
 return true;
}


/*print out the map*/
public Set entrySet(){
while (i.hasNext()){
Map.Entry me = (Map.Entry)i.next();
System.out.print(me.getKey()+":");
System.out.println(me.getValue());
}
return set;
}

/*change increment of wins for a returning user 
public int getNewLoss(Player player){
}*/

/*change increment of losses for a returning user 
public int getNewWins(Player player){
}*/

/*clear all map values*/
public void clear ( ArrayList <Player> playerList){
   int size =  playerList.size();
if (size >= 10){
map.clear(playerList);
}
}

/*put key with it's corresponding value*/
public void put (Player player, String username){
while( (i.hasNext()) != true){
map.player= this.player;
map.username= this.username;
}
}




}