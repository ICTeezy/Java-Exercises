import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Exercise_20_11
{
    private final static Map<Character, Character> symbolMap = new HashMap<>();

    static {
        symbolMap.put( ')', '(' );
        symbolMap.put( '}', '{' );
        symbolMap.put( ']', '[' );
    }

    private static boolean checkValidMatchingSymbols( String source)
    {

        Stack<Character> characterStack = new Stack<>();

        for (char c : source.toCharArray())
        {
            if (c == '(' || c == '{' || c == '[')
            {
                characterStack.add( c );
            }
            else if (c == ')' || c == '}' || c == ']')
            {
                if (symbolMap.get( c ) != characterStack.peek())
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main( String[] args )
    {
        if (args.length < 1)
        {
            System.out.println( "Please provide a file name as an argument!" );
            return;
        }

        String filePath = args[0];

        try
        {
            String source = Files.readString( Paths.get(filePath));
            boolean isValid = checkValidMatchingSymbols( source );

            if (isValid)
            {
                System.out.println("Valid grouping pairs");
            }
            else
            {
                System.out.println("Invalid grouping pairs");
            }
        } catch ( IOException e )
        {
            System.out.println("Unable to read file!");
        }
    }

}
