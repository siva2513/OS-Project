import java.util.*;
class project
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n,i,k;
String s;
System.out.println("Enter number of processes");
n=sc.nextInt();
int a[]=new int[n];
int b[]=new int[n];
String p[]=new String[n];
for(i=0;i<n;i++)
{
System.out.println("Enter Process_id,Arrival time and Burst time");
p[i]=sc.next();
a[i]=sc.nextInt();
if(a[i]<4)
{
System.out.println("System does not execute any process in first three seconds");
a[i]=sc.nextInt();
}
b[i]=sc.nextInt();
if(b[i]>10)
{
System.out.println("The burst time exceeds 10 units.Enter burst time again: ");
b[i]=sc.nextInt();
}
}
for(i=0;i<n-1;i++)
{
if(a[i]<a[i+1])
{
k=a[i];
a[i]=a[i+1];
a[i+1]=k;
k=b[i];
b[i]=b[i+1];
b[i+1]=k;
s=p[i];
p[i]=p[i+1];
p[i+1]=s;
}
else if(a[i]==a[i+1])
{
if(b[i]>b[i+1])
{
k=a[i];
a[i]=a[i+1];
a[i+1]=k;
k=b[i];
b[i]=b[i+1];
b[i+1]=k;
s=p[i];
p[i]=p[i+1];
p[i+1]=s;
}
}
}
int c[]=new int[n];
for(i=0;i<n;i++)
{
if(i==0)
{
c[i]=a[i]+b[i];
}
else
{
if(c[i-1]>=c[i])
{
c[i]=c[i-1]+b[i];
}
else
{
c[i]=a[i]+b[i];
}
}
}
int t[]=new int[n];
int w[]=new int[n];
float s1=0,s2=0;
float avgt,avgw;
for(i=0;i<n;i++)
{
t[i]=c[i]-a[i];
w[i]=t[i]-b[i];
}
for(i=0;i<n;i++)
{
s1=s1+t[i];
s2=s2+w[i];
}
avgt=s1/n;
avgw=s2/n;
System.out.println("Process_id-Arrival time-Burst time-Completion time-Waiting time-Turn around time");
for(i=0;i<n;i++)
{
System.out.println(p[i]+"         "+a[i]+"         "+b[i]+"          "+c[i]+"          "+w[i]+"        "+t[i]);
}
System.out.println("Average Turnaround time will be : "+avgt);
System.out.println("Average Waiting time will be : "+avgw);
System.out.println("Order of scheduling processs will be : ");
for(i=0;i<n;i++)
{
System.out.println(p[i]+" ");
} 
}
}
