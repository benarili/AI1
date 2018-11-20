import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private Queue<ASearchNode> _openList;
	private Collection<ASearchNode> _closed;
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
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
		_openList = new LinkedList<>();
		_closed = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen	(ASearchNode node)
	{
		if(_openList.contains(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node	)
	{
		return _openList.contains(node);
	}
	
	@Override
	public boolean isClosed	(ASearchNode node)
	{
		return  _closed.contains(node);
	}

	@Override
	public void addToOpen(ASearchNode node	)
	{
		_openList.add(node);
	}

	@Override
	public void addToClosed	(ASearchNode node)
	{
 		_closed.add(node);
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
