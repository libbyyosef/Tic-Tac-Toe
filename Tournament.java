class Tournament {
    private static final String END_TOURNAMENT_MSG="Player %d, %s won: %d rounds";
    private static final String TIES="Ties: %d";
    private static final String CHOOSE_PLAYER_MSG="Choose a player, and start again\nThe players: [human, " +
            "clever, whatever, genius]";
    private final int rounds;
    private int numOfTies=0;
    private final Renderer renderer;
    private final Player[] players;
    private int player1Wins=0;
    private int player2Wins=0;

    private int numOfGame=0;
    private Player playerX;
    private Player playerO;

    private Boolean evenRound;

    /** the tournament constructor
     * @param rounds number of rounds to play
     * @param players array of 2 players
     * @param renderer determent if the board will be shown*/

    public Tournament(int rounds, Renderer renderer, Player[] players){
        this.rounds=rounds;
        this.renderer=renderer;
        this.players=players;

    }
    /** this method sets the X and O players according to the number of games already been played*/
    private void restartPlayTournament(){
        if(numOfGame%2==1){
            this.evenRound=false;
            this.playerX=this.players[0];
            this.playerO=this.players[1];
        }
        else{
            this.evenRound=true;
            this.playerX=this.players[1];
            this.playerO=this.players[0];
        }

    }

    /** this method update the number of winning to the winner, or the ties if there is a tie
     *
     * @param mark
     according to the mark that was return from the game, update points to the relevant player*/
    private void updateWinners(Mark mark){
        if (mark==Mark.X){
            if (!this.evenRound){
                this.player1Wins++;
            }
            else {
                this.player2Wins++;
            }
        }
        else if(mark==Mark.O){
            if(this.evenRound){
                this.player1Wins++;
            }
            else {
                this.player2Wins++;
            }
        }
        else {
            this.numOfTies++;
        }
    }

    /**this method play a full tournament until there is winner or a tie, switches the players marks each
     * round
     * @param size of the board to play on
     * @param winStreak number of marks in a row ot col or diagonal that provides a victory
     * @param playerNames array of players names
     */

    void playTournament(int size, int winStreak, String[] playerNames){
       this.numOfGame++;
       this.restartPlayTournament();
       while(this.numOfGame!=this.rounds+1){
           this.restartPlayTournament();
           Game game=new Game(playerX,playerO,size,winStreak,this.renderer);
           Mark mark=game.run();
           this.updateWinners(mark);
           System.out.println(String.format(END_TOURNAMENT_MSG,1,playerNames[0],this.player1Wins));
           System.out.println(String.format(END_TOURNAMENT_MSG,2,playerNames[1],this.player2Wins));
           System.out.println(String.format(TIES,this.numOfTies));
           this.numOfGame++;
       }
    }

    /** the main method gets variables from the command line and runs a full tournament according to the
     * input values it received
     * @param args array of rounds, board size, win streak, render target, player1, player2
     */

    public static void main(String[] args) {
        String [] playersNames={args[4],args[5]};
        RendererFactory rendererFactory=new RendererFactory();
        int rounds=Integer.parseInt(args[0]);
        int size=Integer.parseInt(args[1]);
        int winStreak=Integer.parseInt(args[2]);
        String targetRenderer=args[3];
        PlayerFactory playerFactory=new PlayerFactory();
        Player player1=playerFactory.buildPlayer(playersNames[0]);
        Player player2=playerFactory.buildPlayer(playersNames[1]);
        if (player1==null||player2==null){
            System.out.println(CHOOSE_PLAYER_MSG);
        }
        else{
            Player []players=new Player[]{player1,player2};
            Tournament tournament=new Tournament(rounds,rendererFactory.buildRenderer(targetRenderer,size),players);
            tournament.playTournament(size,winStreak,playersNames);
        }
    }
}





