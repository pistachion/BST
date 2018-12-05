public class Node

{
    int    id;   /*
                  * the original position of the data starting
                  * from 1
                  */
    // Program Specification
    String data;                                                                                                                                                                   // Program
    Node   small;                                                                                                                                                                    // Program
    Node   large;                                                                                                                              // Program
                                                                                                                                               // Specification

    public Node (String data, int id)        // Program Specification
    {
        this.data = new String (data);      // Program Specification
        this.id = id;                       // Program Specification
        small = null;                       // Program Specification
        large = null;                       // Program Specification
    }

    public Node ()
    {

    }

}
