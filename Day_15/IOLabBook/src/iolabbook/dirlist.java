package iolabbook;

class dirlist{
public static void main(String args[]){
String dirname=“/java”;
File f1=new File(dirname);
if(f1.isDirectory()){
String s[]=f1.list();
for(int I=0;I<s.length;I++)
{ System.out.println(s[I]); }  }  }

