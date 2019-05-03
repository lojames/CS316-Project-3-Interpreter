import java.util.*;

class ReturnVal extends Var
{
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln("");
		IO.displayln(indent1 + indent1.length() + " returnVal");
	}
	
	Val Eval(HashMap<String,Val> state)
	{	
		Val returnVal = state.get("returnVal");
		if ( returnVal != null )
			return returnVal.cloneVal();
		else
		{
			IO.displayln( "Error: returnVal does not have a value" );
			return null;
		}
	}
}