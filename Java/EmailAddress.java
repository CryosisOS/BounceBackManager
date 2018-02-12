/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-12
 */

public class EmailAddress extends EmailObject
{
    // DEFAULT CONSTRUCTOR
    public EmailAddress()
    {
        //To defeat instantiation
    }//END DEFAULT CONSTRUCTOR

    // ATLERNATE CONSTRUCTOR
    public EmailAddress(String inText)
    {
    	super.setText(inText);
    }//END ALTERNATE CONSTRUCTOR
}//END class EmailAddress