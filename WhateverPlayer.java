import java.util.Random;


class WhateverPlayer implements Player{
    Random rand=new Random();
    /**this method play a move of the whatever player, its strategy details at the readme file
     * @param board gets the current board
     * @param mark gets the mark to put on the board at this turn*/

    @Override
    public void playTurn(Board board, Mark mark){
        int boardSize=board.getSize();
        int row=rand.nextInt(boardSize);
        int col=rand.nextInt(boardSize);
        while(!board.putMark(mark,row,col)){
            row=rand.nextInt(boardSize);
            col=rand.nextInt(boardSize);
        }

    }
}
