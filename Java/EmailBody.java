/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-12
 */

public class EmailBody extends EmailObject
{
    // DEFAULT CONSTRUCTOR
    public EmailBody()
    {
        //To defeat instantiation
    }//END DEFAULT CONSTRUCTOR

    // ATLERNATE CONSTRUCTOR
    public EmailBody(String inText)
    {
    	super.setText(inText);
    }//END ALTERNATE CONSTRUCTOR
}//END class EmailAddress