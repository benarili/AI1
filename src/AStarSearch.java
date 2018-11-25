import java.util.*;

public class AStarSearch   extends ASearch
{
	private Queue<ASearchNode> _open;
	private Collection<ASearchNode> _closed;

	private class AStarComperator implements Comparator<ASearchNode> {
		@Override
		public int compare(ASearchNode o1, ASearchNode o2) {
			return Double.compare(o1.getF(),o2.getF());
		}
	}
	// Define lists here ...
	
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() 
	{
		_open = new PriorityQueue<>(new AStarComperator());
		_closed = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		return _open.contains(node) ? node : null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return _open.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return _closed.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		_open.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		if(!isClosed(node))
			_closed.add(node);
	}

	@Override
	public int openSize() 
	{
		return _open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return _open.poll();
	}

}
