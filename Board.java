class Board {
    public static final int DEFAULT_SIZE=4;
    private Mark[][] board;


    private int size;

    public Board() {
        /* initialize board by default size*/
        this.Board_construct(DEFAULT_SIZE);
    }

    public Board(int size) {
        /* initialize board by given size*/
        this.Board_construct(size);
    }

    /** the board constructor method initializes 2d array of marks, to have blank mark on each coordinate
     * according to given size of board side
     * @param size the size of the board **/

    private void Board_construct(int size){
        this.size = size;
        this.board = new Mark[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }
    public int getSize() {
        /*returns the size of the board*/
        return this.size;
    }

    public Mark[][] getBoard() {
        /*returns the 2d board array*/
        return this.board;
    }

    /**this method return true if the given coordinate are invalid and false otherwise
     * @param row number of row to check if invalid
     * @param col number of col to check if invalid*/
    private boolean coordsOutOfRange(int row, int col){
        return (row<0||row>this.size-1||col<0||col>this.size-1);
    }

    /**this method return puts the given mark at the coordinate (row,col) if valid and available and returns
     *  true, otherwise return false
     * @param mark the mark to put at the coordinate
     * @param row number of row to put mark at
     * @param col number of col to put mark at
     * @return true if succeeded and put mark, false otherwise*/
    public boolean putMark(Mark mark, int row, int col) {
        if (coordsOutOfRange(row,col)){
            return false;
        }
        else if (this.getMark(row,col)==Mark.BLANK){
            this.board[row][col]=mark;
            return true;
        }
        return false;

    }

    /**this method return true if the given coordinate are invalid and false otherwise
     * @param row number of row to get its mark
     * @param col number of col to get its mark
     * @return the mark at the given coordinate (row, col), if invalid or empty, returns BLANK*/
    public Mark getMark(int row, int col) {
        if (this.coordsOutOfRange(row,col)){
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

}
