/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-13
 */

//IMPORTS
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class BounceBackManagerFileReader
{
    //CLASS FIELDS
    private String filename;
    private File thisFile;
    private List<EmailBody> emailBodies;

    // DEFAULT CONSTRUCTOR
    public BounceBackManagerFileReader()
    {
        filename = null;
        emailBodies = new ArrayList<EmailBody>();
    }//END DEFAULT CONSTRUCTOR

    public void setFileName(String inFilename)
    {
        inFilename = run.EMAIL_LIST_FILE_PATH+inFilename;
        filename = inFilename;
        setFile();
    }//END setFileName

    private void setFile()
    {
        thisFile = new File(filename);
    }//END setFile

    public List<EmailBody> getEmailBodies()
    {
        List<EmailBody> copy = new ArrayList<EmailBody>();
        copy.addAll(emailBodies);
        return copy;
    }//END getEmailBodies

    public void read() throws IOException
    {
        String line;
        FileInputStream fileStream = null;
        InputStreamReader rdr = null;
        BufferedReader bufRdr = null;

        try
        {
            fileStream = new FileInputStream(thisFile);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);

            System.out.println(thisFile.toString());
            line = bufRdr.readLine();
            line = bufRdr.readLine();//Skip the first Line
            while(line != null)
            {
                if(lineAbove(line))
                {
                    line = bufRdr.readLine();
                    EmailBody newEmailBody = new EmailBody(line);
                    emailBodies.add(newEmailBody);    
                }
                else
                {
                    line = bufRdr.readLine();
                }//ENDIF
            }//END WHILE
            fileStream.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }//END TYR
                catch(IOException ioex2)
                {
                    //Can't do anything more
                }//END CATCH
            }//ENDIF
            throw new IOException("There was an error in the file processing.");
        }//END CATCH
    }//END read

    private boolean lineAbove(String inLine)
    {
        boolean isLineAbove = false;

        if(inLine.equals("The recipients that were affected are:") 
            || inLine.equals("Delivery has failed to these recipients or groups:")
            || inLine.equals("The recipients that were affected are:"))
        {
            isLineAbove = true;
        }//ENDIF
        return isLineAbove;
    }//END lineAbove
}//END class BounceBackManagerReadFile