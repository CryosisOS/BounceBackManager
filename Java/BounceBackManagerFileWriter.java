/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-12
 * Date Last Modified: 2018-02-13
 */

//IMPORTS
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class BounceBackManagerFileWriter
{
    //CLASS CONSTANTS
    private static final String ISOLATE_FILENAME = "NewEmailList.csv";

    //CLASS FIELDS
    private String filename;
    private Path filePath;
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
        setPath();
    }//END setFileName

    public void setEmailList(List<EmailAddress> inEmailList)
    {
        EmailList.getEmailList();
    }//END setEmailList

    private void setPath()
    {
        thisPath = Paths.get(filename);
        setFile();
    }//END setPath

    private void setFile()
    {
        thisFile = new File(thisPath.toString());
    }//END setFile

    public void write() throws IOException
    {
        String line;
        FileOutputStream fileStream =null;
        PrintWriter pw = null;

        try
        {
            fileStream = new FileOutputStream(thisFile);
            pw = new PrintWriter(fileStream);

            for(int ii=0;ii<emailList.size();ii++)
            {
                line = emailList.get(ii).toString();
                pw.println(line);
            }//END FOR
            pw.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }//END TRY
                catch(IOException ioex2)
                {
                    //Can't do anything more
                }//END CATCH
            }//END IF
            throw ioex;
        }//END CATCH
    }//END write
}//END class BounceBackManagerFileWriter