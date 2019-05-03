import java.util.*;

class FunCallWithoutParameters extends FunCall
{
	// FunName funName; inherited from FunCall

	FunCallWithoutParameters(FunName fName)
	{
		funName = fName;
	}
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent+" ");		
	}

	@Override
	Val Eval(HashMap<String, Val> state) {
		FunDef tFunDef = Parser.funDefMap.get(funName.id.id);
		HashMap<String,Val> newState = new HashMap<String,Val>();
		Body tbody = tFunDef.body; 
		tbody.M(newState);
		if (newState.get("returnVal") != null) {
			return newState.get("returnVal");
		} else {
			IO.displayln("returnVal does not have a value");
			return null;
		}
	}
}