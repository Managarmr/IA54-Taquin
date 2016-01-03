package utbm.ia54.projet.util;

/**
 * @class NPuzzleUtils 
 */
public class EcoNPuzzleUtils {

	// Attributes
	private static int size;
	private static int[][] board;
	private static int[][] agress;
	private static boolean init = false;
	private static int leader;
	private static int blankTile;
	
	// Constructor
	public static void init(int size) {
		 EcoNPuzzleUtils.size = size;
		 EcoNPuzzleUtils.board = new int[size][size];
		 EcoNPuzzleUtils.agress = new int[size][size];
		 EcoNPuzzleUtils.leader = size;
		 EcoNPuzzleUtils.blankTile = size*size;
		 EcoNPuzzleUtils.init = true;
	}

	// Getter & Setter
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		EcoNPuzzleUtils.size = size;
	}

	public static int[][] getBoard() {
		return board;
	}

	public static int getBoard(int x, int y) {
		return board[x][y];
	}
	
	public static int getBoard(int num) {
		int x = num%getSize();
		int y = (int) Math.floor(num/getSize());
		return getBoard(x, y);
	}
	
	public static void setBoard(int[][] board) {
		EcoNPuzzleUtils.board = board;
	}	
	
	public static void setBoard(int x, int y, int value) {
		EcoNPuzzleUtils.board[x][y] = value;
	}
	
	public static void setBoard(int num, int value) {
		if(EcoNPuzzleUtils.isInit()) {
			int x = num%getSize();
			int y = (int) Math.floor(num/getSize());
			EcoNPuzzleUtils.board[x][y] = value;
		}
	}
	
	public static int[][] getAgress() {
		return agress;
	}

	public static int getAgress(int x, int y) {
		return agress[x][y];
	}
	
	public static int getAgress(int num) {
		int x = num%getSize();
		int y = (int) Math.floor(num/getSize());
		return getAgress(x, y);
	}
	
	public static void setAgress(int[][] board) {
		EcoNPuzzleUtils.agress = board;
	}	
	
	public static void setAgress(int x, int y, int value) {
		EcoNPuzzleUtils.agress[x][y] = value;
	}
	
	public static void setAgress(int num, int value) {
		if(EcoNPuzzleUtils.isInit()) {
			int x = num%getSize();
			int y = (int) Math.floor(num/getSize());
			EcoNPuzzleUtils.agress[x][y] = value;
		}
	}

	public static boolean isInit() {
		return init;
	}
	
	public static void setLeader(int leader) {
		EcoNPuzzleUtils.leader = leader;
	}
	
	public static int getLeader() {
		return leader;
	}
	
	public static void setBlankTile(int blankTile) {
		EcoNPuzzleUtils.blankTile = blankTile;
	}
	
	public static int getBlankTile() {
		return blankTile;
	}
}
