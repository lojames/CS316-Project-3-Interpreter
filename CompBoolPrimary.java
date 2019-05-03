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

		if ( eVal1.isNumber() && eVal2.isNumber() ){
			if ( getOp().equals(" <") ) {
				return new BoolVal( eVal1.floatVal() < eVal2.floatVal() );
			} else if ( getOp().equals(" <=") ) {
				return new BoolVal( eVal1.floatVal() <= eVal2.floatVal() );
			} else if ( getOp().equals(" ==") ) {
				return new BoolVal( eVal1.floatVal() == eVal2.floatVal() );
			} else if ( getOp().equals(" >") ) {
				return new BoolVal( eVal1.floatVal() > eVal2.floatVal() );
			} else if ( getOp().equals(" >=") ) {
				return new BoolVal( eVal1.floatVal() >= eVal2.floatVal() );
			} else {
				return new BoolVal( eVal1.floatVal() != eVal2.floatVal() );
			}
		} else if (!eVal1.isNumber() && !eVal2.isNumber()) {
			
			int a, b;
			
			if ( ((BoolVal)eVal1).val == true) {
				a = 1;
			} else {
				a = 0;
			}
			
			if ( ((BoolVal)eVal2).val == true) {
				b = 1;
			} else {
				b = 0;
			}
			
			if ( getOp().equals(" <") ) {
				return new BoolVal( a < b );
			} else if ( getOp().equals(" <=") ) {
				return new BoolVal( a <= b );
			} else if ( getOp().equals(" ==") ) {
				return new BoolVal( a == b );
			} else if ( getOp().equals(" >") ) {
				return new BoolVal( a > b );
			} else if ( getOp().equals(" >=") ) {
				return new BoolVal( a >= b );
			} else {
				return new BoolVal( a != b );
			}
		} else {
			IO.displayln("Error:" +getOp()+ " operator cannot be applied to [" +eVal1.toString()+","+eVal2.toString()+"]");
			return null;
		}
		
	}
}