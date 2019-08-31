/*****************************************************************************
 * Do not modify this file.
 * StackException class. It is used by ArrayStack class
 *****************************************************************************/

package PJ3;

public class StackException extends RuntimeException
{
    public StackException()
    {
	this("");
    }

    public StackException(String errorMsg) 
    {
	super(errorMsg);
    }

}
