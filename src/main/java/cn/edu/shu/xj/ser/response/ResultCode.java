package cn.edu.shu.xj.ser.response;

public enum ResultCode implements CustomizeResultCode{

    SUCCESS(200,"成功"),
    ERROR(201,"失败"),
    JWT_WRONG(401, "JWT出错"),
    PAGE_NOT_FOUND(404, "你要请求的页面好像暂时飘走了...要不试试请求其它页面?"),
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?"),

    ARITHMETIC_EXCEPTION(3000,"算数异常"),
    NO_TOKEN(3001,"无token，请重新登录"),
    NO_USER(3002,"该学号尚未有用户注册"),
    ADMIN_ACCOUNT_NOT_EXIST(3003, "管理员账号不存在"),
    ADMIN_PASSWORD_ERROR(3004, "管理员密码错误"),
    DIFFERENT_PASSWORD(3005,"用户注册输入两次密码不相同"),
    USER_ACCOUNT_EXIST(3006,"用户名已存在"),
    SORT_EXIST(3007,"分类名字已存在"),
    USER_NO_ACCOUNT_EXIST(3008,"用户名不存在"),
    USER_PASSWORD_ERROR(3009,"用户名密码错误"),
    UNKNOW_SERVER_ERROR(2001, "未知异常,请联系管理员!");




    private Integer code;

    private String message;

    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
