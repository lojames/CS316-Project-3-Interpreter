import java.util.*;

abstract class CompBoolPrimary extends BoolPrimary
{
	E e1;
	E e2;

	CompBoolPrimary(E e_1, E e_2)
	{
		e1 = e_1;
		e2 = e_2;
	}

	abstract String getOp();
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		e1.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + getOp());
		e2.printParseTree(indent1);
	}
	
	Val Eval(HashMap<String,Val> state) {
		Val eVal1 = e1.Eval(state);
		Val eVal2 = e2.Eval(state);
		
		if (!eVal1.isNumber()){
			IO.displayln("Error:" +getOp()+ "operator cannot be applied to " +eVal1.toString());
			return null;
		} else if (!eVal2.isNumber()) {
			IO.displayln("Error:" +getOp()+ "operator cannot be applied to " +eVal2.toString());
			return null;
		}
		
		if ( getOp().equals(" <") ) {
			return new BoolVal( ((FloatVal)eVal1).val < ((FloatVal)eVal2).val );
		} else if ( getOp().equals(" <=") ) {
			return new BoolVal( ((FloatVal)eVal1).val <= ((FloatVal)eVal2).val );
		} else if ( getOp().equals(" ==") ) {
			return new BoolVal( ((FloatVal)eVal1).val == ((FloatVal)eVal2).val );
		} else if ( getOp().equals(" >") ) {
			return new BoolVal( ((FloatVal)eVal1).val > ((FloatVal)eVal2).val );
		} else if ( getOp().equals(" >=") ) {
			return new BoolVal( ((FloatVal)eVal1).val >= ((FloatVal)eVal2).val );
		} else {
			return new BoolVal( ((FloatVal)eVal1).val != ((FloatVal)eVal2).val );
		}
		
	}
}