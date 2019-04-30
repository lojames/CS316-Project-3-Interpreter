import java.util.*;

class Floatp extends Primary
{
	double val;

	Floatp(double d)
	{
		val = d;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		IO.displayln(" " + val);
	}
}