import java.util.*;

class Expr
{
	LinkedList<BoolTermItem> boolTermItemList;

	Expr(LinkedList<BoolTermItem> btItemList)
	{
		boolTermItemList = btItemList;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <expr>");
		for ( BoolTermItem bt : boolTermItemList )
			bt.printParseTree(indent+" ");
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		Val bVal = null;
		for ( BoolTermItem b : boolTermItemList ) {
			bVal = b.Eval(state, bVal);
			if (bVal == null) {
				return null;
			}
		}
		return bVal;
	}
}