import java.time.ZonedDateTime;

/**
 * @author: xiachao
 * @Date: 2022-07-01 21:50
 * @Description:
 */
public class TestTime {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
