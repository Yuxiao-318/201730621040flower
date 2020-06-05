package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2020-02-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016091500517039";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCveherLJtuz6kaIpjqK5UoIjCru4jLeCx9rCYDFGN8FIQEh0iHEHbEvZ15zb50wkuhBEFEoRkPLrsg/CdaYl2qQly+OoPqNqFgQhcRu1qYAjO8aJAlajOYaJkcrC67DUlAIsU/yl8j5tc8Ik5RYzN9BjT2zNIXRoxhwytCX5STJT2ZEvQfkFdG0Hduud5eFLGFuC/mhJU+rdP2i6KZsDluf73VYmqC0JUs3pX+bVS1IV85cWpS/7F7mNR7t9hYCMZ9UJa7NLxJhh5JElwgZRozF0rLIkSN4K04VL9IHxwBQU6mFvnyxLzpF9P4HdPbq3w1AVEGUWcF3OGnOS7qCNBTAgMBAAECggEAMmNp1oJ5o6lH0rRqmpunOh4PQdEZJ+w7Ql8jjzDUnHW7rx01y2sD39zfEnHtJdQBKZxyLYXhD0YJACDIICEs6k4iGZHt/VxwnJZ9z16wVgQT3R9dfRDw/evTQ7OBu77F8P/LClVPWpzX43GqcZ5904HrxY7tKTfd6djEXEvb+yB00ErHisCLvaC2QNDq5kXBqNc9qNdULfWEvHOnALdgw39Qk5cIaGLSs/y9L67RtqN0SwdxZDViJkKsf9uhgHvjPfeGJvmT8nsOZpwT/9Woh0BdHPkbpiyocBUf/XVUSjqWzG8PS0Hj/FGac3M4y2yYN68a8LziapT7wUkoty3RsQKBgQDwP3YhPeWgMnXaa9vySUXVdT8O7b7Vv8XGrnfV6P4nlUmgLQaej2l8ju2YqnfbDXOMpWN8r6TSMhaUlwXFFhEL5yllcSFenk42O3VPYqOhkJK2YhIEkFC2+nH8DpXl7m1Tp8U0D/wxMddFccW+oiUHwGL72T0GZZiAvttBD5bGaQKBgQC6+3TOIHHcQUCQjpjuJXoLTOZ3ENY4p/qVbGuFWYHMfLHIPnZgpHkv8vum9H205Bo6XV9ybKVKdWU1uXZu/yEnkHhZGW8bgG+giB432efT2JQqA75IIo8frkuriJSL0ixfx59iJHGhks0N8ieLCKuqK8u35a2rrrxM6D7i7N7hWwKBgGq954BxfdqlUNOQ5JJLl+l1RGUfoJBbukXCMqAp+vIfVC0ElFJSqa2b21jfNI1w9ovg18kISRTTCFFQoFGmskA1nqDhmM/vShSyajaxPr6D+4tpG1RHwnTp5Ub2PAeC3bQzcFznVUeOO3UxTYibhhRhmBkJtiFndlCNe+D2SikxAoGAQFKahwJQSPXFkTUM1PfdeR+2NIV9PDZFFLwcbN4ysba/reQW8v4BloYfHfsDd4P0pdlTKVjIr8mczJOFc3+e1y5yyCvgtfRD8lSBGLOEdbMOnTl2bvg8hih+bX7powPlMfnJEYj58hw/ICoKgmC0NTElvphrWyEcM9S9NXFI5vsCgYEAxnYChqJ+4VXuNBF9wc6oebRYgGYWMEv0uhqa/7A0o6vsvXrd7QtQTdyeYxpBQLcsFJkKc1n5MFsrSY6FAFTVmBPMnYfQwH0OAYxKfytles3wMVxWbAwJwtxhZ1n3nGFHCES8rwPSa+5xZe6vzpYVUTgnjBfr4QL3dlQJKj51a+0=";	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtHjQ2gD1juu9F5Hxr1oy5c8So9EC7G6OlK4rJf98kvFj1GaDxUp9/WY7YMThC1VqTZn+T9FiEO7CI8/EXjiF/4n64NYtJFOtT7dplmQwoVHE5dOvprfR1ugUbeHLcQlUvbctKELCDrUHTe3/p2rCIH7TwKQoUOpP6yunyHardPOddUJEC4C7wZ11KwzTDaa1pU3kLb0Z/0DEte63aEq3fyt1M5UFD5sQgN7FZuW3s7sy5jaIJgkZbNTIl/lpcrNjPGXxZmK6qfiiA8LSFgQj2A0UPSNtDLdUnO0I211tWRfUVVDzviIdV1T9k+JhlPhLsYGRFTvsa9cRgwWL/lt7BQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 	public static String notify_url = "http://localhost:8080/Rosemary/notify_url.jsp";

 	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 	public static String return_url = "http://localhost:8080/Rosemary/index/success.jsp";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
			
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

