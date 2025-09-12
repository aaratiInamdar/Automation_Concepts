package Java;
public class SingleToneClass_Example2 {

	private static SingleToneClass_Example2 instance;
	String name;
	int age;
	
	private SingleToneClass_Example2(String name ,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public static SingleToneClass_Example2 getSingletonObj()
	{
		if(instance==null)
		{
			instance=new SingleToneClass_Example2("smitch" , 25);
		}
		return instance;
	}

	public static SingleToneClass_Example2 getInstance() {
		return instance;
	}


	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}