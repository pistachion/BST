import java.io.BufferedReader;
import java.io.FileReader;


public class P3
{
    private BST tree;
    private int result;

    public P3 ()
    {

    }

    public static void main (String[] args)
    {
        P3 thisClass = new P3 ();
        thisClass.nodeCreater ();
        thisClass.methodCaller ();
    }

    private String   fileData;
    private String[] modifiedData;

    public void nodeCreater ()
    {
        // Name of the file
        String fileName = "../data/test";

        // Variable to hold the one line data
        fileData = null;

        try
        {
            // Create object of FileReader
            FileReader inputFile = new FileReader (fileName);

            // Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader (inputFile);

            // Read file line by line and print on the console

            while ((fileData = bufferReader.readLine ()) != null)
            {
                System.out.println ("\n" + "[FileData]\n" + fileData + "\n");

                modifiedData = fileData.split (" ");

            }

            tree = new BST ();

            for (int i = 0; i < modifiedData.length; i++)
            {
                String nodeData = modifiedData[i];
                String nextData;
                // System.out.println ("Node ID [" + num + "] Name " +
                // nodeData);

                switch (nodeData)
                {
                    case "NULL":
                        System.out.println ("\n@End of File [shown in-order]");
                        tree.inorder ();
                        break;

                    case "S":
                    {
                        nextData = modifiedData[++i];
                        System.out.println ("\n[Searching for: " + nextData + "]");
                        result = tree.bst_search (nextData);
                        System.out.println ("Search found: ID " + result);
                        break;
                    }

                    case "D":
                    {
                        nextData = modifiedData[++i];
                        System.out.println ("\n[Delete: " + nextData + " ]");
                        tree.delete (nextData);
                        break;
                    }

                    default:
                    {
                        tree.bst_insert (nodeData);
                        break;
                    }
                }
            }

            // Close the buffer reader
            bufferReader.close ();
        }

        catch (Exception e)
        {
            System.out.println ("Error while reading file line by line:" + e.getMessage ());
            e.printStackTrace ();
        }

        // System.out.println ("fileData " + fileData);

    }

    public void methodCaller ()
    {
        System.out.println ("\n[In-order]");
        tree.inorder ();
        System.out.println ("\n[Preorder]");
        tree.preorder ();
    }
}
