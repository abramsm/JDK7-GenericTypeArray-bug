import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class GenericsTest
{
	
	private class Foo
	{
		private Map<String, String[]> map = new HashMap<String, String[]>();
	}
	
	public static void main(String[] args) throws NoSuchFieldException
	{
		Field field = Foo.class.getDeclaredField("map");
		ParameterizedType type = (ParameterizedType) field.getGenericType();
		Object f1  = type.getActualTypeArguments()[1];
		if (f1 instanceof GenericArrayType)
		{
			System.out.println("Success!! identified GenericArrayType");
		} 
		else
		{
			System.err.println("Failed to correctly identify GenericArrayType, type was: " + f1);
		}
	}
}

