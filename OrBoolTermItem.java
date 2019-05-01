import java.util.*;

class OrBoolTermItem extends BoolTermItem

// Represents "|| <boolTerm>"

{
	// BoolTerm boolTerm; inherited from BoolTermItem

	OrBoolTermItem(BoolTerm bt)
	{
		boolTerm = bt;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " ||");
		boolTerm.printParseTree(indent);
	}
	
	Val Eval(HashMap<String,Val> state, Val bVal)
	{
		Val bTermVal = boolTerm.Eval(state);

		if ( bTermVal == null || bVal == null )
			return null;
		
		if ( bTermVal.isNumber() ) {
			IO.displayln("Error: || operator cannot be applied to " + bTermVal.toString());
			return null;
		} else if ( bVal.isNumber() ) {
			IO.displayln("Error: || operator cannot be applied to " + bVal.toString());
			return null;
		}
		
		return new BoolVal( ((BoolVal)bTermVal).val || ((BoolVal)bTermVal).val );
		
	}
}