
import java.util.*;

class AndBoolPrimaryItem extends BoolPrimaryItem

// Represents "&& <boolPrimary>"

{
	// BoolPrimary boolPrimary; inherited from BoolPrimaryItem

	AndBoolPrimaryItem(BoolPrimary bp)
	{
		boolPrimary = bp;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " &&");
		boolPrimary.printParseTree(indent);
	}
	
	Val Eval(HashMap<String,Val> state, Val bTermVal)
	{
		Val bPrimaryVal = boolPrimary.Eval(state);

		if ( bTermVal == null || bPrimaryVal == null )
			return null;
		
		if ( bTermVal.isNumber() ) {
			IO.displayln("Error: && operator cannot be applied to " + bTermVal.toString());
			return null;
		} else if ( bPrimaryVal.isNumber() ) {
			IO.displayln("Error: && operator cannot be applied to " + bPrimaryVal.toString());
			return null;
		}
		
		return new BoolVal( ((BoolVal)bTermVal).val && ((BoolVal)bTermVal).val );
		
	}
}