/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-13
 */

//IMPORTS
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

public class Main
{
    public static void next()
    {
        out.print("------------------------------------------------------------------------------\n");
        out.print("                         Author: Nathan van der Velde                         \n");
        out.print("                     Lakes Networking - Internal Software                     \n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("            This software is used for managing the subscriber list            \n");
        out.print("                   by removing un-subscribers from the list                   \n");
        out.print("------------------------------------------------------------------------------\n");
        /** DO ALL THE STUFF BETWEEN THESE TWO SECTIONS**/
        menu();


        /** END OF ALL INBETWEEN STUFF **/
        out.print("File has been written.\n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("                               Process Finished                               \n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("\n\n");
    }//END next

    public static void menu()
    {
        String inFilename;
        String outFilename;
        String prompt = "Please enter in the name of the CSV File that contains all the email bodies: ";
        List<EmailAddress> emailList = new ArrayList<EmailAddress>();
        BounceBackManagerFileReader fileReader = new BounceBackManagerFileReader();
        BounceBackManagerFileWriter fileWriter = new BounceBackManagerFileWriter();

        try
        {
            inFilename = UserInput.getString(prompt);
            out.print("Reading the file...\n");
            fileReader.setFileName(inFilename);
            fileReader.read();
            out.print("File read...\n");
            out.print("Proceeding to extract emails...\n");
            emailList = siftFile(fileReader);
            out.print("Emails extracted...\n");
            out.print("Writing list...\n");
            fileWriter.setFileName();
            fileWriter.setEmailList(emailList);
            fileWriter.write();
        }//END TRY
        catch(IOException ioex)
        {
            out.print("There was an error with file processing.\n");
            out.println(ioex.getMessage());
            ioex.printStackTrace();
        }
    }//END menu

    public static List<EmailAddress> siftFile(BounceBackManagerFileReader fileReader)
    {
        List<EmailBody> list = new ArrayList<EmailBody>();
        List<EmailAddress> emailList = new ArrayList<EmailAddress>();
        EmailAddress email = new EmailAddress();
        list.addAll(fileReader.getEmailBodies());
        for(int ii=0;ii<list.size();ii++)
        {
            String inString = list.get(ii).toString();
            email = BounceBackManagerSifter.sift(inString);
            emailList.add(email);
        }//END FOR
        return emailList;
    }//END siftFile
}//END class Main