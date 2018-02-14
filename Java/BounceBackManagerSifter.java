/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-13
 */

//IMPORTS
import java.util.List;
import java.util.ArrayList;

public class BounceBackManagerSifter
{
    public static EmailAddress sift(String inString)
    {
        int length = inString.length();
        int charIndex;
        char currentChar;
        String siftedString;
        List<EmailAddress> emailList = new ArrayList<EmailAddress>();
        EmailAddress email = new EmailAddress();
        
        for(int ii=0;ii<length;ii++)
        {
            currentChar = inString.charAt(ii);
            if(currentChar=='@')
            {
                charIndex = ii;
                //inString = trimRight(charIndex, inString);
                //inString = trimLeft(charIndex, inString);
            }//ENDIF
            if(checkStandard(inString))
            {
                email = new EmailAddress(inString);
            }//ENDIF
        }//END FOR
        return email;
    }//END sift

    private static String trimRight(int charIndex, String inString)
    {
        int indexToCut = charIndex;
        do
        {
            if(inString.charAt(charIndex)==' ')
            {
                indexToCut = charIndex;
            }
            else
            {
                charIndex++;
            }//END IF
        }while(inString.charAt(charIndex)!= inString.length() && inString.charAt(charIndex)!=' ');//END DO-WHILE
        inString = inString.substring(0,indexToCut);
        return inString;
    }//END trimRight

    private static String trimLeft(int charIndex, String inString)
    {
        int indexToCut = charIndex;
        do
        {
            if(inString.charAt(charIndex)==' ')
            {
                indexToCut = charIndex;
            }
            else
            {
                charIndex--;
            }//END IF
        }while(inString.charAt(charIndex) != 0 && inString.charAt(charIndex)!=' ');//END DO-WHILE
        inString = inString.substring(indexToCut, inString.length());
        return inString;
    }//END trimLeft

    private static boolean checkStandard(String inEmail)
    {
        boolean noMatch = false;
        String standardOne = "glen.smith@lakesnetworking.com.au";
        String standardTwo = "<glen.smith@lakesnetworking.com.au>";

        if(!inEmail.equals(standardOne) && !inEmail.equals(standardTwo))
        {
            noMatch = true;
        }//ENDIF
        return noMatch;
    }//END checkStandard
}//END class BounceBackManagerSifter