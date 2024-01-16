class CleverPlayer implements Player{

    /**this method play a move of the clever player, its strategy details at the readme file
     * @param board gets the current board
     * @param mark gets the mark to put on the board at this turn*/
    @Override
    public void playTurn(Board board, Mark mark){
        int currentRow=0;
        int currentCol=0;
        while (!board.putMark(mark,currentRow,currentCol)){
            int boardSize=board.getSize();
            currentCol++;
            if(currentRow>=boardSize){
                currentRow=0;
                currentCol=0;
            }
            if(currentCol>=boardSize){
                currentCol=0;
                currentRow++;
            }
        }

    }
}
