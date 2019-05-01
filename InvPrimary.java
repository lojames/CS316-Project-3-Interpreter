import java.util.*;

class InvPrimary extends Primary
{
	Primary primary;

	InvPrimary(Primary p)
	{
		primary = p;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln("");
		IO.displayln(indent1 + indent1.length() + " !");
		primary.printParseTree(indent1);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		Val pVal = primary.Eval(state);
		if (pVal.isNumber()) {
			IO.displayln("Error: ! operator cannot be applied to " +pVal.toString());
			return null;
		} else {
			return new BoolVal(!((BoolVal)pVal).val);
		}
	}
}