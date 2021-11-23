import java.util.*;

public class Generator
{
    private static String exit_code = "<exit>";
    private static List<Member> members = new ArrayList<Member>();
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter class name:");
        String class_name = sc.next();
        while(true)
        {
            System.out.println("Enter datatype: ");
            String in_d = sc.next();
            if(in_d.equals(exit_code))
            {
                break;
            }
            System.out.println("Enter name: ");
            String in_n = sc.next();
            if(in_n.equals(exit_code) )
            {
                break;
            }
            Member m = new Member();
            m.name = in_n;
            m.datatype = in_d;
            members.add(m);
        }
        String result = "class "+class_name+"\n"+"{"+'\n';
        for(int i=0;i<members.size();i++)
        {
            result+="   private "+members.get(i).datatype+" "+members.get(i).name+";\n";
        }
        result+=constructor(class_name);
        for(int i = 0; i < members.size(); i++)
        {
            result+='\n';
            result+=getter(members.get(i).datatype,members.get(i).name);
            result+='\n';
            result+=setter(members.get(i).datatype,members.get(i).name);
        }
        result+='\n';
        result+='}';
        System.out.print('\f');
        System.out.print(result);
    }
    
    public static String getter(String datatype, String name)
    {
        String s;
        s = "   public "+datatype+" get_"+name+"()";
        s+='\n';
        s+="   {";
        s+='\n';
        s+="        return this."+name+";";
        s+='\n';
        s+="   }";
        
        
        return s;
    }
    public static String setter(String datatype, String name)
    {
        String s;
        s = "   public void set_"+name+"("+datatype+" "+name+")";
        s+='\n';
        s+="   {";
        s+='\n';
        s+="        this."+name+" = "+name+";";
        s+='\n';
        s+="   }";
        return s;
    }
    public static String constructor(String class_name)
    {
        String s;
        s = "   public "+class_name+"(";
        for(int i=0;i<members.size();i++)
        {
            s+=members.get(i).datatype;
            s+=" ";
            s+=members.get(i).name;
            if(i == members.size()-1)break;
            s+=",";
        }
        s+=")";
        s+='\n';
        s+="   {";
        for(int i=0;i<members.size();i++)
        {
            s+='\n';
            s+="        this."+members.get(i).name+" = "+members.get(i).name+";";
        }
        s+='\n';
        s+="   }";
        return s;
    }
}
