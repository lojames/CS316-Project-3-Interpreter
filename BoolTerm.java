import java.util.*;

class BoolTerm
{
	LinkedList<BoolPrimaryItem> boolPrimaryItemList;

	BoolTerm(LinkedList<BoolPrimaryItem> bpItemList)
	{
		boolPrimaryItemList = bpItemList;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <boolTerm>");
		for ( BoolPrimaryItem bp : boolPrimaryItemList )
			bp.printParseTree(indent+" ");
	}
	
	Val Eval(HashMap<String,Val> state)

	// Evaluate a sequence of boolean primaries

	{
		Val bTermVal = null;

		for ( BoolPrimaryItem p : boolPrimaryItemList ) {
			bTermVal = p.Eval(state, bTermVal);
			if (bTermVal == null) {
				return null;
			}
		}
		return bTermVal;
	}
	
}

