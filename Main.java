import java.io.*;
import java.util.*;
public class Main{
    static String password()
    {
        Console console=System.console();
        System.out.println("Enter new Password:");
        String pass=console.readLine();
        return pass;
    }
    static void Display(String fn, String ln, String email,String pass,int mailCap)
    {
        System.out.println("Name: "+fn+" "+ln);
        System.out.println("Email: "+email);
        System.out.println("Password: "+pass);
        System.out.println("Mail Capacity: "+mailCap);
        
    }
    public static void main(String args[])throws IOException {
    BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
    String fn,ln,dep,email="",pass="";
    int i,mailCap=100;
    //System.out.println("Enter your First name");
    fn=br.readLine();
    //System.out.println("Enter your Last name");
    ln=br.readLine();
    //System.out.println("Enter your Department");
    dep =br.readLine();
    
    //Generating email
    email=email+dep.charAt(0);
    for(i=0;i<dep.length();i++)
    {
        if(dep.charAt(i)==' ')
        {
            email=email+dep.charAt(i+1);
            break;
        }
    }
    email=fn+"."+email+"."+ln+"@email.com";
    //System.out.println("Email: "+email);
    
    
    //Generating password
    for(i=0;i<8;i++)
    {
        int tem=(int)(Math.random()*30)-4;
        int ck=1;
        if((int)(Math.random()*10)%2==0)
        {
            
            for(char j='a';j<='z';j++)
            {
                if(ck==tem&&ck>0)
                {
                    if((int)(Math.random()*10)%2==0)
                    pass=pass+j;
                    else                 
                    pass=pass+Character.toUpperCase(j);
                }    
                ck++;
            }
        }
        else{
            int p=(int)(Math.random()*10);
            pass=pass+p;
        }
    }
    //System.out.println("Password: "+pass);
    
    //Method to change Password
    System.out.println(" Want to Set your own password: y/n");
    char ch= (char)br.read();
    if('y'==Character.toLowerCase(ch))
    pass=password();

    
    //Method to Display Name,email and Mailbox Capacity
    Display(fn,ln,email,pass,mailCap);
}
}