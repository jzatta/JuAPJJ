import java.util.*;

class History{
	private List<Context> context;
	private int index;

	public History(){
		this.context = new ArrayList<Context>();
		this.index = 0;
	}

	public void reset(){
		this.index = 0;
	}

	public boolean hasContext(){
		index++;
		return (index < context.size());
	}

	public Context context(){
		return this.context.get(index);
	}
}
