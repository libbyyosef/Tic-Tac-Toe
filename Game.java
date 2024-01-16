public class Game {
    private static final int TOP_SIZE=9;
    private static final int BUTTOM_SIZE=2;
    private static final int DEFAULT_WINSTEAK=3;

    private int winSteak;
    private int size;
    private final Player playerX;
    private final Player playerO;
    private int numOfMoves = 0;

    private final Board board;
    private final Renderer renderer;

    /** the game constructor with default board size and winsteak values
     * @param playerX player with mark X
     * @param playerO player with mark O
     * @param renderer determent if the board will be shown*/

    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board();
        this.winSteak = DEFAULT_WINSTEAK;


    }

    /** the game constructor
     * @param playerX player with mark X
     * @param playerO player with mark O
     * @param renderer determent if the board will be shown
     * @param size the size of the board
     * @param winStreak the number of marks in a sequence that provides a victory*/
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.size = size;
        if (size < BUTTOM_SIZE || size > TOP_SIZE) {
            this.board = new Board();
        }
        else{
            this.board = new Board(this.size);
        }
        this.winSteak = winStreak;
        if (winStreak < BUTTOM_SIZE || winStreak > 9 || this.winSteak > this.size) {
            this.winSteak = this.board.getSize();
        }
    }

    public int getWinStreak() {
        /*returns number of wisteak*/
        return this.winSteak;
    }


    /**
     * the method check if there is a win of one of the players - according to its cols
     *
     * @param mark - according to a given mark (X OR O) the function checks if there is a streak of winStreak
     *             (number) of a given mark
     *             row and col - checks for specific location on the board if its start a sequence of victory
     * @return true if the mark-player won and got col streak, false otherwise
     **/


    private boolean isColStreak(Mark mark, int row, int col) {
        Mark[][] board1 = this.board.getBoard();
        for (int i = 0; i < this.winSteak; i++) {
            if (row + i >= this.size) {
                return false;
            }
            if (board1[row + i][col] != mark) {
                return false;
            }
        }
        return true;
    }

    /**
     * the method check if there is a win of one of the players - according to its rowas
     *
     * @param mark - according to a given mark (X OR O) the function checks if there is a streak of winStreak
     *             (number) of a given mark
     *             row and col - checks for specific location on the board if its start a sequence of victory
     * @return true if the mark-player won and got row streak, false otherwise
     **/
    private boolean isRowStreak(Mark mark, int row, int col) {
        Mark[][] board1 = this.board.getBoard();
        for (int i = 0; i < this.winSteak; i++) {
            if (col + i >= this.board.getSize()) {
                return false;
            }
            if (board1[row][col + i] != mark) {
                return false;
            }
        }
        return true;
    }


    /**
     * the method check if there is a win of one of the players - according to its right diagonal
     *
     * @param mark - according to a given mark (X OR O) the function checks if there is a streak of winStreak
     *             (number) of a given mark
     *             row and col - checks for specifit location on the board if its start a sequence of victory
     * @return true if the mark-player won and got right diagonal streak, false otherwise
     **/
    private boolean isDiagonalRightStreak(Mark mark, int row, int col) {
        Mark[][] board1 = this.board.getBoard();

        for (int i = 0; i < this.winSteak; i++) {
            if (row + i >= this.size) {
                return false;
            }
            if (col + i >= this.size) {
                return false;
            }
            if (board1[row + i][col + i] != mark) {
                return false;
            }
        }
        return true;
    }

    /**
     * the method check if there is a win of one of the players - according to its left diagonal
     *
     * @param mark - according to a given mark (X OR O) the function checks if there is a streak of winStreak
     *             (number) of a given mark
     *             row and col - checks for specifit location on the board if its start a sequence of victory
     * @return true if the mark-player won and got left diagonal streak, false otherwise
     */

    private boolean isDiagonalLeftStreak(Mark mark, int row, int col) {
        Mark[][] board1 = this.board.getBoard();

        for (int i = 0; i < this.winSteak; i++) {
            if (row + i >= this.size) {
                return false;
            }
            if (col - i < 0) {
                return false;
            }
            if (board1[row + i][col - i] != mark) {
                return false;
            }
        }
        return true;
    }


    /**
     * a combination of all the possibility of winning, checks if there is a win to one of the player - by a
     * given mark and specific location
     *
     * @param mark the winner mark
     * @return true if the mark-player won, false otherwise
     */
    private boolean isWinner(Mark mark, int row, int col) {
        return (isRowStreak(mark, row, col) || isColStreak(mark, row, col) || isDiagonalLeftStreak(mark, row,
                col) || isDiagonalLeftStreak(mark, row, col));
    }


    /**
     * for each loaction on the board, we check if it starts a winStreak
     *
     * @return Mark of the winner or BLANK if there is a tie
     */


    private Mark checkStreakWinner() {
        Mark[][] board1 = this.board.getBoard();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (board1[i][j] != Mark.BLANK) {
                    if (isWinner(board1[i][j], i, j)) {
                        return board1[i][j];
                    }
                }
            }
        }
        return Mark.BLANK;
    }

    /**
     * if the players already played board size multiply board size moves, it means that there is a tie
     * because
     * the
     * board is full and there is no winner
     *
     * @return true if there is a tie, false otherwise
     */
    private boolean isTie() {
        return (this.numOfMoves >= this.size * this.size) ;
         }

    /** this method runs one game from start to end and returns the winner's mark or BLANK if it is a tie
     *
     * @return the winner's mark or BLANK if it is a tie
     */
    public Mark run() {

        this.renderer.renderBoard(this.board);
        Mark winnerMark = this.checkStreakWinner();
        while (winnerMark == Mark.BLANK) {
            if (this.isTie()) {
                return Mark.BLANK;
            }
            this.playerX.playTurn(this.board, Mark.X);
            this.renderer.renderBoard(this.board);
            this.numOfMoves++;
            winnerMark = this.checkStreakWinner();
            if (winnerMark!=Mark.BLANK){
                return winnerMark;
            }
            this.playerO.playTurn(this.board, Mark.O);
            this.renderer.renderBoard(this.board);
            this.numOfMoves++;
            winnerMark = this.checkStreakWinner();
        }
        return winnerMark;
    }
}



