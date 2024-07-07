package easy;

public class ValidPhoneNumbers
{
  public static void bashScript()
  {    
    /*
    1. print -
       echo "Hello, my name is &name"
       
    2. variables -
       files=$(ls)
        
    3. math expression -
       expr $n + $m 

    4. if -
       if [$num eq 200]    // or [! $num eq 200] = [$num ne 200] qt great then
       then
           echo "The condition is true."
       else
           echo "The num vairalbe does not equal 200."
       fi

       if [ -f ~/myfile ]
       then 
           echo "The file exists."
       else
           echo "The file does not exist."

    5. while -
       var=1
       while [ $var -le 10 ]
       do
           echo $var
           var = $(($var + 1 ))
           sleep 0.5
       done   
    6. for -
       for n in 1 2 3 4 5 6 7 8 9 10 // or in [1..10]
       do
           echo $n
           sleep 1
       done
    7. data stream -
       $1 => standard output
       $2 => standard error
       read myname => standard input
    8. function -
       check_status() {
           if [ $? -ne 0 ]
           then
               echo "An error occured."
           fi
       }
    9. case - 
       read distro;
       case $distro in
           1) echo "Arch.";;
           2) echo "CentOS.";;
           3) echo "Ubuntu.";;
           *) echo "you didn't enter valid number."
       esac
    */
  String script = "filename=file.txt\n";

    script += "if [ ! -f $filename ];\n";
    script += "then\n";
    script += "    echo \"$filename does not exist.\"\n";
    script += "    exit 2\n";
    script += "fi\n";
    script += "while read -r phone_number;\n";
    script += "do\n";
    script += "    if [[ ${phone_number:0:1} == \"(\" ]] && [[ ${phone_number:4:1} == \")\" ]];\n";
    script += "    then\n";
    script += "        if [[ ${phone_number:5:1} == \" \" ]] && [[ ${phone_number:9:1} == \"-\" ]];\n";
    script += "        then\n";
    script += "            if [[ ${phone_number:1:3} =~ ^[0-9]+$ ]] && [[ ${phone_number:6:3} =~ ^[0-9]+$ ]] && [[ ${phone_number:10:4} =~ ^[0-9]+$ ]]\n";
    script += "            then\n";
    script += "                if [[ ${#phone_number} -le 14 ]]\n";
    script += "                then\n";
    script += "                    echo $phone_number\n";
    script += "                fi\n";
    script += "            fi\n";
    script += "        fi\n";
    script += "    fi\n";
    script += "    if [[ ${phone_number:3:1} == \"-\" ]] && [[ ${phone_number:7:1} == \"-\" ]];\n";
    script += "    then\n";
    script += "        if [[ ${phone_number:0:3} =~ ^[0-9]+$ ]] && [[ ${phone_number:4:3} =~ ^[0-9]+$ ]] && [[ ${phone_number:8:4} =~ ^[0-9]+$ ]]\n";
    script += "        then\n";
    script += "            if [[ ${#phone_number} -le 12 ]]\n";
    script += "            then\n";
    script += "                echo $phone_number\n";
    script += "            fi\n";
    script += "        fi\n";
    script += "    fi\n";
    script += "done < $filename\n";
    script += "\n";
    script += "\n";
    script += "\n";

    System.out.println(script);
  }

  public static void bashScriptOpt()
  {
    String script = "p=\\([0-9][0-9][0-9]\\)\\ [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]\n";
    script += "p2=[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]\n";      

    script += "while read -r line;\n";
    script += "do\n";
    script += "  case \"$line\" in\n";
    script += "   $p)\n";
    script += "   echo \"$line\";;\n";
    script += "   $p2)\n";
    script += "   echo \"$line\";;\n";
    script += "  esac\n";
    script += "done < file.txt\n";

    System.out.println(script);
  }

  public static void bashScriptEx()
  {
    String script = "grep -E \'^(\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4})$\' file.txt\n";      

    System.out.println(script);
  }
  
  public static void readme()
  {
    String str = "Given a text file file.txt that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers.\n\n";

    str += "You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)\n\n";

    str += "You may also assume each line in the text file must not contain leading or trailing white spaces.\n";
    System.out.println(str);
  }

  public static void main()
  {
    ValidPhoneNumbers.readme();

    System.out.println("The bash script:\n");
    ValidPhoneNumbers.bashScript();
    
    System.out.println("The optimized bash script:\n");
    ValidPhoneNumbers.bashScriptOpt();

    System.out.println("The extra bash script:\n");
    ValidPhoneNumbers.bashScriptEx();

  }
}