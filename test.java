public class test
{
    public static void main(String[] args)
    {
        char myChar = 'a';
        change(myChar);
        System.out.println(myChar);
    }
    public static void change(char charParam)
    {
        charParam = 'z';
    }
}
