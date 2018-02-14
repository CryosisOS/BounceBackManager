/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-13
 */

//IMPORTS
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BounceBackManagerFileWriter
{
    //CLASS CONSTANTS
    private static final String ISOLATE_FILENAME = "NewEmailList.csv";

    //CLASS FIELDS
    private String filename;
    private File thisFile;
    private List<EmailAddress> emailList;

    //DEFAULT CONSTRUCTOR
    public BounceBackManagerFileWriter()
    {
        filename = null;
        emailList = new ArrayList<EmailAddress>();
    }//END DEFAULT CONSTRUCTOR

    public void setFileName()
    {
        filename = run.EMAIL_LIST_FILE_PATH+ISOLATE_FILENAME;
        setFile();
    }//END setFileName

    public void setEmailList(List<EmailAddress> inList)
    {
        Set<EmailAddress> emailSet = new HashSet<EmailAddress>();
        emailList.addAll(inList);
        emailSet.addAll(emailList);
        emailList.clear();
        emailList.addAll(emailSet);
        BounceBackManagerListCleaner.removeDuplicates(emailList);
    }//END setEmailList

    private void setFile()
    {
        thisFile = new File(filename);
    }//END setFile

    public void write() throws IOException
    {
        String line;
        FileWriter pw = null;

        try
        {
            pw = new FileWriter(thisFile);
            for(int ii=0;ii<emailList.size();ii++)
            {
                line = emailList.get(ii).toString();
                pw.write(line+"\n");
            }//END FOR
            pw.close();
        }//END TRY
        catch(IOException ioex)
        {
            throw ioex;
        }//END CATCH
    }//END write
}//END class BounceBackManagerFileWriter