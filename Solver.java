public class Solver {
    // find a solution to the initial board (using the A* algorithm)

    public Board initial;


    public Solver(Board initial) {
        if (initial.isGoal()) return;
        Board board = initial;
        while (!board.isGoal()) {
            for (Board b: board.neighbors()) {
                if (b.equals(board)) continue;
                board = b;
                break;
            }
        }


    }

    private class SearchNode implements Comparable < SearchNode > {
        Board board;
        private SearchNode previousNode;
        private int moves;
        private int priority;

        public SearchNode(Board board, int moves, SearchNode previousNode) {
            this.board = board;
            this.moves = moves;
            priority = moves + board.manhattan();
            this.previousNode = previousNode;
        }

        public int compareTo(SearchNode that) {
            if (this.priority < that.priority) return -1;
            if (this.priority > that.priority) return 1;
            if (this.board.equals(that.board)) return 0;
            return -1;
        }
    }
    
    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        int[] boardArray = arrayer(initial);
        int inversions = 0;

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = i + 1; j < boardArray.length; j++) {
                if (boardArray[i] != 0 && boardArray[j] != 0 && boardArray[i] > boardArray[j]) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0);
    }


    public int[] arrayer(Board Board) {
        int k = 0;
        int[] boardArray = new int[9];
        for (int i = 0; i < Board.tiles.length; i++) {
            for (int j = 0; j < Board.tiles[0].length; j++) {
                boardArray[k++] = Board.tiles[i][j];
            }
        }
        return boardArray;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) return -1
        return ;
    }

    // sequence of boards in a shortest solution; null if unsolvable using searchNode
    public Iterable < Board > solution() {
        if (!isSolvable()) return null;
        Stack<Board> boards = new Stack<Board>();
        SearchNode node = new SearchNode(initial, 0, null);
        SearchNode lastNode = node;
            
    }

}