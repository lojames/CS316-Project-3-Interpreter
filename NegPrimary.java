import java.util.*;

class NegPrimary extends Primary
{
	Primary primary;

	NegPrimary(Primary p)
	{
		primary = p;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln("");
		IO.displayln(indent1 + indent1.length() + " -");
		primary.printParseTree(indent1);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		Val pVal = primary.Eval(state);
		if (!pVal.isNumber()) {
			IO.displayln("Error: unary - operator cannot be applied to " +pVal.toString());
			return null;
		}
		Class pClass = pVal.getClass();
		if (pClass == IntVal.class) {
			return new IntVal(-((IntVal)pVal).val);
			
		} else {
			return new FloatVal(-((FloatVal)pVal).val);
		} 
	}
}