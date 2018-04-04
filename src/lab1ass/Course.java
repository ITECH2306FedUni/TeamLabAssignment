package lab1ass;
/**
 * @author RAWR xD
 */
public class Course {

	private String name;
	private float price;
	private int runtime;

	public Course(String _name, float _price , int  _runtime){
		this.name = _name;
		this.price = _price;
		this.runtime = _runtime;
		
	}

	public void finalize() throws Throwable {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		if (runtime > 0 && runtime <= 10){
			this.runtime = runtime;
		}
	
	}
	public String runTimeToString(int runtime)
	{
		return String.valueOf(runtime);
	}
	@Override
	public String toString() {
		return "Course [course=" + name + ", price=" + price + ", runtime=" + runtime + "]";
	}
}