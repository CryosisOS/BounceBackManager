/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-12
 */

//IMPORTS
import java.util.ArrayList;
import java.util.List;

public class EmailList
{
    //CLASS FIELDS
    private static List<EmailAddress> emailList = new ArrayList<EmailAddress>();

    public static void add(EmailAddress inEmailAddress)
    {
        emailList.add(inEmailAddress);
    }//END add

    public static List<EmailAddress> getEmailList()
    {
        List<EmailAddress> copy = new ArrayList<EmailAddress>();
        copy.addAll(emailList);
        return copy;
    }//END getEmailList
}//END class EmailList