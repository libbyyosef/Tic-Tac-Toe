import java.util.Scanner;

class HumanPlayer implements Player {
    private static final String INPUT_MSG = "Player%s ,type coordinates: ";
    private static final String INVALID_INPUT_MSG = "Invalid coordinates, type again: ";
    private static final int NUM_OF_COORDINATES = 2;
    private final Scanner scanner;

    public HumanPlayer() {
        /* human player constructor*/
        this.scanner = new Scanner(System.in);
    }

    /** this method returns true if there are more or less than 2 chars at the input, false otherwise*/
    private boolean lengthOfInput(String input) {
        return (input.length() != NUM_OF_COORDINATES);
    }

    /**
     * this method play a move of the human player, its strategy details at the readme file
     *
     * @param board gets the current board
     * @param mark  gets the mark to put on the board at this turn
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        System.out.println(String.format(INPUT_MSG, mark));
        String input = this.scanner.nextLine();
        while (this.lengthOfInput(input)) {
            System.out.println(INVALID_INPUT_MSG);
            input = this.scanner.nextLine();
        }
        int row = Character.getNumericValue(input.charAt(0));
        int col = Character.getNumericValue(input.charAt(1));
        while (!(board.putMark(mark, row, col))) {
            System.out.println(INVALID_INPUT_MSG);
            input = this.scanner.nextLine();
            while (this.lengthOfInput(input)) {
                System.out.println(INVALID_INPUT_MSG);
                input = this.scanner.nextLine();
            }
            row = Character.getNumericValue(input.charAt(0));
            col = Character.getNumericValue(input.charAt(1));
        }

    }
}
