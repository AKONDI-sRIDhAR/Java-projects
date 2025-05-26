import java.util.*;
import java.io.*;
import java.security.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class file {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        while(true)
        {
        System.out.println("-----FiLe InTeGrItY ChEcKeR------");
        System.out.println("Choose an option(1/2)\n1) Generate a hash for the file\n2) Check the integrity\n3)Exit");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1)
        {
            try {
            generate();
            }
            catch(Exception e) { e.printStackTrace();
            }
        }
        else if (choice==2) {
            try {
            check();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (choice==3) {
            System.out.println("----------BYE !----------");
            break;
        }
        else
        {
            return;
        }
    }

    }
    public static void generate() throws Exception
    {
        System.out.println("---Hash Generator---");
        System.out.println("Choose an algorithm (SHA-256 / SHA-1 / MD5) : ");
        String algo=sc.nextLine().toUpperCase();
        if (algo.equals("SHA-256") || algo.equals("MD5") || algo.equals("SHA-1")) {
        System.out.println("Enter the path for the file : ");
        String path=sc.nextLine();
        File f = new File(path);
        if(!f.exists())
        {
            System.out.println("File Not found");
            generate();
        }
        else{
        String hash=generatehash(path,algo);
        System.out.println("Required Hash is : " + hash);
        }
    }
        else{
            System.out.println("TRY AGAIN WRONG ALGORITHM");
            generate();
        }
        
        

    }
    public static String generatehash(String path, String algo) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance(algo);
        byte[] file = Files.readAllBytes(Paths.get(path));
        byte[] hash = digest.digest(file);

        StringBuilder sb = new StringBuilder();
        for(byte b : hash) sb.append(String.format("%02x", b));
        return sb.toString();

    }
    public static void check() throws Exception
    {
        System.out.println("---Hash Checker---");
        System.out.println("Enter the chosen algo (SHA-256 / SHA-1 / MD5): ");
        String algo=sc.nextLine().toUpperCase();
        if (algo.equals("SHA-256") || algo.equals("MD5") || algo.equals("SHA-1")) {
        System.out.println("Enter the File path : ");
        String path=sc.nextLine();
        File f = new File(path);
        if(!f.exists())
        {
            System.out.println("File Not found");
            generate();
        }
        else{
        System.out.println("Enter the previous hash : ");
        String hash=sc.nextLine();
        
        String oldhash=generatehash(path,algo);

        if(oldhash.equals(hash))
        {
            System.out.println("The file is good to go !\n---------------------");
        }
        else 
        {
            System.out.println(("The previous hash : " + oldhash + "\nNew hash : " + hash + "\n Are not matching !"));
            System.out.println("The file is corrupted !!!\n--------------------");   
        }
    }
    }
    else{
        System.out.println("WRONG INPUT TRY AGAIN");
        check();
    }
    }
    
}
