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

    public boolean equals(EmailAddress inEmailAddress)
    {
        boolean isEqual = false;
        if(this.getText().equals(inEmailAddress.getText()))
        {
            isEqual = true;
        }//ENDIF
        return isEqual;
    }//END equals
}//END class EmailAddress