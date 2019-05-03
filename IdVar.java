import java.util.*;

class IdVar extends Var
{
	Id id;

	IdVar(Id ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln("");
		IO.display(indent1 + indent1.length() + " <id var>");
		id.printParseTree();
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		Val idVar = state.get(id.id);
		if ( idVar != null )
			return idVar.cloneVal();
		else
		{
			IO.displayln( "variable " +id.id+ " does not have a value" );
			return null;
		}
	}
}