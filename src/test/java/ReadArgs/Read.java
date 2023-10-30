package ReadArgs;

import java.util.HashMap;
import java.util.Map;

public class Read {
    /*
    传入的参数规定：
    开头--
    参数名末尾用:
    值末尾要加空格

    实例：--Name:Peter --RunFast:true --StartLog:false
     */

    /**
     * @param args java运行输入参数
     * @return 返回为Map对象，键是参数名；值是参数值
     * 获取输入值可以通过Map对象.get(参数名)来获取
     * 判断Map是否包含某个键可以通过Map对象.containsKey(参数)来获取
     * 删除Map中的键值可以用Map对象.remove(参数名)来删除
     * <p>
     * 遍历Map中的键值可以通过
     * for (Map.Entry<String, String> entry : map.entrySet()) {
     * String key = entry.getKey();
     * String value = entry.getValue();
     * System.out.println(key + ": " + value);
     * }
     * 获取Map的大小（键值对个数）可以通过Map对象.size()方法获取，返回值为int数据类型
     * @Methon Read 将参数转换成Map数据类型，方便使用
     * <p>
     * 注意：如果该参数长度为0，则返回null!
     */

    public static Map<String, String> Read(String[] args) {
        //创建对象，实例化
        Cast c = new Cast(args);
        //运行转换，将其转换为二维数组
        c.RunCast();
        //调用Cast的Error全局变量，如果为true，返回null
        if (Cast.Error)
            return null;
        //如果不是就创建Map对象
        Map<String, String> m = new HashMap();
        //将数组[0]赋值给键，将数组[1]赋值给值
        for (int i = 0; i < Cast.cache.length; i++) {
            m.put(Cast.cache[i][0], Cast.cache[i][1]);
        }
        //返回结果
        return m;

    }
}
