import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise_21_3
{

    private static final Set<String> keywordSet = new HashSet<>( Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case",
            "catch", "char", "class", "const", "continue", "default",
            "do", "double", "else", "enum", "extends", "final", "finally",
            "float", "for", "goto", "if", "implements", "import", "instanceof",
            "int", "interface", "long", "native", "new", "null", "package",
            "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile", "while"
    ));

    private static int getKeywordCount( Scanner reader )
    {
        int count = 0;
        while (reader.hasNext())
        {
            String next = reader.next();
            System.out.print(next);
            if (keywordSet.contains(next))
            {
                count++;
            }
        }

        return count;
    }

    public static void main( String[] args )
    {
        if (args.length < 1)
        {
            System.out.println("Please provide the file name as a command line argument.");
            return;
        }

        String filename = args[0];
        File file = new File( filename );

        try
        {
            int keywordCount = getKeywordCount( new Scanner(file) );
            System.out.println("Code has " + keywordCount + " keywords.");
        } catch ( FileNotFoundException e )
        {
            System.out.println("Unable to find file!");
        }
    }

}
