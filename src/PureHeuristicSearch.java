import java.util.*;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	private Queue<ASearchNode> _open;
	private Collection<ASearchNode> _closed;

	private class PHSCOmperator implements Comparator<ASearchNode>{

		@Override
		public int compare(ASearchNode o1, ASearchNode o2) {
			return Double.compare(o2.getH(),o1.getH());
		}
	}
	@Override
	public String getSolverName() 
	{
		return "PHS";
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
		this._open = new PriorityQueue<>(new PHSCOmperator());
		this._closed = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen	(ASearchNode node)
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
		this._open.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
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
		return _open.remove();
	}

}