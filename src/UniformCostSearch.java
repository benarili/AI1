import java.util.*;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...
	private class WeightedNode implements Comparable<WeightedNode>{
		private ASearchNode node;
		private int weight;

		public WeightedNode(ASearchNode node, int weight){
			this.weight=weight;
			this.node=node;
		}

		@Override
		public int compareTo(WeightedNode o) {
			return Integer.compare(this.weight,o.weight);
		}

		public int getWeight(){
			return weight;
		}

		public ASearchNode getNode() {
			return node;
		}

		public void setNode(ASearchNode node) {
			this.node = node;
		}

		public void setWeight(int weight) {
			this.weight = weight;
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
		_openList = new PriorityQueue<>();
		_closedList = new HashSet<>();
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

	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{

	}

	@Override
	public int openSize() 
	{
		return 0;
	}

	@Override
	public ASearchNode getBest() 
	{
		return null;
	}

}
