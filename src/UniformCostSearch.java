import java.util.*;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...

	private class UCSComparator implements Comparator<ASearchNode>{

		@Override
		public int compare(ASearchNode o1, ASearchNode o2) {
			return Double.compare(o1.getG(),o2.getG());
		}
	}
	private PriorityQueue<ASearchNode> _openList;
	private Collection<ASearchNode> _closedList;
	
	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot	(IProblemState problemState	)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists()
	{
		_openList = new PriorityQueue<>(new UCSComparator());
		_closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen	(ASearchNode node)
	{
		if(_openList.contains(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		return _openList.contains(node);
	}
	
	@Override
	public boolean isClosed	(ASearchNode node)
	{
		return _closedList.contains(node);
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		_openList.add(node);
	}

	@Override
	public void addToClosed	(ASearchNode node)
	{
		if(!isClosed(node))
			_closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return _openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return _openList.poll();
	}

}
