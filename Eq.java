import java.util.*;

class Eq extends CompBoolPrimary
{
	Eq(E e_1, E e_2)
	{
		super(e_1, e_2);
	}
	
	String getOp()
	{
		return " ==";
	}
}