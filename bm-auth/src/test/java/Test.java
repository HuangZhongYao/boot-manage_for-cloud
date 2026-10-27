import cn.hutool.crypto.digest.DigestUtil;

public class Test {
    public static void main(String[] args) {
        String bcrypt = DigestUtil.bcrypt("123456");
        System.out.println("bcrypt = " + bcrypt);
    }
}
