
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic	(IProblemState problemState	)
	{
		if(problemState instanceof TilePuzzle){
			TilePuzzle tilePuzzle = (TilePuzzle)problemState;
			int heuristic = 0;
			for (int i = 0; i < tilePuzzle._size; i++) {
				for (int j = 0; j < tilePuzzle._size; j++) {
					heuristic+=getManhattenDistance(tilePuzzle._tilePuzzle[i][j],i,j,tilePuzzle._size);
				}
			}

		}
		return 0;
	}

	private int getManhattenDistance(int value, int row, int col, int size) {
		if(value==0)
			return 0;
		int desiredRow=getDesiredRow(size, value);
		int desiredCol=getDesiredCol(size, value);
		return Math.abs(row-desiredRow)+Math.abs(col-desiredCol);
	}

	private int getDesiredCol(int size, int value) {
		int col = (value%size)-1;
		col = col<0 ? size-1 : col;
		return col;
	}

	private int getDesiredRow(int size, int value) {
		return (value-1)/size;
	}

}
