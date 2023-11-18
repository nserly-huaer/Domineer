package ReadArgs;
class Cast {
    /**
     * Error如果为true，表示该参数长度为0
     * cache保存为String二维数组
     * args表示參數
     */
    static boolean Error;
    static String[][] cache;
    private static String[] args;

    Cast(String[] args) {
        //如果数组长度不为0则将值传递给args，否则将Error赋值true
        if (args.length != 0) {
            Cast.args = args;
        } else {
            Error = true;
        }

    }

    void RunCast() {
        //如果没有参数就直接跳过
        if (Error)
            return;
        StringBuffer str = new StringBuffer();//創建StringBuffer对象
        for (int i = 0; i < args.length; i++) {
            //将所有参数转换为一排
            str.append(args[i]);
        }
        //分割，将每一条参数转换为数组
        String[] CastToDel = str.toString().split("--");
        //创建二维数组，初始长度为参数行数
        cache = new String[CastToDel.length][];
        //将其转换为cache数组，cache[0]为参数名;cache[1]为参数值
        for (int i = 0; i < CastToDel.length; i++) {
            cache[i] = CastToDel[i].split(":", 2);
        }
    }
}
