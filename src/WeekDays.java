/**
 * Java枚举类型是一种类，是引用类型，具有了面向对象特性，可以添加方法和成员变量等。
 * Java枚举类型父类是java.lang.Enum，不需要显式声明。
 * Java枚举类型可以实现接口，与类实现接口类似。
 * Java枚举类型不能被继承，不存在子类。
 */
public enum WeekDays {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    //不能有抽象方法
}
//WeekDays day = WeekDays.FRIDAY;
//switch表达式类型和case常量类型只能是int、 byte、short和char类型、枚举
//枚举类与switch语句能够很好地配合使用

//switch语句中的case分支语句个数应该对 应枚举常量个数，不要多也不要少，当使用 default时，default应该只表示等于最后一个枚举常量情况。
