class GeniusPlayer implements Player {
//    private int row = 0;
//    private int col = 1;

    /**this method play a move of the genius player, its strategy details at the readme file
     * @param board gets the current board
     * @param mark gets the mark to put on the board at this turn*/

    @Override
    public void playTurn(Board board, Mark mark) {
        int row=0;
        int col=1;
        int boardSize = board.getSize();

        while (!board.putMark(mark, row, col)) {
            if (row >= boardSize) {
                row = -1;
                col++;
            }
            row++;
            if (col >= boardSize) {
                row = 0;
                col = 0;
            }
        }
    }

}
