package Java;

public class SingleToneClass {
	
	String str;
	int age;
	public static SingleToneClass ref=null;
	
	private SingleToneClass(String str , int age)
	{
		this.str=str;
		this.age=age;
	}
	
	public static SingleToneClass reuse(String s,int a)
	{
		if(ref==null)
		{
			ref=new SingleToneClass( s ,  a);
		}
		return ref;
	}
}
