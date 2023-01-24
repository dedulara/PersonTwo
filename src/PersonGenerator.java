import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        String personRecord = "";
        String idString = "";
        String firstName = "";
        String lastName = "";
        String titleString = "";
        int birthYear = 0;
        boolean done = false;

        do
        {
            idString = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]" );
            firstName = SafeInput.getNonZeroLenString(in, "Enter first name" );
            lastName = SafeInput.getNonZeroLenString(in, "Enter last name" );
            titleString = SafeInput.getNonZeroLenString(in, "Enter the title" );
            birthYear = SafeInput.getRangedInt(in, "Enter the birth year", 1000, 9999);

            Person personInput = new Person(idString, firstName, lastName, titleString, birthYear);
            people.add(personInput);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }
        while(!done);

        for(Person p: people)
            System.out.println(p);

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            for(Person rec : people)
            {
                String recString = rec.toCSVDataRecord();
                writer.write(recString, 0, recString.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}