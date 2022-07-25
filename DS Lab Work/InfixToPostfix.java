
class StackNode
{
	public char element;
	public StackNode next;
	public StackNode(char element, StackNode next)
	{
		this.element = element;
		this.next = next;
	}
}
class MyStack
{
	public StackNode top;
	public int size;
	public MyStack()
	{
		this.top = null;
		this.size = 0;
	}
	public void push(char element)
	{
		this.top = new StackNode(element, this.top);
		this.size++;
	}
	public boolean isEmpty()
	{
		if (this.size > 0 && this.top != null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void pop()
	{
		if (this.size > 0 && this.top != null)
		{
			StackNode temp = this.top;
			this.top = temp.next;
			this.size--;
		}
	}
	public char peek()
	{
		if (this.top == null)
		{
			return ' ';
		}
		return this.top.element;
	}
}
public class InfixToPostfix 
{
	public int precedence(char text)
	{
		if (text == '+' || text == '-')
		{
			return 1;
		}
		else if (text == '*' || text == '/')
		{
			return 2;
		}
		else if (text == '^')
		{
			return 3;
		}
		return -1;
	}
	public boolean is_operator(char text)
	{
		if (text == '+' || text == '-' || text == '*' || text == '/' || text == '^')
		{
			return true;
		}
		return false;
	}
	public void infixToPostfix(String infix)
	{
		String result = "";
		int size = infix.length();
		MyStack s = new MyStack();
		for (int i = 0; i < size; ++i)
		{
			if ((infix.charAt(i) >= '0' && infix.charAt(i) <= '9') || (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z') || (infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z'))
			{
				result = result + infix.charAt(i);
			}
			else
			{
				if (s.isEmpty() || infix.charAt(i) == '(')
				{
					s.push(infix.charAt(i));
				}
				else if (infix.charAt(i) == ')')
				{
					while (s.isEmpty() == false && s.peek() != '(')
					{
						result += s.peek();
						s.pop();
					}
					if (s.peek() == '(')
					{
						s.pop();
					}
				}
				else
				{
					while (s.isEmpty() == false && precedence(infix.charAt(i)) <= precedence(s.peek()))
					{
						
						result += s.peek();
						
						s.pop();
					}
					
					s.push(infix.charAt(i));
				}
			}
		}
		
		while (s.isEmpty() == false)
		{
			result += s.peek();
			s.pop();
		}
		
		System.out.println(" Infix    : " + infix);
		System.out.println(" Postfix  : " + result);
	}
	public static void main(String[] args)
	{
		Conversion task = new Conversion();
		String infix = "((a/b+c))/(e*f)+(g^h-i)+k";
		task.infixToPostfix(infix);
		String infix2 = "((a*b)^(c+d)/e)-f";
		task.infixToPostfix(infix2);
	}
}
