import java.util.*;

class Neq extends CompBoolPrimary
{
	Neq(E e_1, E e_2)
	{
		super(e_1, e_2);
	}
	
	String getOp()
	{
		return " !=";
	}
}