package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;

    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    public Boolean isInFavorOf(Character c) {
        //Spots on the tic-tac-toe board.
        //  0    1    2
//      0  {'X', 'O', 'X'},
//      1  {'O', 'O', 'X'},
//      2  {'X', 'X', 'O'}
        Character topLeft = board[0][0];
        Character topMiddle = board[0][1];
        Character topRight = board[0][2];
        Character middleLeft = board[1][0];
        Character middleMiddle = board[1][1];
        Character middleRight = board[1][2];
        Character bottomLeft = board[2][0];
        Character bottomMiddle = board[2][1];
        Character bottomRight = board[2][2];

        //rows, columns, diagonals to win
        Character[] topRow = new Character[]{topLeft, topMiddle, topRight};
        Character[] middleRow = new Character[]{middleLeft, middleMiddle, middleRight};
        Character[] bottomRow = new Character[]{bottomLeft, bottomMiddle, bottomRight};
        Character[] leftColumn = new Character[]{topLeft, middleLeft, bottomLeft};
        Character[] middleColumn = new Character[]{topMiddle, middleMiddle, bottomMiddle};
        Character[] rightColumn = new Character[]{topRight, middleRight, bottomRight};
        Character[] leftDiagonal = new Character[]{topLeft, middleMiddle, bottomRight};
        Character[] rightDiagonal = new Character[]{topRight, middleMiddle, bottomLeft};


        if (checkedRow(topRow, c)) {
            return true;
        }
        if (checkedRow(middleRow, c)) {
            return true;
        }
        if (checkedRow(bottomRow, c)) {
            return true;
        }
        if (checkedRow(leftColumn, c)) {
            return true;
        }
        if (checkedRow(middleColumn, c)) {
            return true;
        }
        if (checkedRow(rightColumn, c)) {
            return true;
        }
        if (checkedRow(leftDiagonal, c)) {
            return true;
        }
        if (checkedRow(rightDiagonal, c)) {
            return true;
        }

        return false;
    }

        public Boolean checkedRow(Character[] checkArray, Character letter) {
            boolean result = true;
        for (int i = 0; i < checkArray.length; i++) {
                if (!(checkArray[i] == letter)) {
                    result = false;
                }
            }
            return result;
        }

    public Boolean isInFavorOfX(){
        return isInFavorOf('X');}

    public Boolean isInFavorOfO() {
        return isInFavorOf('O');
    }

    public Boolean isTie() {
        return !isInFavorOf('O') && !isInFavorOf('X');
    }

    public String getWinner() {
        if (isInFavorOf('X')){
            return "X";
        } else if (isInFavorOf('O')){
            return "O";
        }
        return "";
    }

}
