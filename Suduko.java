import java.util.*;
import java.math.*;

import javax.naming.spi.DirStateFactory.Result;
class Pk
{
    static boolean Result(int save[][])
    {
        int r=0,c=0,row=0,column=0,count=0;
            for(int i=0;i<6;i++)
            {
                int arr[]=new int[]{0,0,0,0,0,0};
                r=0;
                for(int j=0;j<6;j++)
                {
                    if(save[i][j]!=0)
                    {
                        arr[j]=save[i][j];
                    }
                }
                for(int z=0;z<5;z++)
                {
                    for(int k=z+1;k<6;k++)
                    {
                        if(/*Math.abs*/(arr[z]-arr[k]!=0))
                        {
                             r++;
                        }
                    }
                }
                if(r==15)
                {
                    row++;
                }
            }
            
            for(int i=0;i<6;i++)
            {
                int arr1[]=new int[]{0,0,0,0,0,0};
                c=0;
                for(int j=0;j<6;j++)
                {
                    if(save[j][i]!=0)
                    {
                        arr1[j]=save[j][i];
                    }
                }
                for(int z=0;z<5;z++)
                {
                    for(int k=z+1;k<6;k++)
                    {
                        if(arr1[z]-arr1[k]!=0)
                        {
                             c++;
                        }
                    }
                }
                if(c==15)
                {
                    column++;
                }
            }
            for(int i=0;i<6;i++)
            {
                for(int j=0;j<6;j++)
                {
                    if(save[i][j]!=0)
                    {
                        count++;
                    }
                }
            }
        if(row==6 && column==6 && count==36)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    static void Print()
    {
        char ch='A';
        int num1=1;
        for(int i=1;i<=6;i++)
        {
            System.out.print("  "+num1+" ");
            num1++;
        }
        System.out.println();
        for(int i=1;i<=25;i++)
        {
            for(int j=1;j<=26;j++)   
            {
                if((i==3 || i==7 || i==11 || i==15 || i==19 || i==23)&& j==26)
                {
                    System.out.print(" "+ch);
                    ch++;
                }
                else if(i==1 || i==5 || i==9 || i==13 || i==17 || i==21 || i==25)
                {
                    if(j==26)
                    {
                        break;
                    }
                    System.out.print("-");
                }
                else if(j==1 || j==5 || j==9 || j==13 || j==17 || j==21 || j==25)
                {
                    System.out.print( "|");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static String Str()
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        str=str.toUpperCase();
        return str;
    }

    static Integer value()
    {
        Scanner sc=new Scanner(System.in);
        int numeric=sc.nextInt();
        return numeric;
    }

    static void Box(int num,char ch,int value,int save[][])
    {
        String alpha = "ABCDEF";
        int[] scan=new int[]{3,7,11,15,19,23};
        int[] arr=new int[]{1,2,3,4,5,6};
        int num1=1;//for printing value in top of the table
        int add=3,vali=0,valj=0,first=0,second=0,one=0,two=0;
            for(int i=0;i<6;i++)
            {
                if(num==arr[i])
                {
                    vali=vali+add;
                    first=first+i;
                    break;
                }
                add+=4;
            }
            int add1=3;
            for(int j=0;j<6;j++)
            {
                if(ch==alpha.charAt(j))
                {
                    valj=valj+add1;
                    second=second+j;
                    break;
                }
                add1+=4;
            }
            save[first][second]=value;
            char ch1='A';
        for(int i=1;i<=6;i++)
        {
            System.out.print("  "+ch1+" ");
            ch1++;
        }
        System.out.println();
        for(int i=1;i<=25;i++)
        {
            for(int j=1;j<=26;j++)   
            {
                if((i==3 || i==7 || i==11 || i==15 || i==19 || i==23)&& j==26)
                {
                    System.out.print(" "+num1);
                    num1++;
                }
                else if(i==1 || i==5 || i==9 || i==13 || i==17 || i==21 || i==25)
                {
                    if(j==26)
                    {
                        break;
                    }
                    System.out.print("-");
                }
                else if(j==1 || j==5 || j==9 || j==13 || j==17 || j==21 || j==25)
                {
                    System.out.print( "|");
                }
                else
                {
                    for(int u=0;u<6;u++)
                    {
                        if(i==scan[u])
                        {
                            one=u;
                        }
                        if(j==scan[u])
                        {
                            two=u;
                        }
                    }
                    if(i==scan[one] && j==scan[two])
                    {
                        if(save[one][two]==0)
                        {
                            System.out.print(" ");
                        }
                        else
                        {
                            System.out.print(save[one][two]);
                        }
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}

public class Suduko
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Pk.Print();
        int[][] save = new int[][] {{0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0}};
        // int[][] save = new int[][] {{0,6,2,1,4,3},
        //                             {4,3,1,2,5,6},
        //                             {6,4,3,5,1,2},
        //                             {2,1,5,3,6,4},
        //                             {3,5,6,4,2,1},
        //                             {1,2,4,6,3,0}};           
        boolean bh=true;
        System.out.println("Enter the Position Like This \"1A\" or \"1a\"\n");
        while(bh)
        {
            System.out.println("Enter the Position : ");
            String pos=Pk.Str();
            if(pos.length()<2)
            {
                System.out.println("Enter only 1 to 6 & A to F....");
            }
            else
            {
                char dummy=pos.charAt(0);
                int num=dummy-'0';
                char ch=(char)(pos.charAt(1));
                System.out.println("Enter the Value : ");
                int value=Pk.value();
                if(value>6)
                {
                    System.out.println("Value should be in less than 6...");
                }
                else
                {
                    Pk.Box(num,ch,value,save);
                    bh=Pk.Result(save);
                }
            }
        }
        System.out.println("You Won The Game...........");
        sc.close();
    }
}