import java.util.*;

class FunCallWithParameters extends FunCall
{
	// FunName funName; inherited from FunCall

	ExprList exprList;

	FunCallWithParameters(FunName fName, ExprList eList)
	{
		funName = fName;
		exprList = eList;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent1);
		exprList.printParseTree(indent1+" ");
	}

	@Override
	Val Eval(HashMap<String, Val> state) {
		FunDef tFunDef = Parser.funDefMap.get(funName.id.id);
		HashMap<String,Val> newState = new HashMap<String,Val>();
		
		LinkedList<Parameter> pList = ((HeaderWithParameters)tFunDef.header).parameterList.parameterList;
		int initialized = 0;
		for ( int i = 0; i < pList.size(); i++ ) {
			Val eVal = exprList.exprList.get(i).Eval(state);
			String id = pList.get(i).id.id;
			if (eVal != null) {
				newState.put(id, eVal);
				initialized++;
			} else {
				break;
			}
		}
		
		if (initialized == pList.size()) {
			Body tbody = tFunDef.body;
			tbody.M(newState);
			if (newState.get("returnVal") != null) {
				return newState.get("returnVal");
			} else {
				IO.displayln("returnVal does not have a value");
				return null;
			}
		} else {
			return null;
		}
	}
}