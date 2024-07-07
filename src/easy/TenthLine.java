package easy;

public class TenthLine
{
  public static void bashScript()
  {    
    String script = "#!/bin/bash\n";

    script += "n=0\n";
    script += "while read -r line;\n";
    script += "do\n";
    script += "    n=$(expr $n + 1)\n";
    script += "    if [ $n -eq 10 ]\n";
    script += "    then\n";

    script += "        echo $line\n";
    script += "    fi\n";
    script += "done < file.txt\n";
        
    System.out.println(script);
  }

  public static void bashScriptOpt()
  {
    String script = "n=1;\n";
    script += "while read line ;\n";      
    script += "do\n";
    script += "    if [  $n -eq 10  ]; then\n";
    script += "        echo \"$line\"\n";
    script += "    fi\n";
    script += "    n=$((n+1));\n";
    script += "done < file.txt\n";
    script += "\n";

    System.out.println(script);
  }

  public static void bashScriptEx()
  {
    String script = "sed -n '10p' file.txt\n";      
 
    System.out.println(script);
  }

  public static void bashScriptEx2()
  {
    String script = "awk 'NR==10 {print $0}' file.txt\n";      

    System.out.println(script);
  }

  public static void bashScriptEx3()
  {
    String script = "tail file.txt -n +10 | head -n 1\n";      

    System.out.println(script);
  }   
   
  public static void readme()
  {
    String str = "Given a text file file.txt, print just the 10th line of the file.\n\n";

    str += "1. If the file contains less than 10 lines, what should you output?\n\n";

    str += "2. There's at least three different solutions. Try to explore all possibilities..\n";
    System.out.println(str);
  }

  public static void main()
  {
    TenthLine.readme();

    System.out.println("The bash script:\n");
    TenthLine.bashScript();

    System.out.println("The optimized bash script:\n");
    TenthLine.bashScriptOpt();

    System.out.println("The extra bash script:\n");
    TenthLine.bashScriptEx();

    System.out.println("The extra bash script 2:\n");
    TenthLine.bashScriptEx2();

    System.out.println("The extra bash script 3:\n");
    TenthLine.bashScriptEx3();
  }
}