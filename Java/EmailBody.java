/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-13
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

    public boolean equals(EmailBody inEmailBody)
    {
        boolean isEqual = false;
        if(this.getText().equals(inEmailBody.getText()))
        {
            isEqual = true;
        }//ENDIF
        return isEqual;
    }//END equals
}//END class EmailAddress