/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-14
 * Date Last Modified: 2018-02-14
 */

//IMPORTS
import java.util.List;
import java.util.ArrayList;

public class BounceBackManagerListCleaner
{
    public static List<EmailAddress> removeDuplicates(List<EmailAddress> inList)
    {
        List<EmailAddress> newList = new ArrayList<EmailAddress>();
        List<EmailAddress> seen  = new ArrayList<EmailAddress>();

        for(int ii=0;ii<inList.size();ii++)
        {
            if(checkSeen(seen, inList.get(ii)))
            {
                continue;
            }
            else
            {
                newList.add(inList.get(ii));
                seen.add(inList.get(ii));
            }//ENDIF
        }//END FOR
        return newList;
    }//END removeDuplicates

    private static boolean checkSeen(List<EmailAddress> seen, EmailAddress inEmail)
    {
        boolean isSeen = false;
        for(int ii=0;ii<seen.size();ii++)
        {
            if(seen.get(ii).toString().equals(inEmail.toString()))
            {
                isSeen = true;
                break;
            }//ENDIF
        }//ENDFOR
        return isSeen;
    }//END checkSeen
}//END class BounceBackManagerListClearner