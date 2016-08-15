import java.util.List;


public class SinglyList<T>
{
	List<T> list;

	private SinglyList(List<T> list)
	{
		super();
		this.list = list;
	}
	
	public T delete(){
		return list.remove(0);
	}
}
