package DemoExtends;

public class main {
    public static void main(String[] args) {
         Fu f=new Zi();//此处java的重写和C#一直 但是要注意的是 java不需要写Override @Override只是一个注解
        //他仅仅是编译的时候检查这个重写是否规范
         f.showName();//打印出来的是子类的showName


    }
}
