

public class PlayerFactory {
    public PlayerFactory(){}
    /** creates and returns a new 'type' player according to a given string, if there is typo mistake, returns
     * null*/
    Player buildPlayer(String type){
        Player player;

        switch (type.toUpperCase()){
            case "HUMAN":
                player=new HumanPlayer();
                break;
            case "WHATEVER":
                player=new WhateverPlayer();
                break;
            case "CLEVER":
                player=new CleverPlayer();
                break;
            case "GENIUS":
                player=new GeniusPlayer();
                break;
            default :
                return null;
        }
        return player;
    }
}


